package nl.xx1.jarre.controller;

import java.awt.*;
import nl.xx1.jarre.event.EventBus;

public class BaseController<T extends Component> {
    private final T component;

    public BaseController(T component) {
        this.component = component;
        EventBus.getInstance().register(this);
    }

    public T getComponent() {
        return component;
    }
}
