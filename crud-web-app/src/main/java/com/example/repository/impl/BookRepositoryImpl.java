package com.example.repository.impl;


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

    public void updateBook(Book book, long id) {
        entityManager.createNativeQuery("update book_list.book set title = \"" + book.getTitle() + "\", description = \""
                + book.getDescription()+"\", isbn = \"" + book.getIsbn() +"\", print_year = \"" + book.getPrintYear() +"\"" +
                " where id = " + id + "").executeUpdate();
    }

    @Override
    public void create(Book book) {
        entityManager.createNativeQuery("insert into book_list.book(title, description, isbn, author, genre,  print_year, read_already) values" +
                " (\"" + book.getTitle() + "\", \"" + book.getDescription() + "\", \"" + book.getIsbn() + "\", \"" + book.getAuthorName() +
                "\", \"" + book.getGenreName() + "\", \"" + book.getPrintYear() + "\", \" 0\")").executeUpdate();
    }

    @Override
    public Book findById(Long id) {
        entityManager.createNativeQuery("update book_list.book set read_already = 1 where id = " + id);
        return entityManager.find(Book.class, id);
    }

    @Override
    public void delete(Book book) {
        entityManager.remove(book.getId());
    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(id);
    }
}
