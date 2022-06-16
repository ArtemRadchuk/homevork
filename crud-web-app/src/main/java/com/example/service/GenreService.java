package com.example.service;



import com.example.model.Genre;

import java.util.List;

public interface GenreService {

    void createGenre(Genre genre);

    void deleteGenre(int id);

    List<Genre> genreList();

    Genre findGenre(String name);
}
