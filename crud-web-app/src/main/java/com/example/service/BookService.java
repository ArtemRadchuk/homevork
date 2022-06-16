package com.example.service;



import com.example.model.Author;
import com.example.model.Book;
import com.example.model.Genre;

import java.util.List;

public interface BookService {

    void createBook(Book book);

    void updateBook(int id, String title, String description, String isbn, int printYear);

    void deleteBook(int id);

    List<Book> allBook();

    Book findBook(String title);


}
