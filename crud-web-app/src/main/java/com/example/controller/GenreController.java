package com.example.controller;

import com.example.model.Genre;
import com.example.service.impl.GenreServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class GenreController {
    private final GenreServiceImpl genreService;

    @GetMapping(value = "/genres/add")
    public String add(@ModelAttribute("genre") Genre genre) {
        return "genre/addGenre";
    }

    @PostMapping(value = "/genres/add")
    public String create(Genre genre) {
        genreService.createGenre(genre);
        return "redirect:/genres";
    }

    @GetMapping("/genres/{id}")
    public String getGenre(@PathVariable("id") long id, Model model) {
        model.addAttribute("books", genreService.findGenre(id).getBooks());
        model.addAttribute("genre", genreService.findGenre(id));
        return "genre/showGenre";
    }

    @GetMapping(value = "/genres")
    public String getGenre(Model model) {
        model.addAttribute("genres", genreService.genreList());
        return "genre/indexGenre";
    }

    @DeleteMapping("/genres/delete/{id}")
    public String deleteGenre(@PathVariable("id") long id) {
        genreService.deleteGenre(id);
        return "redirect:/genres";
    }
}

