package repository.impl;

import lombok.RequiredArgsConstructor;
import model.Author;
import org.springframework.stereotype.Component;
import repository.AuthorRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository<Author, String> {

    private final EntityManager entityManager;

    @Override
    public List<Author> findAll() {
        return entityManager.createQuery("FROM book_list.author;", Author.class).getResultList();
    }

    @Override
    public void create(Author author) {
        entityManager.createQuery("insert into book_list.author(name) values (" + author.getName() + ");");
    }

    @Override
    public Author findByName(String name) {
        return entityManager.createQuery("FROM book_list.author where name =" + name, Author.class).getSingleResult();
    }

    @Override
    public void delete(Author author) {
        entityManager.remove(author.getId());
    }

    @Override
    public void deleteById(Integer id) {
        entityManager.remove(id);
    }
}
