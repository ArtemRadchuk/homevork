package service.impl;

import model.Author;
import model.Book;
import service.AuthorService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    @PersistenceContext
    static EntityManager manager;

    public AuthorServiceImpl() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pers");
        manager = factory.createEntityManager();
    }


    @Override
    public void createAuthor(String name) {
        manager.createQuery("insert into book_list.author(name) values (" + name + ");");
    }

    @Override
    public void deleteAuthor(int id) {
        manager.remove(id);
    }

    @Override
    public List<Author> authorList() {
        return manager.createQuery("FROM book_list.author;", Author.class).getResultList();
    }

    @Override
    public Author findAuthor(String name) {
        return manager.createQuery("FROM book_list.author where name =" + name, Author.class).getSingleResult();
    }
}
