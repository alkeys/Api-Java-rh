package com.alkeys.rh.entity.empleados;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "respuestas_evaluacion")
public class RespuestasEvaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('respuestas_evaluacion_id_seq')")
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "empleado_id", nullable = false)
    private Empleado empleado;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "pregunta_id", nullable = false)
    private PreguntasEvaluacion pregunta;

    @NotNull
    @Column(name = "calificacion", nullable = false, precision = 5, scale = 2)
    private BigDecimal calificacion;

    @Column(name = "comentario", length = Integer.MAX_VALUE)
    private String comentario;

    @NotNull
    @Column(name = "fecha_evaluacion", nullable = false)
    private LocalDate fechaEvaluacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public PreguntasEvaluacion getPregunta() {
        return pregunta;
    }

    public void setPregunta(PreguntasEvaluacion pregunta) {
        this.pregunta = pregunta;
    }

    public BigDecimal getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

}