package com.cerberobeta.StoreWize.exception;

public class NotFoundException extends Exception{

    private static final long serialVersionUID = -948845514875340820L;

    private String valor;

    public NotFoundException(String valor, String message) {
        super(message);
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
