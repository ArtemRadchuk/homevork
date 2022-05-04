import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Objects;

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
        String srcFolder = "/users/sortedmap/Desktop/src";
        String dstFolder = "/users/sortedmap/Desktop/dst";
        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();
        int step = (files).length / Runtime.getRuntime().availableProcessors();


        int var = 0;
        File[] temp = new File[step];

        for (File file : files) {
            temp[var++] = file;
            if (var == step) {
                new imageQueue(temp, dstFolder).start();
                temp = new File[step];
                var = 0;
            }
        }
    }
}
