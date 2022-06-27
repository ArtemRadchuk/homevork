package com.example.controller;

import com.example.model.Author;
import com.example.service.impl.AuthorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorServiceImpl authorService;

    @GetMapping(value = "/authors/add")
    public String add(@ModelAttribute("author") Author author) {
        return "author/addAuthor";
    }

    @PostMapping(value = "/authors/add")
    public String create(Author author){
        authorService.createAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping("/authors/{id}")
    public String getAuthor(@PathVariable("id") long id, Model model) {
        model.addAttribute("books", authorService.findAuthor(id).getBooks());
        model.addAttribute("author", authorService.findAuthor(id));
        return "author/showAuthor";
    }

    @GetMapping(value = "/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorService.authorList());
        return "author/indexAuthor";
    }

    @DeleteMapping("/authors/delete/{id}")
    public String deleteAuthorById(@PathVariable("id") Long id) {
        authorService.deleteAuthorById(id);
        return "redirect:/authors";
    }
}
