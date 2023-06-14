package com.cerberobeta.StoreWize.exception;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

import java.util.List;

public class APIException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private int codigoError;
    private List<String> detalles;
    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
    private HttpStatus httpStatusCodigo = HttpStatus.BAD_REQUEST;

    private APIException () {}

    public APIException(int codigoError, @Nullable List<String> detalles, @NotNull HttpStatus httpStatus) {
        this.codigoError = codigoError;
        this.detalles = detalles;
        if (httpStatus != null)
            this.httpStatus = httpStatus;
        this.httpStatusCodigo = this.httpStatus;
    }

    public int getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(int codigoError) {
        this.codigoError = codigoError;
    }

    public List<String> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<String> detalles) {
        this.detalles = detalles;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatusCodigo() {
        return httpStatusCodigo;
    }

    public void setHttpStatusCodigo(HttpStatus httpStatusCodigo) {
        this.httpStatusCodigo = httpStatusCodigo;
    }
}
