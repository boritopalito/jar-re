package nl.xx1.jarre.gui.highlighter.impl;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.text.*;
import nl.xx1.jarre.gui.highlighter.CustomHighlighter;

public class SyntaxHighlighter implements CustomHighlighter {
    private final Color keywordColor = new Color(207, 142, 109);
    private final Color commentColor = new Color(122, 126, 133);
    private final Color stringColor = new Color(106, 171, 115);

    private final List<String> keywords = Arrays.asList(
            "abstract",
            "assert",
            "boolean",
            "break",
            "byte",
            "case",
            "catch",
            "char",
            "class",
            "const",
            "continue",
            "default",
            "do",
            "double",
            "else",
            "enum",
            "extends",
            "final",
            "finally",
            "float",
            "for",
            "goto",
            "if",
            "implements",
            "import",
            "instanceof",
            "int",
            "interface",
            "long",
            "native",
            "new",
            "null",
            "package",
            "private",
            "protected",
            "public",
            "return",
            "short",
            "static",
            "strictfp",
            "super",
            "switch",
            "synchronized",
            "this",
            "throw",
            "throws",
            "transient",
            "try",
            "void",
            "volatile",
            "while",
            "true",
            "false");

    @Override
    public void highlight(JTextPane textPane, Highlighter highlighter) throws BadLocationException {
        highlightKeywords(textPane);
        highlightComments(textPane);
        highlightStrings(textPane);
    }

    private void highlightStrings(JTextPane textPane) {
        Pattern pattern = Pattern.compile("\".*?\"");
        Matcher matcher = pattern.matcher(textPane.getText());
        while (matcher.find()) {
            setTextColor(textPane, matcher.start(), matcher.end() - matcher.start(), stringColor);
        }
    }

    private void highlightComments(JTextPane textPane) {
        String text = textPane.getText();
        int pos = 0;
        while ((pos = text.indexOf("//", pos)) >= 0) {
            int end = text.indexOf("\n", pos);
            if (end < 0) {
                end = text.length();
            }
            setTextColor(textPane, pos, end - pos, commentColor);
            pos = end;
        }
    }

    private void highlightKeywords(JTextPane textPane) {
        String text = textPane.getText();
        for (String keyword : keywords) {
            int pos = 0;
            while ((pos = text.indexOf(keyword, pos)) >= 0) {
                pos += keyword.length();
                setTextColor(textPane, pos - keyword.length(), keyword.length(), keywordColor);
            }
        }
    }

    private void setTextColor(JTextPane textPane, int start, int end, Color color) {
        StyledDocument document = textPane.getStyledDocument();
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        StyleConstants.setForeground(attributeSet, color);
        document.setCharacterAttributes(start, end, attributeSet, false);
    }
}
