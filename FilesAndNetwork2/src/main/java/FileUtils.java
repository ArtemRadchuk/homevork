import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {
        // TODO: write code copy content of sourceDirectory to destinationDirectory
        fileValidate(sourceDirectory);
        fileValidate(destinationDirectory);
        List<String> directories = new ArrayList<>();
        File srcFile = new File(sourceDirectory);
        File dstFile = new File(destinationDirectory);
        for (File f : srcFile.listFiles()) {
            if (f.isFile()) {
                Path src = Paths.get(f.getPath());
                Path dst = Paths.get(dstFile.getPath() + "\\" + f.getName());
                System.out.println("файл создан");
                try {
                    Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    System.out.println("Не удалось копировать файл");
                }
            } else if (f.isDirectory()) {
                Path dst = Paths.get(dstFile.getPath() + "\\" + f.getName());
                try {
                    System.out.println("Копируем");
                    Files.createDirectory(dst);
                    FileUtils.copyFolder(f.getPath(), dst.toString());
                    System.out.println("Директ скопирован");
                } catch (IOException e) {
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
        }
    }
}
