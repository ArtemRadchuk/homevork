package practice;

import java.util.Scanner;

public class TrucksAndContainers {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //получение количество коробок от пользователя
        final int MAX_BOX_IN_TRUCK = 324;
        final int MAX_BOX_IN_CONTAINER = 27;
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
                if (loadedBox % MAX_BOX_IN_TRUCK == 0) {
                    truck++;
                    System.out.println("Грузовик: " + truck);
                }
                if (loadedBox % MAX_BOX_IN_CONTAINER == 0 && boxes > loadedBox) {
                    container++;
                    System.out.println("\tКонтейнер: " + container);
                }
            }
        }
        System.out.println("Необходимо:\nгрузовиков - " + truck + " шт.");
        System.out.println("контейнеров - " + container + " шт.");


    }

}
