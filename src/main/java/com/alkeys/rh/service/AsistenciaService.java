package com.alkeys.rh.service;


import com.alkeys.rh.entity.Asistencia;
import com.alkeys.rh.repository.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsistenciaService extends ServiceAbstract<Asistencia, Long> {

    @Autowired
    private AsistenciaRepository asistenciaRepository;


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
}
