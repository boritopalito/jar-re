package nl.xx1.jarre.gui.highlighter;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Highlighter;

public interface CustomHighlighter {
    void highlight(JTextPane textPane, Highlighter highlighter) throws BadLocationException;
}
