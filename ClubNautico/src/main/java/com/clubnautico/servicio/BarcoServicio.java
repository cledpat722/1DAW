package com.clubnautico.servicio;

import java.util.List;

import com.clubnautico.dto.BarcoDto;

public interface BarcoServicio {

	public BarcoDto crearBarco(String dni, BarcoDto barcoDto);
	
	public List<BarcoDto> obtenerBarcosSocioDni(String dni);
	
	public BarcoDto obtenerBarcoMatricula(String dni, String barcoMatricula);
}
