package app;

import app.controller.FileService;

public class AppStart {
    public static void main(String[] args) {
        FileService fileService = new FileService();
        fileService.startService();

    }

}
