package practice.strings;

import java.util.Scanner;

public class FullNameFormatter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                scanner.close();
                break;
            }
            int firstNameEnd = input.indexOf(" ");
            int nameEnd = input.indexOf(" ", firstNameEnd + 1);
            int more = input.indexOf(" ", nameEnd + 1);
            int indexNum = 0;
            boolean findNumber = true;
            for (int num = 0; num <= 9; num++) { // Определяем индекс любого числа если оно было введено, если число не найдено вернет -1
                String number = Integer.toString(num);
                indexNum = input.trim().indexOf(number);
                if (indexNum >= 0) { //если индекс стал больше -1, то число было найдено, значит формат ФИО неверен
                    findNumber = false;
                }
            }
            if (more < 0 && nameEnd > 0 && findNumber == true) {
                String firstName = input.substring(0, firstNameEnd);
                String name = input.substring(firstNameEnd + 1, nameEnd);
                String endName = input.substring(nameEnd + 1);
                System.out.println("Фамилия: " + firstName + "\nИмя: " + name + "\nОтчество: " + endName);
            } else {
                System.out.println("Введенная строка не является ФИО");
            }
        }
    }
}


