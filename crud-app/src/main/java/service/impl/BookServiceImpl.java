package service.impl;

import model.Book;
import org.springframework.stereotype.Repository;
import service.BookService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookServiceImpl implements BookService {
    @PersistenceContext
    static EntityManager manager;

    public BookServiceImpl() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pers");
        manager = factory.createEntityManager();
    }

    @Override
    public void createBook(String title, String description, long isbn, String author, String genre, int print_year) {
        manager.createQuery("insert into book_list.book(title, description, isbn, author, genre,  print_year, read_already) values" +
                " (" + title + ", " + description + ", " + isbn + ", " + author + ", " + genre  + ", " + print_year + ", 0);");
    }

    @Override
    public String readBook() {
        return null;
    }

    @Override
    public void updateBook(Book book, String title, String description, String isbn, int printYear) {
        manager.createQuery("update book_list.book set(title, description, isbn, print_year, read_already) = (" + title + ", " + description + ", " + isbn + ", " + printYear + ", 0);");
    }

    @Override
    public void deleteBook(int id) {
        manager.remove(id);
    }

    @Override
    public List<Book> allBook() {
        return manager.createQuery("FROM book_list.book;", Book.class).getResultList();
    }

    @Override
    public Book findBook(String title) {
        return manager.createQuery("FROM book_list.book where title =" + title, Book.class).getSingleResult();
    }
}
