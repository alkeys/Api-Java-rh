package com.alkeys.rh.service.empleados;

import com.alkeys.rh.entity.empleados.RespuestasEvaluacion;
import com.alkeys.rh.repository.empleados.RespuestasEvaluacionRepository;
import com.alkeys.rh.service.utils.ServiceAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RespuestasEvaluacionService extends ServiceAbstract<RespuestasEvaluacion, Long> {


    @Autowired
    private RespuestasEvaluacionRepository respuestasEvaluacionRepository;

    @Override
    protected JpaRepository getRepository() {
        return respuestasEvaluacionRepository;
    }


    @Override
    public RespuestasEvaluacion update(Long id, RespuestasEvaluacion object) {
        RespuestasEvaluacion respuestasEvaluacion = getById(id);
        if (respuestasEvaluacion != null) {
            respuestasEvaluacion.setEmpleado(object.getEmpleado());
            respuestasEvaluacion.setPregunta(object.getPregunta());
            respuestasEvaluacion.setCalificacion(object.getCalificacion());
            respuestasEvaluacion.setComentario(object.getComentario());
            respuestasEvaluacion.setFechaEvaluacion(object.getFechaEvaluacion());
            return respuestasEvaluacionRepository.save(respuestasEvaluacion);


        }
        return null;
    }

}
