import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        File folder = new File(path);
        long weight = 0L;
        List<String> fileArray = new ArrayList<>(); //Массив имен файлов в папке
        List<String> dir = new ArrayList<>();
        String uRL = path;
        try {
            folder.isDirectory();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Переданный путь не ведет к директории");
        }
        for (File file : folder.listFiles()) {
            if (!file.isDirectory()) {
                weight = weight + file.length();
            } else {
                dir.add(file.getName());
                for (String s : dir) {
                    File files = new File(uRL + "\\" + s);
                    for (File f : files.listFiles()) {
                        dir.add(f.getName());
                        if (!f.isDirectory()) {
                            weight = weight + f.length();
                            dir.remove(f.getName());
                        } else {
                            for (File g : f.listFiles()) {
                                dir.add(g.getName());
                            }
                        }
                    }
                }
            }
        }
        System.out.println(weight + " " + bytePrefix(weight));
        return weight;
    }

    public static String bytePrefix(long weight) {
        int bite = 0;
        for (; weight >= 1024L; bite++) {
            weight = weight / 1024;
        }
        String prefix = "";
        switch (bite) {
            case 1:
                prefix = "Килобайт";
                break;
            case 2:
                prefix = "Мегабайт";
                break;
            case 3:
                prefix = "Гигабайт";
                break;
            default:
                prefix = "Байт";
        }

        return prefix;
    }
}
