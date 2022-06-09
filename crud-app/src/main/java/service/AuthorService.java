package service;

import model.Author;

import java.util.List;

public interface AuthorService {

    void createAuthor(String name);

    void deleteAuthor(int id);

    List<Author> authorList();

    Author findAuthor(String name);
}
