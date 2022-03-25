package practice;
import java.util.ArrayList;

public class TodoList {
    ArrayList<String> ToDo = new ArrayList<>();

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        ToDo.add(todo);
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if(index <= ToDo.size()){
        ToDo.add(index,todo);}
        else{
            ToDo.add(todo);
        }
    }

    public void edit(int index, String todo) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if(index <= ToDo.size()){
        ToDo.set(index,todo);}

    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if(index < ToDo.size()){
        ToDo.remove(index);}
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел

        return ToDo;
    }

}