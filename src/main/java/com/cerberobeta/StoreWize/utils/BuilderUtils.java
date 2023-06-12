package com.cerberobeta.StoreWize.utils;

import org.slf4j.MDC;

import java.util.List;

public class BuilderUtils {

    private String codigo;
    private String mensaje = "Operaci\u00f3n Exitosa.";
    private Object resultado;
    private String folio = "0123456789";
    private String info;
    private List<String> detalles;

    private BuilderUtils builder()
    {
        return  new BuilderUtils();
    }
}
