package service.impl;

import model.Genre;
import service.GenreService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

public class GenreServiceImpl implements GenreService {

    @PersistenceContext
    static EntityManager manager;

    public GenreServiceImpl() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pers");
        manager = factory.createEntityManager();
    }

    @Override
    public void createGenre(String name) {
        manager.createQuery("insert into book_list.genre(name) values (" + name + ");");
    }

    @Override
    public void deleteGenre(int id) {
        manager.remove(id);
    }

    @Override
    public List<Genre> genreList() {
        return manager.createQuery("FROM book_list.genre;", Genre.class).getResultList();
    }

    @Override
    public Genre findGenre(String name) {
        return manager.createQuery("FROM book_list.genre where name =" + name, Genre.class).getSingleResult();
    }
}
