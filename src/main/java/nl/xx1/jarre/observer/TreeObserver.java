package nl.xx1.jarre.observer;

import org.objectweb.asm.tree.ClassNode;

public interface TreeObserver {
    void update(ClassNode classNode);
}
