package nl.xx1.jarre;

import com.formdev.flatlaf.fonts.jetbrains_mono.FlatJetBrainsMonoFont;
import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;
import com.formdev.flatlaf.util.SystemInfo;
import javax.swing.*;
import nl.xx1.jarre.gui.FontManager;
import nl.xx1.jarre.gui.MainWindow;

public class JarreApplication {
    public static void main(String[] args) {
        if (SystemInfo.isMacOS) {
            System.setProperty("apple.awt.application.appearance", "NSAppearanceNameDarkAqua");
            System.setProperty("apple.awt.application.name", "JAR-RE");
            System.setProperty("apple.laf.useScreenMenuBar", String.valueOf(true));
        }

        SwingUtilities.invokeLater(() -> {
            FontManager.loadFonts();
            FlatJetBrainsMonoFont.install();
            FlatDarkFlatIJTheme.setup();
            new MainWindow();
        });
    }
}
