package com.alkeys.rh.service;


import com.alkeys.rh.entity.Departamento;
import com.alkeys.rh.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoService extends ServiceAbstract<Departamento, Long> {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    protected JpaRepository getRepository() {
        return departamentoRepository;
    }

    @Override
    public Departamento update(Long id, Departamento object) {
        Departamento departamento = getById(id);
        if (departamento != null) {
            departamento.setNombre(object.getNombre());
            return departamentoRepository.save(departamento);
        }
        return null;
    }
}
