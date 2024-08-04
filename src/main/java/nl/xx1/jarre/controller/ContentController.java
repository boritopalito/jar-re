package nl.xx1.jarre.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import nl.xx1.jarre.gui.content.ContentPanel;
import nl.xx1.jarre.gui.highlighter.TextPaneHighlighter;
import nl.xx1.jarre.gui.highlighter.impl.SyntaxHighlighter;
import nl.xx1.jarre.observer.TreeObserver;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.util.Textifier;
import org.objectweb.asm.util.TraceClassVisitor;

public class ContentController extends BaseController<ContentPanel> implements TreeObserver {
    private final TextPaneHighlighter textPaneHighlighter;
    private static final ContentController INSTANCE = new ContentController();

    private ContentController() {
        super(new ContentPanel());
        TreeController.getInstance().addObserver(this);
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

    @Override
    public void update(ClassNode classNode) {
        display(classNode);
    }

    public static ContentController getInstance() {
        return INSTANCE;
    }
}