package com.clubnautico.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clubnautico.entidades.Barco;

public interface BarcoRepositorio extends JpaRepository<Barco, String> {

	public List<Barco> findBySocioDni(String dni);

}
