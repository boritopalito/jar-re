package nl.xx1.jarre.gui.tree;

import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class TreePanel extends JPanel {
    private final JScrollPane jScrollPane;
    private final JTree tree;
    private final DefaultTreeModel treeModel;

    public TreePanel() {
        jScrollPane = new JScrollPane();
        setLayout(new BorderLayout());
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");

        tree = new JTree(root);
        tree.setRootVisible(false);
        jScrollPane.setViewportView(tree);
        treeModel = new DefaultTreeModel(root);
        jScrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(jScrollPane);
    }

    public JTree getTree() {
        return tree;
    }

    public DefaultTreeModel getTreeModel() {
        return treeModel;
    }
}
