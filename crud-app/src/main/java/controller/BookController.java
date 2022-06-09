package controller;

import model.Book;
import service.impl.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "")
public class BookController {
    private BookServiceImpl bookService;


    @PostMapping("/book/add")
    public void add(@RequestBody String title, String description, long isbn, String author, String genre, int print_year, boolean read_already) {
        bookService.createBook(title, description, isbn, author, genre,  print_year);
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

    @GetMapping("/book/{book}/update")
    public void update(@PathVariable("book") Book book, String title, String description, String isbn, int printYear) {
        bookService.updateBook(book, title, description, isbn, printYear);
    }

    @DeleteMapping("/book/delete/{id}")
    public void deleteBook(@PathVariable("title") int id) {
        bookService.deleteBook(id);
    }
}
