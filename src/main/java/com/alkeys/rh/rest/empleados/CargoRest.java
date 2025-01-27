package com.alkeys.rh.rest.empleados;


import com.alkeys.rh.entity.empleados.Cargo;
import com.alkeys.rh.rest.AbstractRest;
import com.alkeys.rh.rest.UrlApi;
import com.alkeys.rh.service.empleados.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(UrlApi.CARGOS)
public class CargoRest extends AbstractRest<Cargo, CargoService> {

    @Autowired
    private CargoService cargoService;

    @Override
    protected CargoService getService() {
        return cargoService;
    }
}
