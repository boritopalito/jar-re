package nl.xx1.jarre.gui.highlighter;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.text.DefaultHighlighter;

public class TextPaneHighlighter {
    private final JTextPane jTextPane;
    private final List<CustomHighlighter> highlighters;

    public TextPaneHighlighter(JTextPane jTextPane) {
        this.jTextPane = jTextPane;
        this.highlighters = new ArrayList<>();
    }

    public void addHighlighter(CustomHighlighter highlighter) {
        highlighters.add(highlighter);
    }

    public void highlight() {
        DefaultHighlighter highlighter = new DefaultHighlighter();
        jTextPane.setHighlighter(highlighter);

        for (CustomHighlighter customHighlighter : highlighters) {
            try {
                customHighlighter.highlight(jTextPane, highlighter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
