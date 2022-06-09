package service;

import model.Genre;

import java.util.List;

public interface GenreService {
    void createGenre(String name);

    void deleteGenre(int id);

    List<Genre> genreList();

    Genre findGenre(String name);
}
