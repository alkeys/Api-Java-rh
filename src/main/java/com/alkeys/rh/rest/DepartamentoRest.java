package com.alkeys.rh.rest;


import com.alkeys.rh.entity.Departamento;
import com.alkeys.rh.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
