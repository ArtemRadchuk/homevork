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
        return "addGenre";
    }

    @PostMapping(value = "/genres/add")
    public String create(Genre genre){
        genreService.createGenre(genre);
        return "redirect:/genres";
    }

    @GetMapping(value = "/genres")
    public String getGenre(Model model) {
        model.addAttribute("genres", genreService.genreList());
        return "indexGenre";
    }

    @GetMapping(value = "/genres/delete/{id}")
    public void deleteGenre(@PathVariable("id") int id) {
        genreService.deleteGenre(id);
    }
}

