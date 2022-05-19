package service;

import java.io.File;

public class ResizeService {
    private final int PROCESSORS_QUANTITY = Runtime.getRuntime().availableProcessors();
    public void resize(String srcFolder, String dstFolder) {

        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();
        int step = (files).length / PROCESSORS_QUANTITY;
        int remains = (files).length % PROCESSORS_QUANTITY;
        int fileIndex = 0;
        for (int j = 0; j < PROCESSORS_QUANTITY; j++) {
            if (remains > 0) {
                step++;
                remains--;
            }
            File[] temp = new File[step];
            for (int i = 0; i < step; i++) {
                temp[i] = files[fileIndex];
                fileIndex++;
            }
            new ImageQueue(temp, dstFolder).start();
            step = (files).length / PROCESSORS_QUANTITY;
        }
    }
}
