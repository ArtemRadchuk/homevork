package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;


@Controller
@RequestMapping(value = "")
public class BookController {
    private final BookDAO bookDAO;

    @Autowired
    public BookController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }




/*    @PostMapping("/book/add")
    public List<Book> add(@RequestBody Book book) {
        this.books.add(book);
        return books;
    }*/

    @GetMapping(value = "/books")
    public String getBooks(Model model) throws SQLException {
        model.addAttribute("books", bookDAO.index());
        return "index";
    }

    @GetMapping("/book/{title}")
    public String getBook(@PathVariable("title") String title, Model model) throws SQLException {
        model.addAttribute("book",bookDAO.show(title));
        return "books/show";
    }

  /*  @DeleteMapping("/book/delete/{title}")
    public void deleteBook(@PathVariable("title") String title) {
        for (Book a : BookDAO.books) {
            if (a.getTitle().equals(title)) {
                BookDAO.books.remove(a);
            }
    }
        }*/


    /*
        List<Book> bookList = new ArrayList<>();
        connection = DBConnection.connection;
        ResultSet list= connection.createStatement().executeQuery("SELECT * FROM book WHERE title = "+ title);

        return new Book(list.getInt(1), list.getString("title"), list.getString("description"),
                list.getString("isbn"), list.getInt("print_year"), list.getBoolean("read_already"));
    }*/
}
