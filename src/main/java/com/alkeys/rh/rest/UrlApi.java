package com.alkeys.rh.rest;

public final class UrlApi {
    public static final String ASISTENCIAS = "/rh-api/asistencias";
    public static final String EMPLEADOS = "/rh-api/empleados";
    public static final String SALARIOS = "/rh-api/salarios";
    public static final String CARGOS = "/rh-api/cargos";
    public static final String DEPARTAMENTOS = "/rh-api/departamentos";

    public static final String UserApp = "/rh-api/userapp";
    public static final String UserAppLogin = "/rh-api/userapp/login";

    public static final String Preguntas = "/rh-api/preguntas";
    public static final String Evaluaciones = "/rh-api/evaluaciones";

    public static final String RespuestasEvaluacion = "/rh-api/respuestas-evaluacion";

    private UrlApi() {
        // Constructor privado para evitar instanciación
    }
}
