package service;

import model.Book;

import java.util.List;

public interface BookService {

    void createBook(String title, String description, long isbn, String author, String genre, int print_year);

    String readBook();

    void updateBook(Book book ,String title, String description, String isbn, int printYear);

    void deleteBook(int id);

    List<Book> allBook();

    Book findBook(String title);


}
