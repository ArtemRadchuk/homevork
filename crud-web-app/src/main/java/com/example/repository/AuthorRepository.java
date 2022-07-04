package com.example.repository;


import com.example.model.Author;

public interface AuthorRepository<K, T> extends DefaultCrudRepository<Author, String, Long> {
}
