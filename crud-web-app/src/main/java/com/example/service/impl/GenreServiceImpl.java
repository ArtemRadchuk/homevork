package com.example.service.impl;

import com.example.model.Genre;
import com.example.repository.impl.GenreRepositoryImpl;
import com.example.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepositoryImpl genreRepository;

    @Override
    public Genre createGenre(String name) {
        Genre genre = new Genre();
        genre.setName(name);
        genreRepository.create(genre);
        return genre;
    }

    @Override
    public void deleteGenre(int id) {
        genreRepository.deleteById(id);
    }

    @Override
    public List<Genre> genreList() {
       return genreRepository.findAll();
    }

    @Override
    public Genre findGenre(String name) {
        return  genreRepository.findByName(name);
    }
}
