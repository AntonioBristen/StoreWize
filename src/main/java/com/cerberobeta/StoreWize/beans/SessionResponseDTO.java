package com.cerberobeta.StoreWize.beans;

import com.cerberobeta.StoreWize.entities.session.RequestSessionEntity;

public class SessionResponseDTO {

    private RequestSessionEntity resultado;

    private String mensaje;

    private String folio;

    public RequestSessionEntity getResultado() {
        return resultado;
    }

    public void setResultado(RequestSessionEntity resultado) {
        this.resultado = resultado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }
}
