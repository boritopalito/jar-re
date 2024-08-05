package nl.xx1.jarre.gui.tree;

import javax.swing.tree.DefaultMutableTreeNode;
import org.objectweb.asm.tree.MethodNode;

public class MethodMutableTreeNode extends DefaultMutableTreeNode {
    private final MethodNode methodNode;

    public MethodMutableTreeNode(MethodNode methodNode) {
        super(String.format("%s %s", methodNode.name, methodNode.desc));
        this.methodNode = methodNode;
    }

    public MethodNode getMethodNode() {
        return methodNode;
    }
}
