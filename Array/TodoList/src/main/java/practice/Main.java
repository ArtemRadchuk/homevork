package practice;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        String input = new Scanner(System.in).nextLine();
        String command = input.substring(0, input.indexOf(" ")).toUpperCase(Locale.ROOT);
        String inSide = input.substring(input.indexOf(" "), input.length()).trim();
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(inSide);
        while (input.equals("-1") == false) {
            switch (command) {
                case "ADD":
                    if (matcher.find() == true) {
                        String index = inSide.substring(0, inSide.indexOf(" "));
                        int i = Integer.parseInt(index);
                        String toDo = inSide.substring(i, inSide.length()-1);
                        todoList.add(i, toDo);

                    } else {
                        todoList.add(inSide);
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
            }
        }
    }

    enum command {
        ADD,
        LIST,
        EDIT,
        DELETE;
    }
}
