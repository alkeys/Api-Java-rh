package com.alkeys.rh.repository.empleados;

import com.alkeys.rh.entity.empleados.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>, JpaSpecificationExecutor<Departamento> {
    Long countEmpleados(Long id);

    Object[] DepartamentoCountEmpleados();
}