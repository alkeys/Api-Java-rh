package com.alkeys.rh.service;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Clase abstracta que implementa la interfaz de servicio
 * @param <T> esta clase recibe un tipo de dato generico T o clases entidades
 * @param <ID> El tipo de dato de la llave primaria de la entidad T
 *
    */


public abstract class ServiceAbstract<T,ID> implements ServiceInterfase<T> {

    protected abstract JpaRepository<T, ID> getRepository();

    @Override
    public List<T> getAll() {
        return getRepository().findAll();
    }

    @Override
    public T getById(Long id) {
        return getRepository().findById((ID) id).orElse(null);
    }

    @Override
    public T save(T object) {
        return getRepository().save(object);
    }


    @Override
    public Boolean delete(Long id) {
        if (getRepository().existsById((ID) id)) {
            getRepository().deleteById((ID) id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Long count() {
        return getRepository().count();
    }

    @Override
    public List<T> getAllRange(int page, int size) {
        return getRepository().findAll(PageRequest.of(page, size)).getContent();
    }





}