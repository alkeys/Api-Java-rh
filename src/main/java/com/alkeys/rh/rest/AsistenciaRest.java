package com.alkeys.rh.rest;


import com.alkeys.rh.entity.Asistencia;
import com.alkeys.rh.service.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(UrlApi.ASISTENCIAS)
public class AsistenciaRest extends AbstractRest<Asistencia, AsistenciaService> {

    @Autowired
    private AsistenciaService asistenciaService;

    @Override
    protected AsistenciaService getService() {
        return asistenciaService;
    }

    @GetMapping("/idEmpleado/{id}/")
    public List<Asistencia> findByIdEmpleado(@PathVariable Long id) {
        return asistenciaService.findByIdEmpleado(id);
    }
}
