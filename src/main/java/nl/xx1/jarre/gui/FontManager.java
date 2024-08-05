package nl.xx1.jarre.gui;

import java.awt.*;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class FontManager {
    private static final String DEFAULT_FONT = "JetBrains Mono Regular";
    private static final HashMap<String, Font> fonts = new HashMap<>();

    public static void loadFonts() {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Path.of("src/main/resources/fonts"))) {
            for (Path path : stream) {
                if (Files.isDirectory(path)) {
                    continue;
                }

                Font font = Font.createFont(Font.TRUETYPE_FONT, path.toFile());
                fonts.put(font.getFontName(), font);

                GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
            }
        } catch (IOException | FontFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public static Font getFont(String font) {
        if (!fonts.containsKey(font)) {
            return getDefault();
        }

        return fonts.get(font);
    }

    public static Font getDefault() {
        return fonts.get(DEFAULT_FONT);
    }
}
