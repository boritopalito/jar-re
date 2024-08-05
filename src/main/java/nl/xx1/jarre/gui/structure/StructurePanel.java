package nl.xx1.jarre.gui.structure;

import nl.xx1.jarre.gui.tree.CustomTreeCellRenderer;

import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class StructurePanel extends JPanel {
    private final JScrollPane jScrollPane;
    private final JTree tree;

    public StructurePanel() {
        setLayout(new BorderLayout());
        jScrollPane = new JScrollPane();
        jScrollPane.setBorder(BorderFactory.createEmptyBorder());
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        tree = new JTree(root);
        tree.setCellRenderer(new CustomTreeCellRenderer());

        jScrollPane.setViewportView(tree);
        add(jScrollPane);
    }

    public JTree getTree() {
        return tree;
    }
}