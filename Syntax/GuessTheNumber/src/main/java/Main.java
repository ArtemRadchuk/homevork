import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        int value = new Random().nextInt(100);
        System.out.println(value); // Что-бы не гадать пару часов
        int attempt = 0;
        while(value != attempt){
            System.out.println("Введите число");
            attempt = new Scanner(System.in).nextInt();
            if (attempt == value){
                System.out.println("Число верно");
                break;
            }
            if (attempt > value){
                System.out.println("Число больше загаданного");
            } else {
                System.out.println("Число меньше загаданного");
            }


        }
    }
}
