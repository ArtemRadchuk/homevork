import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите файл, который хотите копировать");
        String src = new Scanner(System.in).nextLine();
        System.out.println("Введите путь, куда копировать файл");
        String dest = new Scanner(System.in).nextLine();
        FileUtils.copyFolder(src,dest);
    }
}
