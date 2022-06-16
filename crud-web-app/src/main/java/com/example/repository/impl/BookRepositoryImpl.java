package com.example.repository.impl;


import com.example.model.Author;
import com.example.model.Book;
import com.example.repository.BookRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository<Book, String, Integer> {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Book> findAll() {
        return entityManager.createNativeQuery("SELECT * FROM book_list.book", Book.class).getResultList();
    }

    public void updateBook(int id ,String title, String description, String isbn, int printYear) {
        entityManager.createNativeQuery("update book_list.book set(title, description, isbn, print_year, read_already) = ("
                + title + ", " + description + ", " + isbn + ", " + ", " + printYear +
                ", 0) where id = "  + id);
        entityManager.createNativeQuery("update book_list.book set read_already = 0 where id = " + id);
    }

    @Override
    public void create(Book book) {
        entityManager.createNativeQuery("insert into book_list.book(title, description, isbn, author, genre,  print_year, read_already) values" +
                " (" + book.getTitle() + ", " + book.getDescription() + ", " + book.getIsbn() + ", " + book.getAuthor() +
                ", " + book.getGenre()  + ", " + book.getPrintYear() + ", 0)");
    }

    @Override
    public Book findByName(String title) {
        entityManager.createNativeQuery("update book_list.book set read_already = 1 where title = " + title);
        Book book = (Book) entityManager.createNativeQuery("select * from book_list.book where title =" + title, Book.class).getSingleResult();
        System.out.println(book.getId());
        return entityManager.find(Book.class, title);
    }

    @Override
    public void delete(Book book) {
        entityManager.remove(book.getId());
    }

    @Override
    public void deleteById(Integer id) {
        entityManager.remove(id);
    }
}
