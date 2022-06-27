package com.example.repository.impl;


import com.example.model.Book;
import com.example.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository<Book, String, Integer> {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Book> findAll() {
        return entityManager.createQuery("select b from Book b", Book.class).getResultList();
    }

    public void updateBook(Book book, long id) {
        entityManager.createNativeQuery("update book_list.book set title = \"" + book.getTitle() + "\", description = \""
                + book.getDescription()+"\", isbn = \"" + book.getIsbn() +"\", print_year = \"" + book.getPrintYear() +"\"" +
                " where id = " + id + "").executeUpdate();
    }

    @Override
    public Book create(Book book) {
        if (Objects.isNull(book.getId())) {
            entityManager.persist(book);
            return book;
        } else {
            return entityManager.merge(book);
        }
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
        entityManager.remove(findById(id));
    }
}
