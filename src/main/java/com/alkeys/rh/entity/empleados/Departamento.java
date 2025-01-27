package com.alkeys.rh.entity.empleados;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity(name = "Departamento")
@Table(name = "departamentos", schema = "public")
@NamedQueries({
        @NamedQuery(
                name = "Departamento.countEmpleados",
                query = "SELECT COUNT(e) FROM Empleado e WHERE e.departamento.id = :id"
        ),
        @NamedQuery(
                name = "Departamento.DepartamentoCountEmpleados",
               query = "SELECT d.id as id, d.nombre as nombre, COUNT(e) FROM Empleado e RIGHT JOIN e.departamento d GROUP BY d.id, d.nombre"
        )
})
public class Departamento {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "nombre", nullable = false)
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}