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
        String authorName;
        authorName = !bookInfo.getAuthor().equals("") ? bookInfo.getAuthor() : bookInfo.getAuthor2();
      /*  if (!bookInfo.getAuthor().equals("")) {
            authorName = bookInfo.getAuthor();
        } else if (bookInfo.getAuthor2() != null) {
            authorName = bookInfo.getAuthor2();
        } else {
            System.err.println("Автор не найден");
            authorName = null;
        }*/
        if (authorService.findAuthorByName(authorName) != null && authorName != null) {
            book.setAuthor(authorService.findAuthorByName(authorName));
        } else {
            Author author = new Author();
            author.setName(authorName);
            authorService.createAuthor(author);
            book.setAuthor(authorService.findAuthorByName(authorName));
        }
        String genreName;
        /*if (!bookInfo.getGenre().equals("")) {
            genreName = bookInfo.getGenre();
        } else {
            genreName = bookInfo.getGenre2();
        }*/
        genreName = !bookInfo.getGenre().equals("") ? bookInfo.getGenre() : bookInfo.getGenre2();
        if (genreService.findGenreByName(genreName) != null && genreName != null) {
            book.setGenre(genreService.findGenreByName(genreName));
        } else {
            Genre genre = new Genre();
            genre.setName(genreName);
            genreService.createGenre(genre);
            book.setGenre(genreService.findGenreByName(genreName));
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
