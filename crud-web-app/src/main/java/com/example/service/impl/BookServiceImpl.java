package com.example.service.impl;

import com.example.BookInfo;
import com.example.model.Author;
import com.example.model.Book;
import com.example.model.Genre;
import com.example.repository.impl.BookRepositoryImpl;
import com.example.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final GenreServiceImpl genreService;
    private final AuthorServiceImpl authorService;
    private final BookRepositoryImpl bookRepository;

    @Override
    @Transactional
    public void createBook(BookInfo bookInfo) {
        Book book = new Book();
        if (authorService.findAuthorByName(bookInfo.getAuthor()) != null) {
            book.setAuthor(authorService.findAuthorByName(bookInfo.getAuthor()));
        } else {
            Author author = new Author();
            author.setName(bookInfo.getAuthor());
            authorService.createAuthor(author);
            book.setAuthor(authorService.findAuthorByName(bookInfo.getAuthor()));
        }
        if (genreService.findGenreByName(bookInfo.getGenre()) != null) {
            book.setGenre(genreService.findGenreByName(bookInfo.getGenre()));
        } else {
            Genre genre = new Genre();
            genre.setName(bookInfo.getGenre());
            genreService.createGenre(genre);
            book.setGenre(genreService.findGenreByName(bookInfo.getGenre()));
        }

        book.setIsbn(bookInfo.getIsbn());
        book.setPrintYear(bookInfo.getPrintYear());
        book.setTitle(bookInfo.getTitle());
        book.setDescription(bookInfo.getDescription());
        bookRepository.create(book);
    }

    @Override
    @Transactional
    public void updateBook(long id, Book book) {
        bookRepository.updateBook(book, id);
    }

    @Override
    @Transactional
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Book> allBook() {
        return bookRepository.findAll();
    }

    @Override
    @Transactional
    public Book findBook(long id) {
        return bookRepository.findById(id);
    }

}
