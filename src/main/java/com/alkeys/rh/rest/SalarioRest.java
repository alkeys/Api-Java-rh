package com.alkeys.rh.rest;


import com.alkeys.rh.entity.Salario;
import com.alkeys.rh.service.SalarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(UrlApi.SALARIOS)
public class SalarioRest extends AbstractRest<Salario, SalarioService> {

    @Autowired
    private SalarioService salarioService;

    @Override
    protected SalarioService getService() {
        return salarioService;
    }
}
