import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите путь к файлу");
        String input = new Scanner(System.in).nextLine();
        try {
            FileInputStream file = new FileInputStream(input);
            long fileWeight = FileUtils.calculateFolderSize(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}