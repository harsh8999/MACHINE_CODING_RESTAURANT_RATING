package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

public interface ICrudRepository<T, ID> {

    T save(T entity);

    void deleteById(ID id);

    List<T> findAll();
    
    Optional<T> findById(ID id);

}
