package com.example.demo.domain.repository;

import java.util.Optional;

import com.example.demo.domain.model.Articulo;

public interface ArticuloRepository {
	Articulo save(Articulo articulo);

	Optional findById(Long id);
}
