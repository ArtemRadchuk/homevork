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
        /*entityManager.createNativeQuery("insert into book_list.book(title, description, isbn, author_id, genre_id,  print_year, read_already) values" +
                " (\"" + book.getTitle() + "\", \"" + book.getDescription() + "\", \"" + book.getIsbn() + "\", \"" + book.getAuthor().getId() +
                "\", \"" + book.getGenre().getId() + "\", \"" + book.getPrintYear() + "\", \" 0\")").executeUpdate();*/
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

    public List<Book> findByAuthor(long authorId){
        return entityManager.createQuery("select b from Book b where author_id = " + authorId, Book.class).getResultList();
    }

    public List<Book> findByGenre(long genreId){
        return entityManager.createQuery("select b from Book b where genre_id = " + genreId, Book.class).getResultList();
    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(findById(id));
    }
}
