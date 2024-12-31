package com.alkeys.rh.service;


import com.alkeys.rh.entity.Salario;
import com.alkeys.rh.repository.SalarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalarioService extends ServiceAbstract<Salario, Long> {

    @Autowired
    private SalarioRepository salarioRepository;

    @Override
    protected JpaRepository<Salario, Long> getRepository() {
        return salarioRepository;
    }

    @Override
    public Salario update(Long id, Salario object) {
        Salario salario = salarioRepository.findById(id).orElse(null);
        if (salario != null) {
            salario.setSalario(object.getSalario());
            salario.setFechaInicio(object.getFechaInicio());
            salario.setFechaFin(object.getFechaFin());
            salario.setEmpleado(object.getEmpleado());
            return salarioRepository.save(salario);
        }else {
            return null;
        }
    }
}
