package repository;

import model.Author;

public interface AuthorRepository<K, T> extends DefaultCrudRepository<Author, String, Integer>{
}
