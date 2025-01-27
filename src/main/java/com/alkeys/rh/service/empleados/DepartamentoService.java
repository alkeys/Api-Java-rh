package com.alkeys.rh.service.empleados;


import com.alkeys.rh.entity.empleados.Departamento;
import com.alkeys.rh.repository.empleados.DepartamentoRepository;
import com.alkeys.rh.service.utils.ServiceAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    /**
     * metodo para obtener la cantidad de empleados que tiene un departamento
     */
    public Long countEmpleados(Long id) {
        return departamentoRepository.countEmpleados(id);
    }

    /**
     * obitiene los departamentos y la cantidad de empleados que tiene cada uno
     */
    public List<Map<String, Object>> DepartamentoEmpleados() {
        Object[] results = departamentoRepository.DepartamentoCountEmpleados();
        List<Map<String, Object>> jsonResults = new ArrayList<>();
        for (Object result : results) {
            Object[] row = (Object[]) result;
            Map<String, Object> jsonResult = new HashMap<>();
            jsonResult.put("id", row[0]);
            jsonResult.put("nombre", row[1]);
            jsonResult.put("cantidad", row[2]);
            jsonResults.add(jsonResult);
        }
        return jsonResults;
    }

}
