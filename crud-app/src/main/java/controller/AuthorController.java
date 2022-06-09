package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value = "/author/delete")
    public void deleteAuthor(int id) {
        authorService.deleteAuthor(id);
    }
}
