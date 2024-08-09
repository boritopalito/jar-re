package nl.xx1.jarre.events;

import org.objectweb.asm.tree.ClassNode;

public class TreeOptionChosen {
    private final ClassNode classNode;

    public TreeOptionChosen(ClassNode classNode) {
        this.classNode = classNode;
    }

    public ClassNode getOption() {
        return classNode;
    }
}
