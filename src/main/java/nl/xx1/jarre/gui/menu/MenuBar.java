package nl.xx1.jarre.gui.menu;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    public MenuBar() {
        JMenu file = new JMenu("File");
        JMenuItem openNewFile = new JMenuItem("Open");
        file.add(openNewFile);

        add(file);
    }
}
