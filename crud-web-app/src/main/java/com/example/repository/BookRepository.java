package com.example.repository;

import com.example.model.Book;

public interface BookRepository<K, T, N extends Number> extends DefaultCrudRepository<Book, String, Long> {

}
