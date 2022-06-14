package service;

import model.Author;
import model.Book;
import model.Genre;

import java.util.List;

public interface BookService {

    Object createBook(String title, String description, String isbn, Author author, Genre genre, int print_year);

    void updateBook(Book book ,String title, String description, String isbn, int printYear);

    void deleteBook(int id);

    List<Book> allBook();

    Book findBook(String title);


}
