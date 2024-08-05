package nl.xx1.jarre.gui.tree;

import org.objectweb.asm.tree.FieldNode;

import javax.swing.tree.DefaultMutableTreeNode;

public class FieldMutableTreeNode extends DefaultMutableTreeNode {
    private final FieldNode fieldNode;

    public FieldMutableTreeNode(FieldNode fieldNode) {
        super(String.format("%s %s", fieldNode.name, fieldNode.desc));
        this.fieldNode = fieldNode;
    }

    public FieldNode getFieldNode() {
        return fieldNode;
    }
}
