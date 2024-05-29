package com.clubnautico.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clubnautico.dto.BarcoDto;
import com.clubnautico.servicio.BarcoServicio;

@RestController
@RequestMapping("/api/")
public class BarcoControlador {

	@Autowired
	private BarcoServicio barcoServicio;
	
	@GetMapping("/socio/{dni}/barco")
	public List<BarcoDto> listarBarcoSocioDni(@PathVariable(value = "dni") String dni){
		return barcoServicio.obtenerBarcosSocioDni(dni);
	}
 	
	@GetMapping("/socio/{dni}/barco/{matricula}")
	public ResponseEntity<BarcoDto> obtenerBarcoMatricula(@PathVariable(value = "dni") String dni, @PathVariable(value = "matricula") String matricula){
		BarcoDto barcoDto = barcoServicio.obtenerBarcoMatricula(dni, matricula);
		return new ResponseEntity<>(barcoDto, HttpStatus.OK);
	}
	
	@PostMapping("/socio/{dni}/barco")
	public ResponseEntity<BarcoDto> guardarBarco(@PathVariable(value = "dni") String dni, @RequestBody BarcoDto barcoDto){
		return new ResponseEntity<>(barcoServicio.crearBarco(dni, barcoDto), HttpStatus.CREATED);
	}
	
	
}
