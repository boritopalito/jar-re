package nl.xx1.jarre.gui.content;

import nl.xx1.jarre.gui.FontManager;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import javax.swing.*;
import javax.swing.text.StyledDocument;

public class ContentPanel extends JScrollPane {
    private StyledDocument styledDocument;
    private final JTextPane contentPane;

    public ContentPanel() {
        setBorder(null);
        contentPane = new JTextPane();
        contentPane.setBackground(new Color(30, 31, 34));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));
        contentPane.setEditable(false);

        setViewportView(contentPane);

        styledDocument = contentPane.getStyledDocument();

        contentPane.setFont(FontManager.getDefault().deriveFont(13f));
    }

    public StyledDocument getDocument() {
        return styledDocument;
    }

    public JTextPane getTextPane() {
        return contentPane;
    }
}
