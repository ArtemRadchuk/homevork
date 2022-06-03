package domain;

import dao.DBConnection;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class BookDAO {
    public static ArrayList<Book> bookList;

    public static void setBookList() throws SQLException {
        ResultSet list = DBConnection.connection.createStatement().executeQuery("SELECT * FROM book;");
        while (list.next()) {
            bookList.add((new Book(list.getInt(1), list.getString("title"), list.getString("description"),
                    list.getString("isbn"), list.getInt("print_year"), list.getBoolean("read_already"))));
        }
    }

    public static ArrayList<Book> index() {
        return bookList;
    }

    public static Book show(String title) {
        for (Book book : bookList) {
            if (book.getTitle().equals(title)) {
                book.setReadAlready(true);
                return book;
            }
        }
        return null;
    }
}
