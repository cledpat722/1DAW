package com.clubnautico.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "Barco", uniqueConstraints = { @UniqueConstraint(columnNames = { "matricula" }) })
public class Barco {

	@Id
	private String matricula;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "numAmarre", nullable = false)
	private int numAmarre;

	@Column(name = "cuota", nullable = false)
	private float cuota;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dni_socio", nullable = false)
	private Socio socio;
	
	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumAmarre() {
		return numAmarre;
	}

	public void setNumAmarre(int numAmarre) {
		this.numAmarre = numAmarre;
	}

	public float getCuota() {
		return cuota;
	}

	public void setCuota(float cuota) {
		this.cuota = cuota;
	}

	public Barco() {
	}

}
