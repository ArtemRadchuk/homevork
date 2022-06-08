package controller;

import model.Book;
import service.impl.BookServiceImpl;
import service.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


@Controller
@RequestMapping(value = "")
public class BookController {
    private BookServiceImpl bookService;


    @PostMapping("/book/add")
    public void add(@RequestBody Book book) {
        bookService.createBook(book);
    }

    @GetMapping(value = "/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.allBook());
        return "index";
    }

    @GetMapping("/book/{title}")
    public String getBook(@PathVariable("title") String title, Model model) {
        model.addAttribute("book", bookService.findBook(title));
        return "show";
    }

    @DeleteMapping("/book/delete/{title}")
    public void deleteBook(@PathVariable("title") String title) {
        bookService.deleteBook(bookService.findBook(title));
    }


    /*
        List<Book> bookList = new ArrayList<>();
        connection = DBConnection.connection;
        ResultSet list= connection.createStatement().executeQuery("SELECT * FROM book WHERE title = "+ title);

        return new Book(list.getInt(1), list.getString("title"), list.getString("description"),
                list.getString("isbn"), list.getInt("print_year"), list.getBoolean("read_already"));
    }*/
}
