package com.alkeys.rh.entity.obj;

public class DepartamentoObj {
    private Long id;
    private String nombre;

    public DepartamentoObj() {
    }

    public DepartamentoObj(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
