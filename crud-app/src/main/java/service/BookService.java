package service;

import model.Book;

import java.util.List;

public interface BookService {

    void createBook(Book book);

    String readBook();

    void updateBook(Book book ,String title, String description, String isbn, int printYear);

    void deleteBook(Book book);

    List<Book> allBook();

    Book findBook(String title);


}
