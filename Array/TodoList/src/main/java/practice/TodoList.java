package practice;

import java.util.ArrayList;

public class TodoList {
    private ArrayList<String> toDo = new ArrayList<>();

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        toDo.add(todo);
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if (index <= toDo.size()) {
            toDo.add(index, todo);
        } else {
            toDo.add(todo);
        }
    }

    public void edit(int index, String todo) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if (index <= toDo.size()) {
            toDo.set(index, todo);
        }
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (index < toDo.size()) {
            toDo.remove(index);
        }
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        System.out.println(toDo);
        return toDo;
    }

}