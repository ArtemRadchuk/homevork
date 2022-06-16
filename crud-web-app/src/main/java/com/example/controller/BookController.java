package com.example.controller;

import com.example.model.Book;
import com.example.service.impl.BookServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookServiceImpl bookService;

    @GetMapping("/books/add")
    public String add(@ModelAttribute("book") Book book) {
        return "addBook";
    }

    @PostMapping(value = "/books/add")
    public String create(Book book) {
        bookService.createBook(book);
        return "redirect:/indexBook";
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.allBook());
        return "indexBook";
    }

    @GetMapping("/books/find/{title}")
    public String getBook(@PathVariable("title") String title, Model model) {
        model.addAttribute("book", bookService.findBook(title));
        return "readBook";
    }

    @PostMapping("/books/{book}/update")
    public String update(@RequestParam(name = "id") int id, @RequestParam(name = "title") String title,
                         @RequestParam(name = "description") String description, @RequestParam(name = "isbn") String isbn,
                         @RequestParam(name = "print year") int printYear) {
        bookService.updateBook(id, title, description, isbn, printYear);
        return "updateBook";
    }

    @DeleteMapping("/books/delete/{id}")
    public void deleteBook(@PathVariable("title") int id) {
        bookService.deleteBook(id);
    }
}
