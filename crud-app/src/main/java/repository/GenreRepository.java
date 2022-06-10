package repository;

import model.Genre;

public interface GenreRepository<T, N extends Number> extends DefaultCrudRepository<Genre, String, Integer>{
}
