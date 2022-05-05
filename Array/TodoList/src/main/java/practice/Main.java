package practice;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        String command;
        String inSide = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            String[] divineInput = input.split(" ");
            if (divineInput.length > 1) {
                command = input.substring(0, input.indexOf(" ")).toUpperCase(Locale.ROOT);
                inSide = input.substring(input.indexOf(" "), input.length()).trim();
            } else {
                command = input.toUpperCase(Locale.ROOT);
            }
            Pattern pattern = Pattern.compile("[0-9]");
            Matcher matcher = pattern.matcher(inSide);
            if (input.equals("-1")) {
                break;
            }
            switch (command) {
                case "ADD":
                    if (matcher.find()) {
                        String index = inSide.substring(0, inSide.indexOf(" "));
                        int i = Integer.parseInt(index);
                        String toDo = inSide.substring(i, inSide.length() - 1);
                        todoList.add(i, toDo);
                        System.out.println("Добавлено дело - " + toDo);
                    } else {
                        todoList.add(inSide);
                        System.out.println("Добавлено дело - " + inSide);
                    }
                    break;
                case "LIST":
                    todoList.getTodos();
                    break;
                case "EDIT":
                    String indexEdit = inSide.substring(0, inSide.indexOf(" "));
                    int iE = Integer.parseInt(indexEdit);
                    String toDo = inSide.substring(inSide.indexOf(" "), inSide.length());
                    todoList.edit(iE, toDo);
                    break;
                case "DELETE":
                    String indexDelete = inSide.substring(0, inSide.length());
                    int iD = Integer.parseInt(indexDelete);
                    todoList.delete(iD);
                    break;
                default:
                    System.out.println("Команда не распознана");
                    break;
            }
        }
    }

    enum commandName {
        ADD,
        LIST,
        EDIT,
        DELETE;
    }
}
