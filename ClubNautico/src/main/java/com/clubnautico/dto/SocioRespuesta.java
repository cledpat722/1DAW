package com.clubnautico.dto;

import java.util.List;

public class SocioRespuesta {

	private List<SocioDto> contenido;
	private int numPagina;
	private int tamPagina;
	private long totalElementos;
	private int totalPaginas;
	private boolean ultima;

	public List<SocioDto> getContenido() {
		return contenido;
	}

	public void setContenido(List<SocioDto> contenido) {
		this.contenido = contenido;
	}

	public int getNumPagina() {
		return numPagina;
	}

	public void setNumPagina(int numPagina) {
		this.numPagina = numPagina;
	}

	public int getTamPagina() {
		return tamPagina;
	}

	public void setTamPagina(int tamPagina) {
		this.tamPagina = tamPagina;
	}

	public long getTotalElementos() {
		return totalElementos;
	}

	public void setTotalElementos(long totalElementos) {
		this.totalElementos = totalElementos;
	}

	public int getTotalPaginas() {
		return totalPaginas;
	}

	public void setTotalPaginas(int totalPaginas) {
		this.totalPaginas = totalPaginas;
	}

	public boolean isUltima() {
		return ultima;
	}

	public void setUltima(boolean ultima) {
		this.ultima = ultima;
	}

	public SocioRespuesta() {
	}

}
