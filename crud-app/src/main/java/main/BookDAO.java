package main;

import dao.DBConnection;
import domain.Book;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class BookDAO {
    public static ArrayList<Book> books;

    public static ArrayList<Book> setBookList() throws SQLException {
        books = new ArrayList<>();
        ResultSet list = DBConnection.connection.createStatement().executeQuery("SELECT * FROM book;");
        while (list.next()) {
            books.add((new Book(list.getInt(1), list.getString("title"), list.getString("description"),
                    list.getString("isbn"), list.getInt("print_year"), list.getBoolean("read_already"))));
        }
        return books;
    }

    public static ArrayList<Book> index() throws SQLException {
        setBookList();
        return books;
    }

    public static Book show(String title) throws SQLException {
        setBookList();
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                book.setReadAlready(true);
                return book;
            }
        }
        return null;
    }
}
