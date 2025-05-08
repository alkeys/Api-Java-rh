package com.alkeys.rh.repository.empleados;

import com.alkeys.rh.entity.empleados.RespuestasEvaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface RespuestasEvaluacionRepository extends JpaRepository<RespuestasEvaluacion, Long>, JpaSpecificationExecutor<RespuestasEvaluacion> {

}
