package com.example.repository.impl;

import com.example.model.Genre;
import com.example.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GenreRepositoryImpl implements GenreRepository<Genre, Integer> {

    private final EntityManager entityManager;

    @Override
    public List<Genre> findAll() {
        return entityManager.createNativeQuery("select * FROM book_list.genre;", Genre.class).getResultList();
    }

    @Override
    public void create(Genre genre) {
        entityManager.createNativeQuery("insert into book_list.genre(name) values (\"" + genre.getName() + "\");").executeUpdate();
    }

    @Override
    public Genre findById(Long id) {
        return entityManager.find(Genre.class, id);
    }

    @Override
    public void delete(Genre genre) {
        entityManager.remove(genre.getId());
    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(findById(id));
    }
}
