package com.alkeys.rh.rest;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InterfaceRest<T> {
    String index();
    ResponseEntity<List<T>> findAll();
    ResponseEntity<Long> count();
    ResponseEntity<T> findById(Long id);
    ResponseEntity<T> save(T entity);
    ResponseEntity<Boolean> delete(Long id);
    ResponseEntity<T> update(Long id, T entity);
}
