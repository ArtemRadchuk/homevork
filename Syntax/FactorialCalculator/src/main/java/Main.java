import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Введите цисло");
        int value = new Scanner(System.in).nextInt();
        int factorial=1;
        for(;value > 0;value--){
            factorial=factorial*value;
        }
        System.out.println("Факториал вашего числа " + factorial);
    }
}


