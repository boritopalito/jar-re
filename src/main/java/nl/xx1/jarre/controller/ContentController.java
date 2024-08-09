package nl.xx1.jarre.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import nl.xx1.jarre.event.Subscribe;
import nl.xx1.jarre.events.TreeOptionChosen;
import nl.xx1.jarre.gui.content.ContentPanel;
import nl.xx1.jarre.gui.highlighter.TextPaneHighlighter;
import nl.xx1.jarre.gui.highlighter.impl.SyntaxHighlighter;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.util.Textifier;
import org.objectweb.asm.util.TraceClassVisitor;

public class ContentController extends BaseController<ContentPanel> {
    private final TextPaneHighlighter textPaneHighlighter;

    public ContentController(ContentPanel contentPanel) {
        super(contentPanel);
        textPaneHighlighter = new TextPaneHighlighter(getComponent().getTextPane());
        textPaneHighlighter.addHighlighter(new SyntaxHighlighter());
    }

    private void display(ClassNode classNode) {
        StyledDocument document = getComponent().getDocument();

        try {
            document.remove(0, document.getLength());
        } catch (BadLocationException e) {
            throw new RuntimeException(e);
        }

        JTextPane textPane = getComponent().getTextPane();

        document.setCharacterAttributes(0, document.getLength(), null, true);
        textPane.selectAll();

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        Textifier textifier = new Textifier();
        TraceClassVisitor traceClassVisitor = new TraceClassVisitor(null, textifier, printWriter);
        classNode.accept(traceClassVisitor);

        printWriter.flush();
        String text = stringWriter.toString();

        textPane.setText(text);
        textPane.setCaretPosition(0);

        textPaneHighlighter.highlight();
    }

    @Subscribe
    private void onTreeOptionChosen(TreeOptionChosen treeOptionChosen) {
        display(treeOptionChosen.getOption());
    }
}
