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
        System.out.println(title);
        model.addAttribute("book", bookService.findBook(title));
        System.out.println("Книга найдена");
        return "show";
    }

    @GetMapping("/book/{book}/update")
    public void update(@PathVariable("book") Book book, String title, String description, String isbn, int printYear) {
        bookService.updateBook(book, title, description, isbn, printYear);
    }

    @DeleteMapping("/book/delete/{title}")
    public void deleteBook(@PathVariable("title") String title) {
        bookService.deleteBook(bookService.findBook(title));
    }
}
