package nl.xx1.jarre.controller;

import nl.xx1.jarre.gui.menu.MenuBar;

public class MenuBarController extends BaseController<MenuBar> {
    private static final MenuBarController INSTANCE = new MenuBarController();

    private MenuBarController() {
        super(new MenuBar());
    }

    public static MenuBarController getInstance() {
        return INSTANCE;
    }
}
