package com.alkeys.rh.entity.empleados;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity(name = "PreguntasEvaluacion")
@Table(name = "preguntas_evaluacion")
public class PreguntasEvaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('preguntas_evaluacion_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;




    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "evaluacion_id", nullable = false)
    private Evaluacione evaluacion;

    @NotNull
    @Column(name = "pregunta", nullable = false, length = Integer.MAX_VALUE)
    private String pregunta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Evaluacione getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacione evaluacion) {
        this.evaluacion = evaluacion;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

}