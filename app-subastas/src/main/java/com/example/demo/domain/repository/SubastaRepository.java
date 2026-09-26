package com.example.demo.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.model.Subasta;

public interface SubastaRepository {
	Subasta save(Subasta subasta);

	Optional<Subasta> findById(Long id);

	List<Subasta> findByEstado(String estado);

}
