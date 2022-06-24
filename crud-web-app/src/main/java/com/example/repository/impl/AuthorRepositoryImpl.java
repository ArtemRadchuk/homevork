package com.example.repository.impl;


import com.example.model.Author;
import com.example.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository<Author, String> {

    private final EntityManager entityManager;

    @Override
    public List<Author> findAll() {
        return entityManager.createQuery("select a from Author a", Author.class).getResultList();
    }

    @Override
    public Author create(Author author) {
        /*entityManager.createNativeQuery("insert into book_list.author(name) values (\"" + author.getName() + "\")").executeUpdate();*/
        if (Objects.isNull(author.getId())) {
            entityManager.persist(author);
            return author;
        } else {
            return entityManager.merge(author);
        }
    }

    @Override
    public Author findById(Long id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    public void delete(Author author) {
        entityManager.remove(author.getId());
    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(findById(id));
    }
}
