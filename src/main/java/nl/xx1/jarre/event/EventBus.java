package nl.xx1.jarre.event;

import com.google.common.base.Preconditions;
import java.lang.reflect.Method;
import java.util.*;

public class EventBus {
    private static final EventBus INSTANCE = new EventBus();

    private final Map<Class<?>, List<Subscriber>> subscribers = new HashMap<>();

    private EventBus() {}

    public void register(final Object object) {
        Method[] methods = object.getClass().getDeclaredMethods();

        for (final Method method : methods) {
            if (!method.isAnnotationPresent(Subscribe.class)) continue;

            // Expand this with additional checks
            Preconditions.checkArgument(
                    method.getReturnType() == Void.TYPE,
                    String.format(
                            "A @Subscribed method (%s) cannot return anything. The return type now is %s.",
                            method.getName(), method.getReturnType().toString()));

            Preconditions.checkArgument(
                    method.getParameterCount() == 1,
                    String.format(
                            "A @Subscribed method (%s) can only have 1 parameter. The parameter count now is %d.",
                            method.getName(), method.getParameterCount()));

            final Class<?> parameterClazz = method.getParameterTypes()[0];

            final String expectedName = String.format("on%s", parameterClazz.getSimpleName());

            Preconditions.checkArgument(
                    method.getName().equals(expectedName),
                    String.format("A @Subscribed method (%s) should be named as %s.", method.getName(), expectedName));

            method.setAccessible(true);

            final Subscriber subscriber =
                    new Subscriber.Builder().method(method).object(object).build();

            subscribers
                    .computeIfAbsent(parameterClazz, e -> new ArrayList<Subscriber>())
                    .add(subscriber);
        }
    }

    public void post(final Object object) {
        List<Subscriber> s = subscribers.get(object.getClass());

        if (s == null) {
            System.out.println("No subscribers found.");
            return;
        }

        s.forEach(subscriber -> {
            subscriber.invoke(object);
        });
    }

    public static EventBus getInstance() {
        return INSTANCE;
    }
}
