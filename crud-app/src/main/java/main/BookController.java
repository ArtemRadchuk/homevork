package main;

import dao.DBConnection;
import domain.Book;
import domain.BookRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@RestController
/*
@RequestMapping(name = "/books")
*/
public class BookController {

    Connection connection;
    List<Book> bookList;

    @GetMapping("/test")
    public String test() throws SQLException {
        connection = DBConnection.connection;
        ResultSet list = connection.createStatement().executeQuery("SELECT * FROM book where id = 1;");
        StringBuilder builder = new StringBuilder();
        while (list.next()){
            builder.append(list.getString("title"));
            String a = list.getString("title");
            return a + "\n";

           /* builder.append(list.getString("print_year"));*/
        }
        list.close();
        return null;
    }

    @GetMapping("/books")
    public List<Book> index(Model model) throws SQLException {
        connection = DBConnection.connection;
        ResultSet list = connection.createStatement().executeQuery("SELECT * FROM book;");

        StringBuilder builder = new StringBuilder();
        while (list.next()) {
            bookList.add((new Book(list.getInt(1), list.getString("title"), list.getString("description"),
                    list.getString("isbn"), list.getInt("print_year"), list.getBoolean("read_already"))));
        }
        model.addAttribute("books", bookList);
        return bookList;
    }

    /*@GetMapping("/{title}")
    public Book show(@PathVariable("title") String title) throws SQLException {
        List<Book> bookList = new ArrayList<>();
        connection = DBConnection.connection;
        ResultSet list= connection.createStatement().executeQuery("SELECT * FROM book WHERE title = "+ title);

        return new Book(list.getInt(1), list.getString("title"), list.getString("description"),
                list.getString("isbn"), list.getInt("print_year"), list.getBoolean("read_already"));
    }*/
}
