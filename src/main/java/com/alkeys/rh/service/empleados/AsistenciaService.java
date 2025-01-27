package com.alkeys.rh.service.empleados;


import com.alkeys.rh.entity.empleados.Asistencia;
import com.alkeys.rh.repository.empleados.AsistenciaRepository;
import com.alkeys.rh.service.utils.ServiceAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsistenciaService extends ServiceAbstract<Asistencia, Long> {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @Autowired
    private EmpleadoService empleadoService;


    @Override
    protected JpaRepository<Asistencia, Long> getRepository() {
        return asistenciaRepository;
    }

    @Override
    public Asistencia update(Long id, Asistencia object) {
        Asistencia asistencia = getById(id);
        if (asistencia != null) {
            asistencia.setFecha(object.getFecha());
            asistencia.setHoraEntrada(object.getHoraEntrada());
            asistencia.setHoraSalida(object.getHoraSalida());
            asistencia.setEmpleado(object.getEmpleado());
            return save(asistencia);
        }
        return null;
    }

    public List<Asistencia> findByIdEmpleado(Long id) {
        return asistenciaRepository.findByIdEmpleado(id);
    }


    /**
     * metedo para obtener el promedio de horas trabajadas por todos los empleados
     */
    public double promedioHorasTrabajadas() {
        List<Asistencia> asistencias = asistenciaRepository.findAll();
        Long cantidaEmpleados = empleadoService.count();
        double promedio = 0;
        for (Asistencia asistencia : asistencias) {
            promedio += asistencia.getHoraSalida().getHour() - asistencia.getHoraEntrada().getHour();
        }
        return promedio / cantidaEmpleados;
    }


    /**
     * metodo para obtener el promedio de horas trabajadas por un empleado
     */
    public double promedioHorasTrabajadasEmpleado(Long id) {
        List<Asistencia> asistencias = asistenciaRepository.findByIdEmpleado(id);
        Long cantidaEmpleados = empleadoService.count();
        double promedio = 0;
        for (Asistencia asistencia : asistencias) {
            promedio += asistencia.getHoraSalida().getHour() - asistencia.getHoraEntrada().getHour();
        }
        return promedio / cantidaEmpleados;
    }

    /**
     * metodo para obtener el promedio de asitencia de todos los empleados
     */
    public double promedioAsistencia() {
        List<Asistencia> asistencias = asistenciaRepository.findAll();
        Long cantidaEmpleados = empleadoService.count();
        double promedio = 0;
        for (Asistencia asistencia : asistencias) {
            if (asistencia.getHoraSalida() != null) {
                promedio++;
            }
        }
        return promedio / cantidaEmpleados;
    }
}
