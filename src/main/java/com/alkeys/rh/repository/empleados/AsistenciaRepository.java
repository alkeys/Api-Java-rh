package com.alkeys.rh.repository.empleados;

import com.alkeys.rh.entity.empleados.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Long>, JpaSpecificationExecutor<Asistencia> {
    List<Asistencia> findByIdEmpleado(Long id);
}