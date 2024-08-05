package nl.xx1.jarre.gui.tree;

import javax.swing.tree.DefaultMutableTreeNode;
import org.objectweb.asm.tree.FieldNode;

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
