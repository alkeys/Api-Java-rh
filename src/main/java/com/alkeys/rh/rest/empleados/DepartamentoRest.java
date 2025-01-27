package com.alkeys.rh.rest.empleados;


import com.alkeys.rh.entity.empleados.Departamento;
import com.alkeys.rh.rest.AbstractRest;
import com.alkeys.rh.rest.UrlApi;
import com.alkeys.rh.service.empleados.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(UrlApi.DEPARTAMENTOS)
public class DepartamentoRest extends AbstractRest<Departamento, DepartamentoService> {

    @Autowired
    private DepartamentoService departamentoService;

    @Override
    protected DepartamentoService getService() {
        return departamentoService;
    }


    @GetMapping("/countEmpleados/")
    public Long countEmpleados(Long id) {
        return departamentoService.countEmpleados(id);
    }

    @GetMapping("/DepartamentoEmpleados/")
    public List<Map<String, Object>> DepartamentoEmpleados() {
        return departamentoService.DepartamentoEmpleados();
    }
}
