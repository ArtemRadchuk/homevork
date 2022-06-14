package service;

import model.Author;

import java.util.List;

public interface AuthorService {

    Object createAuthor(String name);

    void deleteAuthorById(int id);

    List<Author> authorList();

    Author findAuthor(String name);

  /*  void deleteAuthor(Author author);*/
}
