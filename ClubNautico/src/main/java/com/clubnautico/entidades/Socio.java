package com.clubnautico.entidades;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "socio", uniqueConstraints = { @UniqueConstraint(columnNames = { "dni" }) })
public class Socio {

	@Id
	private String dni;
	
	private String nombre;
	private String apellido;
	private String telefono;
	
	@OneToMany(mappedBy = "socio")	
	private Set<Barco> barcos = new HashSet<>();
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Set<Barco> getBarcos() {
		return barcos;
	}

	public void setBarcos(Set<Barco> barcos) {
		this.barcos = barcos;
	}

	public Socio() {
	}

}
