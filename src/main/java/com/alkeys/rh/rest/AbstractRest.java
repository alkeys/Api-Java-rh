package com.alkeys.rh.rest;

import com.alkeys.rh.service.utils.ServiceInterfase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractRest<T, S extends ServiceInterfase<T>> implements InterfaceRest<T> {

    protected static final Logger LOGGER = Logger.getLogger(AbstractRest.class.getName());

    protected abstract S getService();

    @Override
    @GetMapping("/")
    public String index() {
        return "Bienvenido a la API de Recursos Humanos @alkeys";
    }

    @Override
    @GetMapping("/all/")
    public ResponseEntity<List<T>> findAll() {
        LOGGER.info("findAll");
        return ResponseEntity.ok(getService().getAll());
    }

    @Override
    @GetMapping("/count/")
    public ResponseEntity<Long> count() {
        LOGGER.info("count");
        return ResponseEntity.ok(getService().count());
    }

    @Override
    @GetMapping("/id/{id}/")
    public ResponseEntity<T> findById(@PathVariable Long id) {
        LOGGER.info("findById");
        return ResponseEntity.ok(getService().getById(id));
    }

    @Override
    @PostMapping("/save/")
    public ResponseEntity<T> save(@RequestBody T entity) {
        LOGGER.info("save");
        return ResponseEntity.ok(getService().save(entity));
    }


    @Override
    @DeleteMapping("/delete/{id}/")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        LOGGER.info("delete");
        return ResponseEntity.ok(getService().delete(id));
    }

    @Override
    @PutMapping("/update/{id}/")
    public ResponseEntity<T> update(@PathVariable Long id, @RequestBody T entity) {
        LOGGER.info("update");
        return ResponseEntity.ok(getService().update(id, entity));
    }


}
