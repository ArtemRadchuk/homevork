package practice;

import java.util.Scanner;

public class TrucksAndContainers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //получение количество коробок от пользователя
        int boxes = scanner.nextInt();
        int container = 0;
        int truck = 0;
        int loadedBox = 1;
        if (boxes != 0) {
            truck++;
            container++;
            System.out.println("Грузовик: " + truck);
            System.out.println("\tКонтейнер: " + container);
            for (; loadedBox <= boxes; loadedBox++) {
                System.out.println("\t\tЯщик: " + loadedBox);
                if (loadedBox % 324 == 0) {
                    truck++;
                    System.out.println("Грузовик: " + truck);
                }
                if (loadedBox % 27 == 0 && boxes > loadedBox) {
                    container++;
                    System.out.println("\tКонтейнер: " + container);
                }
            }
        }
        System.out.println("Необходимо:\nгрузовиков - " + truck + " шт.");
        System.out.println("контейнеров - " + container + " шт.");


        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
    }

}
