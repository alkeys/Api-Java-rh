package com.alkeys.rh.repository.empleados;

import com.alkeys.rh.entity.empleados.PreguntasEvaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

public interface PreguntasRepository extends JpaRepository<PreguntasEvaluacion, Long> , JpaSpecificationExecutor<PreguntasEvaluacion> {
}
