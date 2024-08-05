package nl.xx1.jarre.listener;


import nl.xx1.jarre.event.TreeSelectionEvent;

import java.util.EventListener;

public interface TreeSelectionListener extends EventListener {
    void valueChanged(TreeSelectionEvent e);
}
