package com.alkeys.rh.repository.empleados;

import com.alkeys.rh.entity.empleados.Evaluacione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface EvaluacionRepository extends JpaRepository<Evaluacione, Long> , JpaSpecificationExecutor<Evaluacione> {
}
