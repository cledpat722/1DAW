package com.clubnautico.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clubnautico.entidades.Socio;

public interface SocioRepositorio extends JpaRepository<Socio, String>{
	
}
