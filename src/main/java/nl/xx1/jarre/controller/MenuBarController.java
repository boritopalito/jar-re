package nl.xx1.jarre.controller;

import java.awt.*;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import nl.xx1.jarre.event.EventBus;
import nl.xx1.jarre.events.FileSelected;
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
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("JAR Files", "jar", ".class");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(fileNameExtensionFilter);
        int result = fileChooser.showOpenDialog(SwingUtilities.getWindowAncestor((Component) getComponent()));

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            FileSelected fileSelected = new FileSelected(selectedFile);
            EventBus.getInstance().post(fileSelected);
        }
    }
}
