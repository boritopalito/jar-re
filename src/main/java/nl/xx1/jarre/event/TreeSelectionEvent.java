package nl.xx1.jarre.event;

import org.objectweb.asm.tree.ClassNode;

import java.util.EventObject;

public class TreeSelectionEvent extends EventObject {
    private final ClassNode classNode;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public TreeSelectionEvent(Object source, ClassNode classNode) {
        super(source);
        this.classNode = classNode;
    }

    public ClassNode getClassNode() {
        return classNode;
    }
}
