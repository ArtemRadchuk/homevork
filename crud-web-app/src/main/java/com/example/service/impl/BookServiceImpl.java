package com.example.service.impl;

import com.example.model.Book;
import com.example.repository.impl.BookRepositoryImpl;
import com.example.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepositoryImpl bookRepository;

    @Override
    @Transactional
    public void createBook(Book book) {
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
