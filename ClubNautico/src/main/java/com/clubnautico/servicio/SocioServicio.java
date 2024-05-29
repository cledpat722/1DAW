package com.clubnautico.servicio;

import java.util.List;

import com.clubnautico.dto.SocioDto;

public interface SocioServicio {

	public SocioDto crearSocio(SocioDto socioDto);
	
	public List<SocioDto> obtenerSocios(int numPagina, int tamPagina);
	
	public SocioDto obtenerSocioDni(String dni);
	
	public SocioDto actualizarSocio(SocioDto socioDto, String dni);
	
	public void eliminarSocio(String dni);

	//SocioDto obtenerSocioDni(String dni);
}
