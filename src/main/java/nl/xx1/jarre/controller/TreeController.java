package nl.xx1.jarre.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import nl.xx1.jarre.event.EventBus;
import nl.xx1.jarre.event.Subscribe;
import nl.xx1.jarre.events.FileSelected;
import nl.xx1.jarre.events.TreeOptionChosen;
import nl.xx1.jarre.gui.tree.ClassMutableTreeNode;
import nl.xx1.jarre.gui.tree.TreePanel;
import nl.xx1.jarre.model.DroppedFile;
import nl.xx1.jarre.utilities.JarUtilities;
import org.objectweb.asm.tree.ClassNode;

public class TreeController extends BaseController<TreePanel> {

    public TreeController(TreePanel treePanel) {
        super(treePanel);
        addListeners();
    }

    @Subscribe
    private void onFileSelected(FileSelected fileSelected) {
        DroppedFile droppedFile = JarUtilities.getClasses(fileSelected.getFile());
        DefaultMutableTreeNode jarNode = new DefaultMutableTreeNode(droppedFile.getName());
        for (ClassNode classNode : droppedFile.getClassNodeList()) {
            DefaultMutableTreeNode classNodeTree = new ClassMutableTreeNode(classNode);
            jarNode.add(classNodeTree);
        }

        getComponent().getTreeModel().setRoot(jarNode);
        getComponent().getTree().setModel(getComponent().getTreeModel());
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
                    TreeOptionChosen event = new TreeOptionChosen(classMutableTreeNode.getClassNode());
                    EventBus.getInstance().post(event);
                }
            }
        });
    }
}
