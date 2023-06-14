package com.cerberobeta.StoreWize.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.slf4j.MDC;
import org.springframework.context.annotation.Scope;

import java.util.List;

import static com.cerberobeta.StoreWize.utils.ConstantsUtil.SPANID;
import static com.cerberobeta.StoreWize.utils.ConstantsUtil.TRACEID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Scope(value = "prototype")
public class GeneralResponseDTO {

    private String codigo;
    private String mensaje;
    private String folio;
    private Object resultado;
    private String info;
    private List<String> detalles;

    public GeneralResponseDTO() {

    }

    public GeneralResponseDTO(String codigo, String mensaje, Object resultado, String folio, String info, List<String> detalles)
    {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.folio = folio;
        this.resultado = resultado;
        this.info = info;
        this.detalles = detalles;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String codigo;
        private String mensaje = "Operaci\u00f3n Exitosa.";
        private Object resultado;
        private String folio = MDC.get(TRACEID) + "-" + MDC.get(SPANID);
        private String info;
        private List<String> detalles;

        public GeneralResponseDTO build() {
            return new GeneralResponseDTO(codigo, mensaje, resultado, folio, info, detalles);
        }

        public Builder setCodigo(String codigo) {
            this.codigo = codigo;
            return this;
        }

        public Builder setMensaje(String mensaje) {
            this.mensaje = mensaje;
            return this;
        }

        public Builder setResultado(Object resultado) {
            this.resultado = resultado;
            return this;
        }

        public Builder setFolio(String folio) {
            this.folio = folio;
            return this;
        }

        public Builder setInfo(String info) {
            this.info = info;
            return this;
        }

        public Builder setDetalles(List<String> detalles) {
            this.detalles = detalles;
            return this;
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public Object getResultado() {
        return resultado;
    }

    public void setResultado(Object resultado) {
        this.resultado = resultado;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<String> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<String> detalles) {
        this.detalles = detalles;
    }

}
