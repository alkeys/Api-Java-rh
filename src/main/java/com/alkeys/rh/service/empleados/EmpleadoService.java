package com.alkeys.rh.service.empleados;

import com.alkeys.rh.entity.empleados.Cargo;
import com.alkeys.rh.entity.empleados.Departamento;
import com.alkeys.rh.entity.empleados.Empleado;
import com.alkeys.rh.repository.empleados.EmpleadoRepository;
import com.alkeys.rh.service.utils.ServiceAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService extends ServiceAbstract<Empleado,Long> {

    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private DepartamentoService departamentoService;
    @Autowired
    private CargoService cargoService;

    @Override
    protected JpaRepository getRepository() {
        return empleadoRepository;
    }

    @Override
    public Empleado update(Long id, Empleado object) {
        Empleado empleado = getById(id);
        if (empleado != null) {
            empleado.setNombre(object.getNombre());
            empleado.setApellido(object.getApellido());
            empleado.setDepartamento(object.getDepartamento());
            empleado.setCargo(object.getCargo());
            empleado.setEmail(object.getEmail());
            empleado.setTelefono(object.getTelefono());
            return empleadoRepository.save(empleado);
        }
        return null;
    }

    /**
     *   "nombre": "string",
     *   "apellido": "string",
     *   "email": "string",
     *   "telefono": "string",
     *   "fechaContratacion": "2024-12-31",
     *   "departamentoId": 0,
     *   "cargoId": 0
     *
     */

    public Empleado save(Empleado object,Long DepartamentoId,Long CargoId) {
        Empleado empleado = new Empleado();
        Departamento departamento = departamentoService.getById(DepartamentoId);
        Cargo cargo = cargoService.getById(CargoId);
        if (departamento != null && cargo != null) {
            empleado.setNombre(object.getNombre());
            empleado.setApellido(object.getApellido());
            empleado.setDepartamento(departamento);
            empleado.setCargo(cargo);
            empleado.setEmail(object.getEmail());
            empleado.setTelefono(object.getTelefono());
            empleado.setFechaContratacion(object.getFechaContratacion());
            return empleadoRepository.save(empleado);
        }else {
            return null;
        }
    }


    public Empleado update(Long id, Empleado entity, Long departamentoId, Long cargoId) {
        Empleado empleado = getById(id);
        Departamento departamento = departamentoService.getById(departamentoId);
        Cargo cargo = cargoService.getById(cargoId);
        if (empleado != null && departamento != null && cargo != null) {
            empleado.setNombre(entity.getNombre());
            empleado.setApellido(entity.getApellido());
            empleado.setDepartamento(departamento);
            empleado.setCargo(cargo);
            empleado.setEmail(entity.getEmail());
            empleado.setTelefono(entity.getTelefono());
            empleado.setFechaContratacion(entity.getFechaContratacion());
            return empleadoRepository.save(empleado);
        }else {
            return null;
        }
    }
}
