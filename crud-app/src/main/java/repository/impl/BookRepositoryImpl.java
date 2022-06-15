package com.example.repository.impl;


import com.example.model.Book;
import com.example.repository.BookRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository<Book, String, Integer> {

    private final EntityManager entityManager;

    @Override
    public List<Book> findAll() {
        return entityManager.createQuery("FROM book_list.book;", Book.class).getResultList();
    }

    public void updateBook(int id ,String title, String description, String isbn, int printYear) {
        entityManager.createQuery("update book_list.book set(title, description, isbn, print_year, read_already) = ("
                + title + ", " + description + ", " + isbn + ", " + ", " + printYear +
                ", 0) where id = "  + id +";");
        entityManager.createQuery("update book_list.book set read_already = 0 where id = " + id);
    }

    @Override
    public void create(Book book) {
        entityManager.createQuery("insert into book_list.book(title, description, isbn, author, genre,  print_year, read_already) values" +
                " (" + book.getTitle() + ", " + book.getDescription() + ", " + book.getIsbn() + ", " + book.getAuthor() +
                ", " + book.getGenre()  + ", " + book.getPrintYear() + ", 0);");
    }

    @Override
    public Book findByName(String title) {
        Query id = entityManager.createQuery("select id where title = " + title);
        entityManager.createQuery("update book_list.book set read_already = 1 where id = " + id.getSingleResult());
        return entityManager.createQuery("FROM book_list.book where title =" + title, Book.class).getSingleResult();
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
