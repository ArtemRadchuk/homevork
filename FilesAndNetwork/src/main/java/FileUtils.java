import net.sf.saxon.trans.SymbolicName;

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
        for (File file : folder.listFiles()) {
            if (!file.isDirectory()) {
                weight = weight + file.length();
            } else if (file.isDirectory()) {
                dir.add(file.getName());
            }
            for (String s : dir) {
                File files = new File(uRL + "\\" + s);
                for (File f : files.listFiles()) {
                    dir.add(f.getName());
                    if (!f.isDirectory()) {
                        weight = weight + f.length();
                        dir.remove(f.getName());
                    } else if (f.isDirectory()) {
                        for (File g : f.listFiles()) {
                            dir.add(g.getName());
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
        if (bite == 0) {
            prefix = "байт";
        } else if (bite == 1) {
            prefix = "Килобайт";
        } else if (bite == 2) {
            prefix = "Мегабайт";
        } else if (bite == 3) {
            prefix = "Гигабайт";
        }
        return prefix;
    }
}
