import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

class imageQueue extends Thread {
    private File[] files;
    private String dstFolder;

    public imageQueue(File[] files, String dstFolder) {
        this.files = files;
        this.dstFolder = dstFolder;
    }

    @Override
    public void run() {
        resize();
    }

    public void resize() {
        long start = System.currentTimeMillis();
        try {
            for (File file : files) {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }

                int newWidth = 300;
                int newHeight = (int) Math.round(
                        image.getHeight() / (image.getWidth() / (double) newWidth)
                );
                BufferedImage newImage = new BufferedImage(
                        newWidth, newHeight, BufferedImage.TYPE_INT_RGB
                );

                int widthStep = image.getWidth() / newWidth;
                int heightStep = image.getHeight() / newHeight;

                for (int x = 0; x < newWidth; x++) {
                    for (int y = 0; y < newHeight; y++) {
                        int rgb = image.getRGB(x * widthStep, y * heightStep);
                        newImage.setRGB(x, y, rgb);
                    }
                }

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Duration: " + (System.currentTimeMillis() - start));
    }
}


public class Main {

    public static void main(String[] args) {
        String srcFolder = "C:/Users/User/image";
        String dstFolder = "C:/Users/User/toImage";
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
            new imageQueue(temp, dstFolder).start();
            step = (files).length / Runtime.getRuntime().availableProcessors();
        }
    }
}
