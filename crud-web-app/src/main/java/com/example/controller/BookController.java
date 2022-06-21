package com.example.controller;

import com.example.BookInfo;
import com.example.model.Author;
import com.example.model.Book;
import com.example.repository.impl.GenreRepositoryImpl;
import com.example.service.impl.AuthorServiceImpl;
import com.example.service.impl.BookServiceImpl;
import com.example.service.impl.GenreServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookServiceImpl bookService;
    private final GenreServiceImpl genreService;
    private final AuthorServiceImpl authorService;

    @GetMapping("/books/add")
    public String add(@ModelAttribute("bookInfo") BookInfo bookInfo) {
        return "book/addBook";
    }

    @PostMapping(value = "/books/add")
    public String create(@ModelAttribute("bookInfo") BookInfo bookInfo) {
        Book book = new Book();
        book.setAuthor(authorService.findAuthor(bookInfo.getAuthor()));
        book.setGenre(genreService.findGenre(bookInfo.getGenre()));
        book.setIsbn(bookInfo.getIsbn());
        book.setPrintYear(bookInfo.getPrintYear());
        book.setTitle(bookInfo.getTitle());
        book.setDescription(bookInfo.getDescription());
        bookService.createBook(book);
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.allBook());
        return "book/indexBook";
    }

    @GetMapping("/books/{id}")
    public String getBook(@PathVariable("id") long id, Model model) {
        model.addAttribute("book", bookService.findBook(id));
        return "book/showBook";
    }

    @GetMapping("/books/{id}/edit")
    public String editBook(Model model, @PathVariable("id") long id){
        model.addAttribute("book", bookService.findBook(id));
        /*System.out.println(bookService.findBook(id).getTitle() + " " + bookService.findBook(id).getPrintYear());*/
        return "book/updateBook";
    }

    @GetMapping("/books/find/{id}")
    public String findBook(Model model, @PathVariable("id") long id){
        model.addAttribute("book",bookService.findBook(id));
        return "redirect:/book/showBook";
    }

    @PatchMapping(value = "/books/{id}")
    public String update(@ModelAttribute("book") Book book, @PathVariable("id") long id) {
        System.out.println("Назвение - " +book.getTitle() + ". Описание - " + book.getDescription() + ". ISBN - "+ book.getIsbn()
                +". Год печати - "+ book.getPrintYear());
        bookService.updateBook(id, book);
        return "redirect:/books";
    }

    @DeleteMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable("id")long id) {
        System.err.println(id);
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
