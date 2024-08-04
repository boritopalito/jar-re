package nl.xx1.jarre.gui.content;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import javax.swing.*;
import javax.swing.text.StyledDocument;
import nl.xx1.jarre.gui.highlighter.TextPaneHighlighter;
import nl.xx1.jarre.gui.highlighter.impl.SyntaxHighlighter;

public class ContentPanel extends JScrollPane {
    private final TextPaneHighlighter textPaneHighlighter;
    private StyledDocument styledDocument;
    private final JTextPane contentPane;

    public ContentPanel() {
        contentPane = new JTextPane();
        contentPane.setBackground(new Color(30, 31, 34));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPane.setEditable(false);

        setViewportView(contentPane);

        styledDocument = contentPane.getStyledDocument();
        textPaneHighlighter = new TextPaneHighlighter(contentPane);
        textPaneHighlighter.addHighlighter(new SyntaxHighlighter());

        try {
            Font font = Font.createFont(
                    Font.TRUETYPE_FONT,
                    Objects.requireNonNull(getClass().getResourceAsStream("/fonts/JetBrainsMono-Regular.ttf")));
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
            contentPane.setFont(font.deriveFont(13f));
            contentPane.setForeground(new Color(255, 255, 255));
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public StyledDocument getDocument() {
        return styledDocument;
    }

    public JTextPane getTextPane() {
        return contentPane;
    }
}
