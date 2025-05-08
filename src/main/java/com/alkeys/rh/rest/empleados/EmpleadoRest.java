package com.alkeys.rh.rest.empleados;

import com.alkeys.rh.entity.empleados.Empleado;
import com.alkeys.rh.rest.AbstractRest;
import com.alkeys.rh.rest.UrlApi;
import com.alkeys.rh.service.empleados.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(UrlApi.EMPLEADOS)
public class EmpleadoRest extends AbstractRest<Empleado, EmpleadoService> {

    @Autowired
    private EmpleadoService empleadoService;

    @Override
    protected EmpleadoService getService() {
        return empleadoService;
    }

    @Override
    @PostMapping("/save/")
    public ResponseEntity<Empleado> save(@RequestBody Empleado entity) {
        throw new UnsupportedOperationException("Save No soportado Para Empleado Ocupar saveEmpleado");
    }


    @Override
    @PutMapping("/update/{id}/")
    public ResponseEntity<Empleado> update(@PathVariable Long id, @RequestBody Empleado entity) {
        throw new UnsupportedOperationException("Update No soportado Para Empleado Ocupar updateEmpleado");
    }




            /*
            Este metodo es para guardar un empleado con su departamento y cargo
                        {
                    {
                      "nombre": "aviles",
                      "apellido": "moran",
                      "email": "stringsdgsa",
                      "telefono": "748596",
                      "fechaContratacion": "2024-12-31",
                    }

        esta es la estructura de un empleado para guardar con la api de openapi
             */

    @PostMapping("/saveEmpleado/")
    public Empleado saveEmpleado(
            @RequestBody Empleado empleado,
            @RequestParam("DepartamentoId") Long departamentoId,
            @RequestParam("CargoId") Long cargoId) {
        return empleadoService.save(empleado, departamentoId, cargoId);
    }


    @PutMapping("/updateEmpleado/{id}/")
    public Empleado update(@PathVariable Long id, @RequestBody Empleado entity, Long DepartamentoId, Long CargoId) {
        return empleadoService.update(id, entity, DepartamentoId, CargoId);
    }



}
