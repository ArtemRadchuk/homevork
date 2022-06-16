package com.example.service;


import com.example.model.Author;

import java.util.List;

public interface AuthorService {

    void createAuthor(Author author);

    void deleteAuthorById(int id);

    List<Author> authorList();

    Author findAuthor(int id);

    /*  void deleteAuthor(Author author);*/
}
