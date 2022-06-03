package main;

import dao.DBConnection;
import domain.Book;
import domain.BookDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class BookController {
    ArrayList<Book> books;

    public BookController(ArrayList<Book> books) throws SQLException {
        this.books = BookDAO.bookList;
        BookDAO.setBookList();
    }

    @PostMapping("/book/add")
    public List<Book> add(@RequestBody Book book) {
        this.books.add(book);
        return books;
    }

    @GetMapping("/books")
    public String getBooks(Model model) throws SQLException {
    /*    ArrayList<String> bookTitle = new ArrayList<>();
        for (Book book:books) {
            bookTitle.add(book.getTitle());
        }*/
        model.addAttribute("books", BookDAO.index());
        return "books/index";
    }
    @GetMapping("/book/{title}")
    public String getBook(@PathVariable("title") String title, Model model) throws SQLException {
        model.addAttribute("book",BookDAO.show(title));
        return "books/show";
    }

    @DeleteMapping("/book/delete/{title}")
    public void deleteBook(@PathVariable("title") String title) {
        for (Book a : books) {
            if (a.getTitle().equals(title)) {
                books.remove(a);
            }
        }
    }


    /*
        List<Book> bookList = new ArrayList<>();
        connection = DBConnection.connection;
        ResultSet list= connection.createStatement().executeQuery("SELECT * FROM book WHERE title = "+ title);

        return new Book(list.getInt(1), list.getString("title"), list.getString("description"),
                list.getString("isbn"), list.getInt("print_year"), list.getBoolean("read_already"));
    }*/
}
