package com.clubnautico.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clubnautico.dto.SocioDto;
import com.clubnautico.servicio.SocioServicio;

@RestController
@RequestMapping("/api/socio")
public class SocioControlador {

	@Autowired
	private SocioServicio socioServicio;

	@GetMapping
	public List<SocioDto> listarSocios(
			@RequestParam(value = "pageNo", defaultValue = "0", required = false) int numPagina,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) int tamPagina) {

		return socioServicio.obtenerSocios(numPagina,tamPagina);
	}

	@GetMapping("/{dni}")
	public ResponseEntity<SocioDto> obtenerSocioDni(@PathVariable(name = "dni") String dni) {

		return ResponseEntity.ok(socioServicio.obtenerSocioDni(dni));
	}

	@PostMapping
	public ResponseEntity<SocioDto> guardarSocio(@RequestBody SocioDto socioDto) {

		return new ResponseEntity<>(socioServicio.crearSocio(socioDto), HttpStatus.CREATED);
	}

	@PutMapping("/{dni}")
	public ResponseEntity<SocioDto> actualizarSocio(@RequestBody SocioDto socioDto,
			@PathVariable(name = "dni") String dni) {

		SocioDto socioRespuesta = socioServicio.actualizarSocio(socioDto, dni);
		return new ResponseEntity<>(socioRespuesta, HttpStatus.OK);
	}

	@DeleteMapping("/{dni}")
	public ResponseEntity<String> eliminarSocio(@PathVariable(name = "dni") String dni) {
		socioServicio.eliminarSocio(dni);

		return new ResponseEntity<>("Socio eliminado con éxito", HttpStatus.OK);
	}
}
