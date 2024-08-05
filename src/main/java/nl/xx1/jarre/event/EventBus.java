package nl.xx1.jarre.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class EventBus {
    private static final EventBus INSTANCE = new EventBus();

    private final Map<EventType, List<Consumer<Object>>> listeners = new HashMap<>();

    private EventBus() {}

    public void subscribe(EventType eventType, Consumer<Object> listener) {
        listeners.computeIfAbsent(eventType, k -> new ArrayList<>()).add(listener);
    }

    public void publish(EventType eventType, Object data) {
        List<Consumer<Object>> eventListeners = listeners.get(eventType);

        if (eventListeners == null) return;

        for (Consumer<Object> listener : eventListeners) {
            listener.accept(data);
        }
    }

    public static EventBus getInstance() {
        return INSTANCE;
    }
}
