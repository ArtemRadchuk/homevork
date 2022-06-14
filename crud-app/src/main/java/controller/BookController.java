package controller;

import model.Author;
import model.Book;
import model.Genre;
import service.impl.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "")
public class BookController {
    private BookServiceImpl bookService;


    @PostMapping("/book/add")
    public String add(@RequestParam(name = "title") String title, @RequestParam(name = "description") String description,
                    @RequestParam(name = "isbn") String isbn, @RequestParam(name = "author") Author author,
                    @RequestParam(name = "genre") Genre genre, @RequestParam(name = "print year") int print_year, Model model) {
        model.addAttribute("book", bookService.createBook(title, description, isbn, author, genre,  print_year));
        return "addBook";
    }

    @GetMapping(value = "/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.allBook());
        return "bookIndex";
    }

    @GetMapping("/book/{title}")
    public String getBook(@PathVariable("title") String title, Model model) {
        model.addAttribute("book", bookService.findBook(title));
        return "readBook";
    }

    @GetMapping("/book/{book}/update")
    public String update(@RequestParam(name = "id") int id, @RequestParam(name = "title") String title,
                       @RequestParam(name = "description") String description,@RequestParam(name = "isbn") String isbn,
                       @RequestParam(name = "print year")int printYear) {
        bookService.updateBook(id, title, description, isbn, printYear);
        return "updateBook";
    }

    @DeleteMapping("/book/delete/{id}")
    public void deleteBook(@PathVariable("title") int id) {
        bookService.deleteBook(id);
    }
}
