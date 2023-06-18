package com.cerberobeta.StoreWize.beans;

import com.cerberobeta.StoreWize.entities.carts.StoreCartEntiry;

import java.util.List;

public class CartsResponseDTO {

    private List<StoreCartEntiry> resultado;

    private String mensaje;

    private String folio;

    public List<StoreCartEntiry> getResultado() {
        return resultado;
    }

    public void setResultado(List<StoreCartEntiry> resultado) {
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
