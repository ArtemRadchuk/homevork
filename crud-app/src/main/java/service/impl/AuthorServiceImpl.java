package com.example.service.impl;

import com.example.model.Author;
import com.example.repository.impl.AuthorRepositoryImpl;
import com.example.service.AuthorService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepositoryImpl authorRepository;

    @Override
    public Author createAuthor(String name) {
        Author author = new Author();
        author.setName(name);
        authorRepository.create(author);
        return author;
    }

    @Override
    public void deleteAuthorById(int id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> authorList() {
       return authorRepository.findAll();
    }

    @Override
    public Author findAuthor(String name) {
        return authorRepository.findByName(name);
    }

  /*  @Override
    public void deleteAuthor(Author author) {

    }*/


}
