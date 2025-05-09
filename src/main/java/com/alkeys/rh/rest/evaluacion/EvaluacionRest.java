package com.alkeys.rh.rest.evaluacion;


import com.alkeys.rh.entity.empleados.Evaluacione;
import com.alkeys.rh.rest.AbstractRest;
import com.alkeys.rh.service.empleados.EvaluacionSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.alkeys.rh.rest.UrlApi.Evaluaciones;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping( Evaluaciones) // rh-api/evaluaciones
public class EvaluacionRest  extends AbstractRest <Evaluacione, EvaluacionSevice> {
    @Autowired
    private EvaluacionSevice evaluacionSevice;

    @Override
    protected EvaluacionSevice getService() {
        return evaluacionSevice;
    }


}
