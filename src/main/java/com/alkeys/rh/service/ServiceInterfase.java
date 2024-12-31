package com.alkeys.rh.service;


import java.util.List;

/*
servicios de la aplicacion de recursos humanos genericos
implementados para la aplicacion
*/
public interface ServiceInterfase<T> {
    List<T> getAll();

    T getById(Long id);

    T save(T object);

    T update(Long id, T object);

    Boolean delete(Long id);

    Long count();

    List<T> getAllRange(int page, int size);

}
