package com.example.service;



import com.example.model.Genre;

import java.util.List;

public interface GenreService {

    Object createGenre(String name);

    void deleteGenre(int id);

    List<Genre> genreList();

    Genre findGenre(String name);
}
