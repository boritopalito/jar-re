package nl.xx1.jarre.controller;

import java.io.File;
import nl.xx1.jarre.event.EventBus;
import nl.xx1.jarre.event.EventType;

public class FileContentController {
    public FileContentController() {
        EventBus.getInstance().subscribe(EventType.FILE_SELECTED, this::handleFileSelected);
    }

    private void handleFileSelected(Object data) {
        if (data instanceof File file) {
            System.out.println("new file selected");
        }
    }
}
