package nl.xx1.jarre.gui;

import java.awt.*;
import javax.swing.*;
import nl.xx1.jarre.controller.ContentController;
import nl.xx1.jarre.controller.TreeController;
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

        contentPanel = ContentController.getInstance().getComponent();
        treePanel = TreeController.getInstance().getComponent();

        splitPane = new JSplitPane();
        splitPane.setLeftComponent(treePanel);
        splitPane.setDividerLocation(300);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.add(contentPanel, BorderLayout.CENTER);

        splitPane.setRightComponent(jPanel);

        add(splitPane);
        setVisible(true);
    }
}
