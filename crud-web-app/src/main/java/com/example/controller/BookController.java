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

    @GetMapping("/books/{id}")
    public String getBook(@PathVariable("id") long id, Model model) {
        model.addAttribute("book", bookService.findBook(id));
        return "readBook";
    }

    @GetMapping("/books/{id}/edit")
    public String updateBook(Model model, @PathVariable("id") long id){
        model.addAttribute("book", bookService.findBook(id));
        return "updateBook";
    }

    @PatchMapping("/{id}/")
    public String update(@ModelAttribute("book") Book book, @PathVariable("id") long id) {
        bookService.updateBook(id, book);
        return "redirect:/people";
    }


    /*@PostMapping("/books/{id}/update")
    public String update(Model model,) {
        bookService.updateBook(id, title, description, isbn, printYear);
        return "updateBook";
    }*/

    @DeleteMapping("/books/delete/{id}")
    public void deleteBook(@PathVariable("title")long id) {
        bookService.deleteBook(id);
    }
}
