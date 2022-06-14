package service.impl;

import lombok.RequiredArgsConstructor;
import model.Author;
import model.Book;
import model.Genre;
import org.springframework.stereotype.Service;
import repository.impl.BookRepositoryImpl;
import service.BookService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepositoryImpl bookRepository;

    @Override
    public Book createBook(String title, String description, String isbn, Author author, Genre genre, int print_year) {
        Book book = new Book();
        book.setTitle(title);
        book.setDescription(description);
        book.setIsbn(isbn);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setPrintYear(print_year);
        book.setReadAlready(false);
        bookRepository.create(book);
        return book;
    }

    @Override
    public void updateBook(int id, String title, String description, String isbn, int printYear) {
        bookRepository.updateBook(id, title, description, isbn, printYear);
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> allBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBook(String title) {
        return bookRepository.findByName(title);
    }
}
