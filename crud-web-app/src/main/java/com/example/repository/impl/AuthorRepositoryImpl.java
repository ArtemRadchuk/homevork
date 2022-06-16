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
        return entityManager.createNativeQuery("select * FROM book_list.author", Author.class).getResultList();
    }

    @Override
    public void create(Author author) {
        entityManager.createNativeQuery("insert into book_list.author(name) values (\"" + author.getName() + "\")");
    }

    @Override
    public Author findByName(String name) {
        return (Author) entityManager.createNativeQuery("FROM book_list.author where name =" + name, Author.class).getSingleResult();
    }

    @Override
    public void delete(Author author) {
        entityManager.remove(author.getId());
    }

    @Override
    public void deleteById(Integer id) {
        entityManager.remove(id);
    }
}
