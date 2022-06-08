package service;

import dao.DBConnection;
import model.Book;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class BookDAO {
    public static ArrayList<Book> books;

    public BookDAO() throws SQLException {
        books = new ArrayList<>();
        ResultSet list = DBConnection.connection.createStatement().executeQuery("SELECT * FROM book;");
        while (list.next()) {
            books.add((new Book(list.getInt(1), list.getString("title"), list.getString("description"),
                    list.getString("isbn"), list.getInt("print_year"), list.getBoolean("read_already"))));
        }
    }

    public static ArrayList<Book> index() {
        return books;
    }

    public static Book show(String title) {
        return books.stream().filter(book -> book.getTitle().equals(title)).findAny().orElse(null);
    }
}
