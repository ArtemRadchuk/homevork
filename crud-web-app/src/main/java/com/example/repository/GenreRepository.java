package com.example.repository;


import com.example.model.Genre;

public interface GenreRepository<T, N extends Number> extends DefaultCrudRepository<Genre, String, Long> {
}
