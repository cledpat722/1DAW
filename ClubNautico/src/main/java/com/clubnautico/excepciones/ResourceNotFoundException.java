package com.clubnautico.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String nombreRecurso;
	private String nombreCampo;
	private String valorCampo;

	public ResourceNotFoundException(String nombreRecurso, String nombreCampo, String dni) {
		super(String.format("%s no encontrado con %s = '%s'", nombreRecurso, nombreCampo, dni));
		this.nombreRecurso = nombreRecurso;
		this.nombreCampo = nombreCampo;
		this.valorCampo = dni;
	}

	public String getNombreRecurso() {
		return nombreRecurso;
	}

	public void setNombreRecurso(String nombreRecurso) {
		this.nombreRecurso = nombreRecurso;
	}

	public String getNombreCampo() {
		return nombreCampo;
	}

	public void setNombreCampo(String nombreCampo) {
		this.nombreCampo = nombreCampo;
	}

	public String getValorCampo() {
		return valorCampo;
	}

	public void setValorCampo(String valorCampo) {
		this.valorCampo = valorCampo;
	}

}
