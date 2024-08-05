package nl.xx1.jarre.gui.tree;

import nl.xx1.jarre.gui.CompoundIcon;

import java.awt.*;
import java.lang.reflect.Modifier;
import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;

public class CustomTreeCellRenderer extends DefaultTreeCellRenderer {
    @Override
    public Component getTreeCellRendererComponent(
            JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Component c = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);


        if (value instanceof ClassMutableTreeNode classMutableTreeNode) {
            setIcon(new ImageIcon("src/main/resources/icons/class.png"));
        }

        if (value instanceof MethodMutableTreeNode methodMutableTreeNode) {
            Icon icon1 = new ImageIcon("src/main/resources/icons/method_dark.png");
            Icon icon2 = new ImageIcon("src/main/resources/icons/unlocked_dark.png");
            if (!Modifier.isPublic(methodMutableTreeNode.getMethodNode().access)) {
                icon2 = new ImageIcon("src/main/resources/icons/locked_dark.png");
            }

            setIcon(new CompoundIcon(icon1, icon2));
        }

        if (value instanceof FieldMutableTreeNode fieldMutableTreeNode) {
            Icon icon1 = new ImageIcon("src/main/resources/icons/field_dark.png");
            Icon icon2 = new ImageIcon("src/main/resources/icons/unlocked_dark.png");
            if (!Modifier.isPublic(fieldMutableTreeNode.getFieldNode().access)) {
                icon2 = new ImageIcon("src/main/resources/icons/locked_dark.png");
            }

            setIcon(new CompoundIcon(icon1, icon2));
        }

        return c;
    }
}
