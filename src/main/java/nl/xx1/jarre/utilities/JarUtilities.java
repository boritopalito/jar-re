package nl.xx1.jarre.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;

public class JarUtilities {

    public static List<ClassNode> getClasses(File file) {
        try (JarFile jarFile = new JarFile(file)) {
            return getClasses(jarFile);
        } catch (IOException e) {
            throw new RuntimeException("There was an error opening your file: " + file.getName());
        }
    }

    public static List<ClassNode> getClasses(JarFile file) throws IOException {
        List<ClassNode> classNodes = new ArrayList<>();
        Enumeration<JarEntry> entries = file.entries();
        Iterator<JarEntry> iterator = entries.asIterator();

        while (iterator.hasNext()) {
            JarEntry jarEntry = iterator.next();

            if (!jarEntry.getName().endsWith(".class")) continue;

            ClassNode classNode = new ClassNode();
            ClassReader classReader = new ClassReader(file.getInputStream(jarEntry));
            classReader.accept(classNode, ClassReader.SKIP_FRAMES);
            classNodes.add(classNode);
        }
        return classNodes;
    }
}
