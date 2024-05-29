package com.clubnautico.servicio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.clubnautico.dto.SocioDto;
import com.clubnautico.entidades.Socio;
import com.clubnautico.excepciones.ResourceNotFoundException;
import com.clubnautico.repositorio.SocioRepositorio;

@Service
public class SocioServicioImpl implements SocioServicio{

	@Autowired
	private SocioRepositorio socioRepositorio;
	
	@Override
	public SocioDto crearSocio(SocioDto socioDto) {
		Socio socio = mapearEntidad(socioDto);
		
		Socio nuevoSocio = socioRepositorio.save(socio);
		
		SocioDto socioRespuesta = mapearDto(nuevoSocio);
		
		return socioRespuesta;
	}

	@Override
	public List<SocioDto> obtenerSocios(int numPagina, int tamPagina) {
		Pageable pageable = PageRequest.of(numPagina, tamPagina);
		
		Page<Socio> socios = socioRepositorio.findAll(pageable);
		
		List<Socio> listaSocios= socios.getContent();
		
		return listaSocios.stream().map(socio -> mapearDto(socio)).collect(Collectors.toList());
	}
	
	//Convierte entidad a DTO
	private SocioDto mapearDto(Socio socio) {
		
		SocioDto socioDto = new SocioDto();
		
		socioDto.setDni(socio.getDni());
		socioDto.setNombre(socio.getNombre());
		socioDto.setApellido(socio.getApellido());
		socioDto.setTelefono(socio.getTelefono());
		
		return socioDto;
	}
	
	//Convierte DTO a entidad
	private Socio mapearEntidad(SocioDto socioDto) {
		
		Socio socio = new Socio();
		
		socio.setDni(socioDto.getDni());
		socio.setNombre(socioDto.getNombre());
		socio.setApellido(socioDto.getApellido());
		socio.setTelefono(socioDto.getTelefono());
		
		return socio;
	}

	@Override
	public SocioDto obtenerSocioDni(String dni) {
		
		Socio socio = socioRepositorio.findById(dni).orElseThrow(() -> new ResourceNotFoundException("Socio", "dni", dni));
		return mapearDto(socio);
	}

	@Override
	public SocioDto actualizarSocio(SocioDto socioDto, String dni) {
		
		Socio socio = socioRepositorio.findById(dni).orElseThrow(() -> new ResourceNotFoundException("Socio", "dni", dni));
		
		socio.setNombre(socioDto.getNombre());
		socio.setApellido(socioDto.getApellido());
		socio.setTelefono(socioDto.getTelefono());
		
		Socio socioActualizado = socioRepositorio.save(socio);
		
		return mapearDto(socioActualizado);
	}

	@Override
	public void eliminarSocio(String dni) {
		
		Socio socio = socioRepositorio.findById(dni).orElseThrow(() -> new ResourceNotFoundException("Socio", "dni", dni));
		
		socioRepositorio.delete(socio);
		
	}


	
}
