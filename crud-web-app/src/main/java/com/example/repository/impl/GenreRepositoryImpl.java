package com.example.repository.impl;

import com.example.model.Genre;
import com.example.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class GenreRepositoryImpl implements GenreRepository<Genre, Integer> {

    private final EntityManager entityManager;

    @Override
    public List<Genre> findAll() {
        return entityManager.createQuery("select g from Genre g", Genre.class).getResultList();
    }

    @Override
    public Genre create(Genre genre) {
        if (Objects.isNull(genre.getId())) {
            entityManager.persist(genre);
            return genre;
        } else {
            return entityManager.merge(genre);
        }
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

    public Genre findGenre(String name) {
        for (Genre g : findAll()) {
            if (g.getName().equals(name)) {
                return g;
            }
        }
        return null;
    }
}
