package service;

import java.io.File;

public class ImageQueue extends Thread {
    private File[] files;
    private String dstFolder;

    public ImageQueue(File[] files, String dstFolder) {
        this.files = files;
        this.dstFolder = dstFolder;
    }

    @Override
    public void run() {
        new Resizer().resize(files, dstFolder);
    }
}
