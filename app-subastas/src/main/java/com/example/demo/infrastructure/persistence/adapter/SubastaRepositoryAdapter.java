package com.example.demo.infrastructure.persistence.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.model.Subasta;
import com.example.demo.domain.repository.SubastaRepository;
import com.example.demo.infrastructure.persistence.entity.SubastaEntity;
import com.example.demo.infrastructure.persistence.repository.SpringSubastaRepository;

@Repository
public class SubastaRepositoryAdapter implements SubastaRepository {

	private final SpringSubastaRepository springSubastaRepository;

	public SubastaRepositoryAdapter(SpringSubastaRepository springSubastaRepository) {
		this.springSubastaRepository = springSubastaRepository;
	}

	@Override
	public Subasta save(Subasta subasta) {
		SubastaEntity entity = new SubastaEntity();
		entity.setId(subasta.getId());
		entity.setPrecioInicial(subasta.getPrecioInicial());
		entity.setFechaInicio(subasta.getFechaInicio());
		entity.setFechaFin(subasta.getFechaFin());
		entity.setEstado(subasta.getEstado());

		// Mapeo de relaciones si aplica (por ejemplo, Articulo)

		SubastaEntity saved = springSubastaRepository.save(entity);
		return toDomain(saved);
	}

	@Override
	public Optional findById(Long id) {
		return springSubastaRepository.findById(id).map(this::toDomain);
	}

	@Override
	public List<Subasta> findByEstado(String estado) {
		return springSubastaRepository.findByEstado(estado).stream().map(this::toDomain).collect(Collectors.toList());
	}

	private Subasta toDomain(SubastaEntity entity) {
		Subasta subasta = new Subasta();
		subasta.setId(entity.getId());
		subasta.setPrecioInicial(entity.getPrecioInicial());
		subasta.setFechaInicio(entity.getFechaInicio());
		subasta.setFechaFin(entity.getFechaFin());
		subasta.setEstado(entity.getEstado());

		// Mapeo inverso de relaciones si aplica

		return subasta;
	}
}