package nl.xx1.jarre.controller;

import java.awt.*;
import java.io.File;
import javax.swing.*;
import nl.xx1.jarre.event.EventBus;
import nl.xx1.jarre.event.EventType;
import nl.xx1.jarre.gui.menu.MenuBar;

public class MenuBarController extends BaseController<MenuBar> {
    public MenuBarController(MenuBar menuBar) {
        super(menuBar);
        initListener();
    }

    private void initListener() {
        getComponent().setOpenFileListener(e -> onOpenFileDialog());
    }

    private void onOpenFileDialog() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(SwingUtilities.getWindowAncestor((Component) getComponent()));

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            EventBus.getInstance().publish(EventType.FILE_SELECTED, selectedFile);
        }
    }
}
