package com.example.repository;

import java.util.List;

public interface DefaultCrudRepository<K, T, N> {

    List<K> findAll();

    void create(K k);

    K findById(N n);

    void delete(K k);

    void deleteById(N n);



}
