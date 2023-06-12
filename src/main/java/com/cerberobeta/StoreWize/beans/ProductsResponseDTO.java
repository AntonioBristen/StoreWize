package com.cerberobeta.StoreWize.beans;

import com.cerberobeta.StoreWize.entities.products.Product;

import java.util.List;

public class ProductsResponseDTO {

    private List<Product> resultado;

    private String mensaje;

    private String folio;

    public List<Product> getResultado() {
        return resultado;
    }

    public void setResultado(List<Product> resultado) {
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
