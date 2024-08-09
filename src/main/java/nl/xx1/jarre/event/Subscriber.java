package nl.xx1.jarre.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Subscriber {
    private final Object object;
    private final Method method;

    private Subscriber(Builder builder) {
        this.object = builder.object;
        this.method = builder.method;
    }

    public void invoke(final Object arg) {
        try {
            method.invoke(object, arg);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static class Builder {
        private Object object;
        private Method method;

        public Builder object(Object object) {
            this.object = object;
            return this;
        }

        public Builder method(Method method) {
            this.method = method;
            return this;
        }

        public Subscriber build() {
            return new Subscriber(this);
        }
    }
}
