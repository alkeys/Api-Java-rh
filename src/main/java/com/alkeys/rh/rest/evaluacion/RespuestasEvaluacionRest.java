package com.alkeys.rh.rest.evaluacion;


import com.alkeys.rh.entity.empleados.RespuestasEvaluacion;
import com.alkeys.rh.rest.AbstractRest;
import com.alkeys.rh.service.empleados.RespuestasEvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.alkeys.rh.rest.UrlApi.RespuestasEvaluacion;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(RespuestasEvaluacion) // rh-api/respuestas-evaluacion
public class RespuestasEvaluacionRest extends AbstractRest<RespuestasEvaluacion, RespuestasEvaluacionService> {
    @Autowired
    private RespuestasEvaluacionService respuestasEvaluacionService;

    @Override
    protected RespuestasEvaluacionService getService() {
        return respuestasEvaluacionService;
    }
}
