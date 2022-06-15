package com.example.controller;

import com.example.service.impl.GenreServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class GenreController {
    private final GenreServiceImpl genreService;

    @PostMapping(value = "/genre/add")
    public String add(@RequestParam String name,Model model) {
        model.addAttribute("genre", genreService.createGenre(name));
        return "addGenre";
    }

    @GetMapping(value = "/genres")
    public String getGenre(Model model) {
        model.addAttribute("genres", genreService.genreList());
        return "genreIndex";
    }

    @GetMapping(value = "/genre/delete/{id}")
    public void deleteGenre(@PathVariable("id") int id) {
        genreService.deleteGenre(id);
    }
}

