package com.generation.lojagames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.lojagames.model.Categorias;

public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
	public List<Categorias> findAllByTipoContainingIgnoreCase(String Tipo);
	
}
