package com.alkeys.rh.service.empleados;

import com.alkeys.rh.entity.empleados.Departamento;
import com.alkeys.rh.entity.empleados.Evaluacione;
import com.alkeys.rh.repository.empleados.EvaluacionRepository;
import com.alkeys.rh.service.utils.ServiceAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class EvaluacionSevice extends ServiceAbstract<Evaluacione, Long> {

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    @Override
    protected JpaRepository getRepository() {return evaluacionRepository;}


    @Override
    public Evaluacione update(Long id, Evaluacione object) {
        return null;
    }


}
