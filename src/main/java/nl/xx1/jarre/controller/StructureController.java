package nl.xx1.jarre.controller;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import nl.xx1.jarre.gui.structure.StructurePanel;
import nl.xx1.jarre.gui.tree.FieldMutableTreeNode;
import nl.xx1.jarre.gui.tree.MethodMutableTreeNode;
import nl.xx1.jarre.observer.TreeObserver;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

public class StructureController extends BaseController<StructurePanel> implements TreeObserver {
    private static final StructureController INSTANCE = new StructureController();

    private StructureController() {
        super(new StructurePanel());
        TreeController.getInstance().addObserver(this);
    }

    @Override
    public void update(ClassNode classNode) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(classNode.name);
        for (MethodNode methodNode : classNode.methods) {
            DefaultMutableTreeNode node = new MethodMutableTreeNode(methodNode);
            root.add(node);
        }

        for (FieldNode  fieldNode : classNode.fields) {
            DefaultMutableTreeNode node = new FieldMutableTreeNode(fieldNode);
            root.add(node);
        }
        DefaultTreeModel defaultTreeModel = new DefaultTreeModel(root);
        getComponent().getTree().setModel(defaultTreeModel);
    }

    public static StructureController getInstance() {
        return INSTANCE;
    }
}