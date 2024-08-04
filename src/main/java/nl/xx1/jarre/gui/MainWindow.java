package nl.xx1.jarre.gui;

import java.awt.*;
import javax.swing.*;
import nl.xx1.jarre.gui.content.ContentPanel;
import nl.xx1.jarre.gui.menu.MenuBar;
import nl.xx1.jarre.gui.tree.TreePanel;

public class MainWindow extends JFrame {
    private final JSplitPane splitPane;
    private final ContentPanel contentPanel;
    private final TreePanel treePanel;

    public MainWindow() {
        super("JAR-RE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1200, 800));

        setJMenuBar(new MenuBar());

        setLocationRelativeTo(null);

        contentPanel = new ContentPanel();
        treePanel = new TreePanel();

        splitPane = new JSplitPane();
        splitPane.setLeftComponent(treePanel);
        splitPane.setDividerLocation(300);
        splitPane.setRightComponent(contentPanel);

        add(splitPane);
        setVisible(true);
    }
}
