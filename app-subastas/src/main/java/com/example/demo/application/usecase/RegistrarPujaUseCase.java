package com.example.demo.application.usecase;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.model.Puja;
import com.example.demo.domain.model.Subasta;
import com.example.demo.domain.repository.PujaRepository;
import com.example.demo.domain.repository.SubastaRepository;

public class RegistrarPujaUseCase {
	private final SubastaRepository subastaRepository;
	private final PujaRepository pujaRepository;

	public RegistrarPujaUseCase(SubastaRepository subastaRepository, PujaRepository pujaRepository) {
		this.subastaRepository = subastaRepository;
		this.pujaRepository = pujaRepository;
	}

	@Transactional
	public Puja ejecutar(Long subastaId, Long usuarioId, Double monto) {
		// 1. Buscar la subasta y validar que exista
		Subasta subasta = subastaRepository.findById(subastaId)
				.orElseThrow(() -> new RuntimeException("La subasta no existe"));

		// 2. Validar que la subasta esté activa
		if (!"ACTIVA".equals(subasta.getEstado())) {
			throw new RuntimeException("La subasta no está activa");
		}

		// 3. Obtener la puja más alta actual para esta subasta
		Optional<Puja> pujaMaximaOpt = pujaRepository.findTopBySubastaIdOrderByMontoDesc(subastaId);

		if (pujaMaximaOpt.isPresent()) {
			Double montoMaximoActual = pujaMaximaOpt.get().getMonto();
			if (monto <= montoMaximoActual) {
				throw new RuntimeException("El monto debe ser mayor a la puja actual: " + montoMaximoActual);
			}
		} else {
			if (monto <= subasta.getPrecioInicial()) {
				throw new RuntimeException("El monto debe ser mayor al precio inicial");
			}
		}

		// 4. Crear y guardar la puja
		Puja nuevaPuja = new Puja();
		nuevaPuja.setSubasta(subasta);
		// nuevaPuja.setUsuario(usuario);
		nuevaPuja.setMonto(monto);
		nuevaPuja.setFechaPuja(LocalDateTime.now());

		return pujaRepository.save(nuevaPuja);
	}
}
