package com.example.demo.infrastructure.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.usecase.RegistrarPujaUseCase;
import com.example.demo.domain.model.Puja;
import com.example.demo.infrastructure.rest.dto.CrearPujaRequestDTO;

@RestController
@RequestMapping("/api/subastas")
public class PujaController {

	private final RegistrarPujaUseCase registrarPujaUseCase;

	public PujaController(RegistrarPujaUseCase registrarPujaUseCase) {
		this.registrarPujaUseCase = registrarPujaUseCase;
	}

	@PostMapping("/{subastaId}/pujas")
	public ResponseEntity registrarPuja(@PathVariable Long subastaId, @RequestBody CrearPujaRequestDTO request) {

		Puja nuevaPuja = registrarPujaUseCase.ejecutar(subastaId, request.getUsuarioId(), request.getMonto());

		return ResponseEntity.ok(nuevaPuja);
	}
}