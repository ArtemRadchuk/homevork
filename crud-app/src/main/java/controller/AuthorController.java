package controller;

import model.Author;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import service.impl.AuthorServiceImpl;

@Controller
public class AuthorController {
    private AuthorServiceImpl authorService;

    @PostMapping(value = "/author/add")
    public void add(@RequestBody String name) {
        authorService.createAuthor(name);
    }

    @GetMapping(value = "/authors")
    public void getAuthors(Model model) {
        model.addAttribute("", authorService.authorList());
    }

    @GetMapping(value = "/author/delete/{id}")
    public void deleteAuthorById(@PathVariable("id") int id) {
        authorService.deleteAuthorById(id);
    }

    @GetMapping(value = "/author/delete/{author}")
    public void deleteAuthor(@PathVariable("author") Author author) {
        authorService.deleteAuthor(author);
    }

}
