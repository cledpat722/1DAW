package com.clubnautico.excepciones;

import org.springframework.http.HttpStatus;

public class ClubNauticoAppException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private HttpStatus estado;

	private String mensaje;

	public ClubNauticoAppException(HttpStatus estado, String mensaje) {
		this.estado = estado;
		this.mensaje = mensaje;
	}

	public ClubNauticoAppException(HttpStatus estado, String mensaje, String mensaje1) {
		this.estado = estado;
		this.mensaje = mensaje;
		this.mensaje = mensaje1;
	}

	public HttpStatus getEstado() {
		return estado;
	}

	public void setEstado(HttpStatus estado) {
		this.estado = estado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
