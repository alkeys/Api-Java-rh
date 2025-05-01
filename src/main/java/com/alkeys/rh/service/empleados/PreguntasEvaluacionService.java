package com.alkeys.rh.service.empleados;

import com.alkeys.rh.entity.empleados.PreguntasEvaluacion;
import com.alkeys.rh.repository.empleados.PreguntasRepository;
import com.alkeys.rh.service.utils.ServiceAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PreguntasEvaluacionService  extends ServiceAbstract<PreguntasEvaluacion, Long> {

    @Autowired
    private PreguntasRepository preguntasRepository;

    @Override
    protected JpaRepository getRepository() {
        return preguntasRepository;
    }

    @Override
    public PreguntasEvaluacion update(Long id, PreguntasEvaluacion object) {
        return null;
    }

}
