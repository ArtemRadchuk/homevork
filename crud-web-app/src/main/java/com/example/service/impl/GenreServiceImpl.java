package com.example.service.impl;

import com.example.model.Genre;
import com.example.repository.impl.GenreRepositoryImpl;
import com.example.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepositoryImpl genreRepository;

    @Override
    @Transactional
    public void createGenre(Genre genre) {
        genreRepository.create(genre);
    }

    @Override
    @Transactional
    public void deleteGenre(long id) {
        genreRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Genre> genreList() {
       return genreRepository.findAll();
    }

    @Override
    @Transactional
    public Genre findGenre(long id) {
        return  genreRepository.findById(id);
    }
}
