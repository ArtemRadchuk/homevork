package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import service.impl.GenreServiceImpl;

@Controller
public class GenreController {
    private GenreServiceImpl genreService;

    @PostMapping(value = "/author/add")
    public void add(@RequestBody String name) {
        genreService.createGenre(name);
    }

    @GetMapping(value = "/authors")
    public void getGenre(Model model) {
        model.addAttribute("", genreService.genreList());
    }

    @GetMapping(value = "/author/delete")
    public void deleteGenre(int id) {
        genreService.deleteGenre(id);
    }
}

