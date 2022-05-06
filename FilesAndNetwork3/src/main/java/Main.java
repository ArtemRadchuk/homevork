import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.print("Введите путь к csv файлу");
            Scanner scanner = new Scanner(System.in);
            if (scanner.equals("-1")) {
                break;
            }
            try {
                Movements movements = new Movements(scanner.nextLine());
                movements.getExpenseSum();
                movements.getIncomeSum();
            }catch (Exception e){
                System.err.println("Ошибка в пути к файлу");
            }

        }
    }
}