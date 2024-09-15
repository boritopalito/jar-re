package nl.xx1.jarre.gui.content;

import nl.xx1.jarre.gui.FontManager;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;
import javax.swing.text.StyledDocument;

public class ContentPanel extends JScrollPane {
    private StyledDocument styledDocument;
    private final JTextPane contentPane;
    private final JTextArea lineNumbers;

    public ContentPanel() {
        setBorder(null);
        contentPane = new JTextPane();
        contentPane.setBackground(new Color(30, 31, 34));
        contentPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
        contentPane.setEditable(false);

        lineNumbers = new JTextArea("1");
        lineNumbers.setBackground(new Color(40, 41, 44));
        lineNumbers.setForeground(new Color(150, 150, 150));
        lineNumbers.setEditable(false);
        lineNumbers.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

        Font font = FontManager.getDefault().deriveFont(13f);
        contentPane.setFont(font);
        lineNumbers.setFont(font);

        contentPane.setForeground(new Color(255, 255, 255));

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(lineNumbers, BorderLayout.WEST);
        panel.add(contentPane, BorderLayout.CENTER);

        setViewportView(panel);

        styledDocument = contentPane.getStyledDocument();

        contentPane.setFont(FontManager.getDefault().deriveFont(13f));

        contentPane.getDocument().addDocumentListener(new DocumentListener() {
            public String getText() {
                int caretPosition = contentPane.getDocument().getLength();
                Element root = contentPane.getDocument().getDefaultRootElement();
                String text = "1" + System.getProperty("line.separator");
                for (int i = 2; i < root.getElementIndex(caretPosition) + 2; i++) {
                    text += i + System.getProperty("line.separator");
                }
                return text;
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                lineNumbers.setText(getText());
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                lineNumbers.setText(getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                lineNumbers.setText(getText());
            }
        });
    }

    public StyledDocument getDocument() {
        return styledDocument;
    }

    public JTextPane getTextPane() {
        return contentPane;
    }
}
