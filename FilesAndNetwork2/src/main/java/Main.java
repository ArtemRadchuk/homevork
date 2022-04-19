import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        System.out.println("Введите файл, который хотите копировать");
        String src = new Scanner(System.in).nextLine();
        System.out.println("Введите путь, куда копировать файл");
        String dest = new Scanner(System.in).nextLine();
        FileUtils.copyFolder(src,dest);
        for (StackTraceElement element: elements) {
            System.err.println(element);
        }

    }
}
