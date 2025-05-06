package com.alkeys.rh.rest.evaluacion;


import com.alkeys.rh.entity.empleados.PreguntasEvaluacion;
import com.alkeys.rh.rest.AbstractRest;
import com.alkeys.rh.service.empleados.PreguntasEvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/preguntas")
public class PreguntasRest  extends AbstractRest<PreguntasEvaluacion, PreguntasEvaluacionService> {
    @Autowired
    private PreguntasEvaluacionService preguntasService;

    @Override
    protected PreguntasEvaluacionService getService() {
        return preguntasService;
    }

}
