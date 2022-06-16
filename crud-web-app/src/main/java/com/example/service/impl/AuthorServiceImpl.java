package com.example.service.impl;

import com.example.model.Author;
import com.example.repository.impl.AuthorRepositoryImpl;
import com.example.service.AuthorService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepositoryImpl authorRepository;

    @Override
    @Transactional
    public void createAuthor(Author author) {
        authorRepository.create(author);
    }

    @Override
    @Transactional
    public void deleteAuthorById(int id) {
        authorRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Author> authorList() {
        return authorRepository.findAll();
    }

    @Override
    @Transactional
    public Author findAuthor(int id) {
        return authorRepository.findById(id);
    }

  /*  @Override
    public void deleteAuthor(Author author) {

    }*/


}
