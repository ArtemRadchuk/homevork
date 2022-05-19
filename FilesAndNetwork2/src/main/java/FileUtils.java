import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {
        // TODO: write code copy content of sourceDirectory to destinationDirectory
        fileValidate(sourceDirectory);
        fileValidate(destinationDirectory);
        File srcFile = new File(sourceDirectory);
        File dstFile = new File(destinationDirectory);
        for (File f : srcFile.listFiles()) {
            if (f.isFile()) {
                Path src = Paths.get(f.getPath());
                Path dst = Paths.get(dstFile.getPath() + "\\" + f.getName());
                try {
                    Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("файл создан");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Не удалось копировать файл");
                }
            } else {
                Path dst = Paths.get(dstFile.getPath() + "\\" + f.getName());
                try {
                    System.out.println("Копируем");
                    Files.createDirectory(dst);
                    FileUtils.copyFolder(f.getPath(), dst.toString());
                    System.out.println("Директория скопирована");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Не удалось создать директорию " + dst);
                    break;
                }
            }
        }
    }


    private static void fileValidate(String inputFile) {
        try {
            File file = new File(inputFile);
        } catch (Exception e) {
            System.out.println("Файл не найден");
            e.printStackTrace();
        }
    }
}
