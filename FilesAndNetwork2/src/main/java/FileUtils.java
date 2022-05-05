import net.sf.saxon.functions.Replace;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {
        // TODO: write code copy content of sourceDirectory to destinationDirectory
        File srcFile = new File(sourceDirectory);
        File destFile = new File(destinationDirectory);
        if (srcFile.isDirectory()) {
            for (File f : srcFile.listFiles()) {
                if (f.isFile()) {
                    Path src = Paths.get(f.getPath());
                    Path dst = Paths.get(destinationDirectory + "\\" + f.getName());
                    try {
                        Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (f.isDirectory()) {
                    Path dir = Paths.get(f.getAbsolutePath());

                    for (File f1 : f.listFiles()) {
                        Path src = Paths.get(f.getPath());
                        Path dst = Paths.get(f.getPath() + "\\" + f1.getName());
                        Files.copy(src, dir, StandardCopyOption.REPLACE_EXISTING);
                    }
                }
            }
        } else if (srcFile.isFile()) {
            for (File f : srcFile.listFiles()) {
                Path src = Paths.get(f.getAbsolutePath());
                Path dst = Paths.get(destinationDirectory + f.getName());
                Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }


    private static void directoryValidate(String directory) {
        try {
            File file = new File(directory);
        } catch (Exception e) {
            System.out.println("Файл не найден");
        }
    }
}
