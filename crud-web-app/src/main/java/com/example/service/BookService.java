package com.example.service;

import com.example.BookInfo;
import com.example.model.Book;

import java.util.List;

public interface BookService {

    void createBook(BookInfo bookInfo);

    void updateBook(long id, Book book);

    void deleteBook(long id);

    List<Book> allBook();

    Book findBook(long id);


}
