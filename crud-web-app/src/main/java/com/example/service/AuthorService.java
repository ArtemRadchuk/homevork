package com.example.service;


import com.example.model.Author;

import java.util.List;

public interface AuthorService {

    void createAuthor(Author author);

    void deleteAuthorById(long id);

    List<Author> authorList();

    Author findAuthor(long id);

    /*  void deleteAuthor(Author author);*/
}
