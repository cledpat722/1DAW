package com.clubnautico.servicio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.clubnautico.dto.BarcoDto;
import com.clubnautico.entidades.Barco;
import com.clubnautico.entidades.Socio;
import com.clubnautico.excepciones.ClubNauticoAppException;
import com.clubnautico.excepciones.ResourceNotFoundException;
import com.clubnautico.repositorio.BarcoRepositorio;
import com.clubnautico.repositorio.SocioRepositorio;

@Service
public class BarcoServicioImpl implements BarcoServicio{

	@Autowired
	private BarcoRepositorio barcoRepositorio;
	
	@Autowired
	private SocioRepositorio socioRepositorio;
	
	@Override
	public BarcoDto crearBarco(String matricula, BarcoDto barcoDto) {
		Barco barco = mapearEntidad(barcoDto);
		Socio socio = socioRepositorio.findById(matricula).orElseThrow(() -> new ResourceNotFoundException("Socio", "dni", matricula));
		
		barco.setSocio(socio);
		Barco nuevoBarco = barcoRepositorio.save(barco);
		
		return mapearDto(nuevoBarco);
	}

	private BarcoDto mapearDto(Barco barco) {
		BarcoDto barcoDto = new BarcoDto();
		barcoDto.setMatricula(barco.getMatricula());
		barcoDto.setNombre(barco.getNombre());
		barcoDto.setNumAmarre(barco.getNumAmarre());
		barcoDto.setCuota(barco.getCuota());
		
		return barcoDto;
	}
	
	private Barco mapearEntidad(BarcoDto barcoDto) {
		Barco barco = new Barco();
		barco.setMatricula(barcoDto.getMatricula());
		barco.setNombre(barcoDto.getNombre());
		barco.setNumAmarre(barcoDto.getNumAmarre());
		barco.setCuota(barcoDto.getCuota());
		
		return barco;
	}

	@Override
	public List<BarcoDto> obtenerBarcosSocioDni(String dni) {
		List<Barco> barcos = barcoRepositorio.findBySocioDni(dni);
		
		return barcos.stream().map(barco -> mapearDto(barco)).collect(Collectors.toList());
	}

	@Override
	public BarcoDto obtenerBarcoMatricula(String dni, String matricula) {
		Socio socio = socioRepositorio.findById(matricula).orElseThrow(() -> new ResourceNotFoundException("Socio", "dni: ", dni));
		
		Barco barco = barcoRepositorio.findById(matricula).orElseThrow(() -> new ResourceNotFoundException("Barco", "matrícula: ", matricula));
		
		if (!barco.getSocio().getDni().equals(socio.getDni())) {
			throw new ClubNauticoAppException(HttpStatus.BAD_REQUEST, "El barco no pertenece al socio");
		}
		return mapearDto(barco);
	}
	
	
}
