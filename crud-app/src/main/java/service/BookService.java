package com.example.service;



import com.example.model.Author;
import com.example.model.Book;
import com.example.model.Genre;

import java.util.List;

public interface BookService {

    Object createBook(String title, String description, String isbn, Author author, Genre genre, int print_year);

    void updateBook(int id, String title, String description, String isbn, int printYear);

    void deleteBook(int id);

    List<Book> allBook();

    Book findBook(String title);


}
