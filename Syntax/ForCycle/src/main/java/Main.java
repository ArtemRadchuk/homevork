import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Введите число");
        int value = new Scanner(System.in).nextInt();
        int first = 1;
        int second = 1;
        int umn = 0;

        for (first = 1; first <= value; first++) {
            umn = first * second;
            if(umn==value){
                System.out.println(first + " * " + second);
            }
            for (second = value; second > 0; second--){
                umn = first * second;
                if(umn==value){
                    System.out.println(first + " * " + second);
                }

            }
            }
        }
    }

// Сортировка пузырьком


