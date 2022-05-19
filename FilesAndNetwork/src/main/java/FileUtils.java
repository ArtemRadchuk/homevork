import java.io.File;

public class FileUtils {
    public static long weight = 0L;

    public static long calculateFolderSize(String path) {
        File folder = new File(path);
        try {
            folder.isDirectory();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Переданный путь не ведет к директории");
        }
        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                weight = weight + file.length();
            } else {

                calculateFolderSize(path + File.separator + file.getName());
            }
        }
        System.out.println("Размер папки " + folder.getAbsolutePath() + " составляет: " + weight + " " + bytePrefix(weight));
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
