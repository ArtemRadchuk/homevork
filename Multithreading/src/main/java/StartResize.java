import java.io.File;

public class StartResize {
    public void resize(String srcFolder, String dstFolder) {
        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();
        int step = (files).length / Runtime.getRuntime().availableProcessors();
        int re = (files).length % Runtime.getRuntime().availableProcessors();
        int fileIndex = 0;
        for (int j = 0; j < Runtime.getRuntime().availableProcessors(); j++) {
            if (re > 0) {
                step++;
                re--;
            }
            File[] temp = new File[step];
            for (int i = 0; i < step; i++) {
                temp[i] = files[fileIndex];
                fileIndex++;
            }
            new ImageQueue(temp, dstFolder).start();
            step = (files).length / Runtime.getRuntime().availableProcessors();
        }
    }
}
