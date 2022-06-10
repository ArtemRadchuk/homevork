package repository;

import model.Book;

public interface BookRepository<K, T, N extends Number> extends DefaultCrudRepository<Book, String, Integer>{

}
