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
        /*authorService.createAuthor(author);*/
        return "addAuthor";
    }

    @PostMapping(value = "/authors/add")
    public String create(Author author){
        authorService.createAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping(value = "/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorService.authorList());
        return "indexAuthor";
    }

    @GetMapping(value = "/authors/delete/{id}")
    public void deleteAuthorById(@PathVariable("id") int id) {
        authorService.deleteAuthorById(id);
    }

/*    @GetMapping(value = "/author/delete/{author}")
    public void deleteAuthor(@PathVariable("author") Author author) {
        authorService.deleteAuthor(author);
    }*/

}
