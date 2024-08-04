package nl.xx1.jarre.controller;

import java.awt.*;

public class BaseController<T extends Component> {
    private final T component;

    public BaseController(T component) {
        this.component = component;
    }

    public T getComponent() {
        return component;
    }
}
