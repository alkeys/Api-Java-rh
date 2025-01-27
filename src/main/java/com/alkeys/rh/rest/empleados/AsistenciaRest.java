package com.alkeys.rh.rest.empleados;


import com.alkeys.rh.entity.empleados.Asistencia;
import com.alkeys.rh.rest.AbstractRest;
import com.alkeys.rh.rest.UrlApi;
import com.alkeys.rh.service.empleados.AsistenciaService;
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



    @GetMapping("/promedioHorasTrabajadas/")
    public double promedioHorasTrabajadas() {
        return asistenciaService.promedioHorasTrabajadas();
    }

    @GetMapping("/promedioHorasTrabajadasEmpleado/{id}/")
    public double promedioHorasTrabajadasEmpleado(@PathVariable Long id) {
        return asistenciaService.promedioHorasTrabajadasEmpleado(id);
    }
    
    @GetMapping("/promedioAsistencia/")
    public double promedioAsistencia() {
        return asistenciaService.promedioAsistencia();
    }
}
