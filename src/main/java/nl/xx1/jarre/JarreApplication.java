package nl.xx1.jarre;

import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;
import javax.swing.*;
import nl.xx1.jarre.gui.MainWindow;

public class JarreApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FlatDarkFlatIJTheme.setup();
            new MainWindow();
        });
    }
}
