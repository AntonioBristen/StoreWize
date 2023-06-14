package com.cerberobeta.StoreWize.exception;

import java.util.List;
public class ResponseException extends Exception{
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String mensaje;
	private String folio;
	private String info;
	private List<String> detalles;
	public ResponseException() { }

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
