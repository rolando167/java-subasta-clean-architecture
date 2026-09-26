package com.example.demo.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.model.Puja;

public interface PujaRepository {
	Puja save(Puja puja);

	Optional<Puja> findById(Long id);

	List<Puja> findBySubastaId(Long subastaId);

	Optional<Puja> findTopBySubastaIdOrderByMontoDesc(Long subastaId);
}