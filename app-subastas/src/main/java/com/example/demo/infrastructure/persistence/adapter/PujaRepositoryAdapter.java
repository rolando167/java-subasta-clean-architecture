package com.example.demo.infrastructure.persistence.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.model.Puja;
import com.example.demo.domain.repository.PujaRepository;
import com.example.demo.infrastructure.persistence.entity.PujaEntity;
import com.example.demo.infrastructure.persistence.repository.SpringPujaRepository;

@Repository
public class PujaRepositoryAdapter implements PujaRepository {

	private final SpringPujaRepository springPujaRepository;

	public PujaRepositoryAdapter(SpringPujaRepository springPujaRepository) {
		this.springPujaRepository = springPujaRepository;
	}

	@Override
	public Puja save(Puja puja) {
		PujaEntity entity = new PujaEntity();
		entity.setId(puja.getId());
		entity.setMonto(puja.getMonto());
		entity.setFechaPuja(puja.getFechaPuja());

		// Mapeo manual de Subasta y Usuario (según cómo tengas tus entidades)
		// entity.setSubasta(...);
		// entity.setUsuario(...);

		PujaEntity saved = springPujaRepository.save(entity);

		return toDomain(saved);
	}

	@Override
	public Optional<Puja> findById(Long id) {
		return springPujaRepository.findById(id).map(this::toDomain);
	}

	@Override
	public List findBySubastaId(Long subastaId) {
		return springPujaRepository.findBySubastaId(subastaId).stream().map(this::toDomain)
				.collect(Collectors.toList());
	}

	// Método auxiliar privado para evitar repetir código de mapeo
	private Puja toDomain(PujaEntity entity) {
		Puja puja = new Puja();
		puja.setId(entity.getId());
		puja.setMonto(entity.getMonto());
		puja.setFechaPuja(entity.getFechaPuja());

		// Si mapeas los objetos relacionados en el dominio:
		// puja.setSubasta(...);
		// puja.setUsuario(...);

		return puja;
	}

	@Override
	public Optional<Puja> findTopBySubastaIdOrderByMontoDesc(Long subastaId) {
		return springPujaRepository.findTopBySubastaIdOrderByMontoDesc(subastaId).map(this::toDomain);
	}
}