package nl.xx1.jarre.gui;

import java.awt.*;
import javax.swing.*;
import nl.xx1.jarre.controller.ContentController;
import nl.xx1.jarre.controller.MenuBarController;
import nl.xx1.jarre.controller.StructureController;
import nl.xx1.jarre.controller.TreeController;
import nl.xx1.jarre.gui.content.ContentPanel;
import nl.xx1.jarre.gui.menu.MenuBar;
import nl.xx1.jarre.gui.structure.StructurePanel;
import nl.xx1.jarre.gui.tree.TreePanel;

public class MainWindow extends JFrame {
    private final JSplitPane splitPane;
    private final ContentController contentController;
    private final ContentPanel contentPanel;
    private final TreeController treeController;
    private final TreePanel treePanel;

    private final StructureController structureController;
    private final StructurePanel structurePanel;

    private final MenuBarController menuBarController;
    private final MenuBar menuBar;

    public MainWindow() {
        super("JAR-RE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1200, 800));

        menuBar = new MenuBar();
        menuBarController = new MenuBarController(menuBar);

        setJMenuBar(menuBar);

        setLocationRelativeTo(null);

        treePanel = new TreePanel();
        treeController = new TreeController(treePanel);

        contentPanel = new ContentPanel();
        contentController = new ContentController(contentPanel);

        structurePanel = new StructurePanel();
        structureController = new StructureController(structurePanel);

        treeController.addTreeSelectionListeners(contentController, structureController);

        JSplitPane leftPane = new JSplitPane();
        leftPane.setTopComponent(treePanel);
        leftPane.setBottomComponent(structurePanel);
        leftPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        leftPane.setDividerSize(0);
        leftPane.setDividerLocation(500);

        splitPane = new JSplitPane();
        splitPane.setLeftComponent(leftPane);
        splitPane.setDividerLocation(300);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.add(contentPanel, BorderLayout.CENTER);

        splitPane.setRightComponent(jPanel);

        add(splitPane);
        setVisible(true);
    }
}
