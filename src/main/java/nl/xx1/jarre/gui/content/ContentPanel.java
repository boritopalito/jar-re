package nl.xx1.jarre.gui.content;

import javax.swing.*;
import javax.swing.text.StyledDocument;

public class ContentPanel extends JScrollPane {
    private StyledDocument styledDocument;
    private final JTextPane contentPane;

    public ContentPanel() {
        contentPane = new JTextPane();
        add(contentPane);

        styledDocument = contentPane.getStyledDocument();
    }
}
