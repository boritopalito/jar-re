package nl.xx1.jarre.events;

import java.io.File;

public class FileSelected {
    private final File file;

    public FileSelected(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    @Override
    public String toString() {
        return "FileSelected{" +
                "file=" + file +
                '}';
    }
}
