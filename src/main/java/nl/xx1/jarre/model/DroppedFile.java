package nl.xx1.jarre.model;

import java.util.List;
import org.objectweb.asm.tree.ClassNode;

public class DroppedFile {
    private final String name;
    private final List<ClassNode> classNodeList;

    public DroppedFile(String name, List<ClassNode> classNodeList) {
        this.name = name;
        this.classNodeList = classNodeList;
    }

    public String getName() {
        return name;
    }

    public List<ClassNode> getClassNodeList() {
        return classNodeList;
    }
}
