package nl.xx1.jarre.gui.menu;

import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuBar extends JMenuBar {
    private final JMenuItem openNewFile;

    public MenuBar() {
        JMenu file = new JMenu("File");
        openNewFile = new JMenuItem("Open");
        file.add(openNewFile);

        add(file);
    }

    public void setOpenFileListener(ActionListener l) {
        openNewFile.addActionListener(l);
    }
}
