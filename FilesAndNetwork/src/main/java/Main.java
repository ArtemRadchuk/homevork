
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true){
        System.out.println("Введите путь к файлу");
        String input = new Scanner(System.in).nextLine();
        if (input.equals("-1")){
            break;
        }
        System.out.println(FileUtils.calculateFolderSize(input));
        }
    }
}