package service.impl;

import model.Book;
import org.springframework.stereotype.Repository;
import service.BookService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookServiceImpl implements BookService {
    @PersistenceContext
    static
    EntityManager manager;


    @Override
    public void createBook(Book book) {
        manager.createQuery("insert into book_list.book(title, description, isbn, print_year, read_already) values ("
                + book.getTitle() + "," + book.getDescription() + "," + book.getIsbn() + "," +
                book.getPrintYear() + "," + book.readAlready + ");");
    }

    @Override
    public String readBook() {
        return null;
    }

    @Override
    public void updateBook() {

    }

    @Override
    public void deleteBook(Book book) {
        manager.remove(book);
    }

    @Override
    public List<Book> allBook() {
        return manager.createQuery("SELECT * FROM book_list.book;", Book.class).getResultList();
    }

    @Override
    public Book findBook(String title) {
        return manager.createQuery("SELECT * FROM book_list.book where title =" + title, Book.class).getSingleResult();
    }
}
