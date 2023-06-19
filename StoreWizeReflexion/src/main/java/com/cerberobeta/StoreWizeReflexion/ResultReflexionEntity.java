package com.cerberobeta.StoreWizeReflexion;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultReflexionEntity {

    public String method;

    public int params;

    @JsonProperty("public")
    public boolean publico;

    @JsonProperty("private")
    public boolean privado;

    public String typeReturn;

    public CategoryEntity categories;

    public String category;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getParams() {
        return params;
    }

    public void setParams(int params) {
        this.params = params;
    }

    public CategoryEntity getCategories() {
        return categories;
    }

    public void setCategories(CategoryEntity categories) {
        this.categories = categories;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isPublico() {
        return publico;
    }

    public void setPublico(boolean publico) {
        this.publico = publico;
    }

    public boolean isPrivado() {
        return privado;
    }

    public void setPrivado(boolean privado) {
        this.privado = privado;
    }

    public String getTypeReturn() {
        return typeReturn;
    }

    public void setTypeReturn(String typeReturn) {
        this.typeReturn = typeReturn;
    }
}
