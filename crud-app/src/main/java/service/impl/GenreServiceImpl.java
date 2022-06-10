package service.impl;

import lombok.RequiredArgsConstructor;
import model.Genre;
import org.springframework.stereotype.Service;
import repository.impl.GenreRepositoryImpl;
import service.GenreService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepositoryImpl genreRepository;

    @Override
    public void createGenre(String name) {
        Genre genre = new Genre();
        genre.setName(name);
        genreRepository.create(genre);
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
