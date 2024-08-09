package nl.xx1.jarre.controller;

import java.io.File;
import nl.xx1.jarre.event.EventBus;
import nl.xx1.jarre.event.EventType;
import nl.xx1.jarre.event.Subscribe;
import nl.xx1.jarre.events.FileSelected;

public class FileContentController {
    public FileContentController() {
        EventBus.getInstance().subscribe(EventType.FILE_SELECTED, this::handleFileSelected);
    }

    private void handleFileSelected(Object data) {
        if (data instanceof File file) {
            System.out.println("new file selected");
        }
    }

    @Subscribe
    private void onFileSelected(FileSelected fileSelected) {
        System.out.println(fileSelected);
    }
}
