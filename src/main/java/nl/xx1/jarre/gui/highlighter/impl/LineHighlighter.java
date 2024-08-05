package nl.xx1.jarre.gui.highlighter.impl;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import nl.xx1.jarre.gui.highlighter.CustomHighlighter;

public class LineHighlighter implements CustomHighlighter {
    @Override
    public void highlight(JTextPane textPane, Highlighter highlighter) throws BadLocationException {
        int caretPosition = textPane.getCaretPosition();
        int lineStartOffset = getLineStartOffset(textPane, caretPosition);
        int lineEndOffset = getLineEndOffset(textPane, caretPosition);
        highlighter.addHighlight(
                lineStartOffset,
                lineEndOffset,
                new DefaultHighlighter.DefaultHighlightPainter(new Color(255, 255, 204)));
    }

    private int getLineStartOffset(JTextComponent textComponent, int position) throws BadLocationException {
        Element root = textComponent.getDocument().getDefaultRootElement();
        int line = root.getElementIndex(position);
        return root.getElement(line).getStartOffset();
    }

    private int getLineEndOffset(JTextComponent textComponent, int position) throws BadLocationException {
        Element root = textComponent.getDocument().getDefaultRootElement();
        int line = root.getElementIndex(position);
        return root.getElement(line).getEndOffset();
    }
}
