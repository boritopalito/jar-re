package nl.xx1.jarre.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import nl.xx1.jarre.event.EventBus;
import nl.xx1.jarre.event.EventType;
import nl.xx1.jarre.gui.tree.ClassMutableTreeNode;
import nl.xx1.jarre.gui.tree.TreePanel;
import nl.xx1.jarre.model.DroppedFile;
import nl.xx1.jarre.observer.TreeObserver;
import nl.xx1.jarre.utilities.JarUtilities;
import org.objectweb.asm.tree.ClassNode;

public class TreeController extends BaseController<TreePanel> {
    private final List<TreeObserver> observers = new ArrayList<>();

    public TreeController(TreePanel treePanel) {
        super(treePanel);
        addListeners();
        EventBus.getInstance().subscribe(EventType.FILE_SELECTED, this::updateTree);
    }

    public void addTreeSelectionListeners(TreeObserver... treeObservers) {
        for (TreeObserver treeObserver : treeObservers) {
            addTreeSelectionListener(treeObserver);
        }
    }

    public void addTreeSelectionListener(TreeObserver treeObserver) {
        observers.add(treeObserver);
    }

    private void notifyObservers(ClassNode classNode) {
        observers.forEach(o -> o.update(classNode));
    }

    private void updateTree(Object data) {
        if (data instanceof File file) {
            DroppedFile droppedFile = JarUtilities.getClasses(file);
            DefaultMutableTreeNode jarNode = new DefaultMutableTreeNode(droppedFile.getName());
            for (ClassNode classNode : droppedFile.getClassNodeList()) {
                DefaultMutableTreeNode classNodeTree = new ClassMutableTreeNode(classNode);
                jarNode.add(classNodeTree);
            }

            getComponent().getTreeModel().setRoot(jarNode);
            getComponent().getTree().setModel(getComponent().getTreeModel());
        }
    }

    private void addListeners() {
        JTree tree = getComponent().getTree();
        tree.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (selectedNode == null) {
                    return;
                }

                if (selectedNode instanceof ClassMutableTreeNode classMutableTreeNode) {
                    notifyObservers(classMutableTreeNode.getClassNode());
                }
            }
        });
    }
}
