package nl.xx1.jarre.gui.content;

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
