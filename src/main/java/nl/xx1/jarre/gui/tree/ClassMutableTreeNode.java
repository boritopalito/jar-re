package nl.xx1.jarre.gui.tree;

import javax.swing.tree.DefaultMutableTreeNode;
import org.objectweb.asm.tree.ClassNode;

public class ClassMutableTreeNode extends DefaultMutableTreeNode {
    private final ClassNode classNode;

    public ClassMutableTreeNode(ClassNode classNode) {
        super(classNode.name + ".class");
        this.classNode = classNode;
    }

    public ClassNode getClassNode() {
        return classNode;
    }
}
