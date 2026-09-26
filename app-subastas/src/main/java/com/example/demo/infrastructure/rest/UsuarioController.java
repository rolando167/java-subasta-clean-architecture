package com.example.demo.infrastructure.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.usecase.CrearUsuarioUseCase;
import com.example.demo.domain.model.Usuario;
import com.example.demo.domain.repository.UsuarioRepository;
import com.example.demo.infrastructure.rest.dto.CrearUsuarioRequestDTO;
import com.example.demo.infrastructure.rest.dto.UsuarioResponseDTO;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	private final CrearUsuarioUseCase crearUsuarioUseCase;
	private final UsuarioRepository usuarioRepository;

	public UsuarioController(CrearUsuarioUseCase crearUsuarioUseCase, UsuarioRepository usuarioRepository) {
		this.crearUsuarioUseCase = crearUsuarioUseCase;
		this.usuarioRepository = usuarioRepository;
	}

	@PostMapping
	public ResponseEntity crearUsuario(@RequestBody CrearUsuarioRequestDTO request) {
		// Mapeamos el DTO de entrada al modelo de dominio
		Usuario usuarioDominio = new Usuario(null, request.getNombre(), request.getEmail(), request.getPassword(),
				request.getSaldo());

		// Ejecutamos el caso de uso
		Usuario creado = crearUsuarioUseCase.ejecutar(usuarioDominio);

		// Mapeamos el resultado al DTO de respuesta
		UsuarioResponseDTO response = new UsuarioResponseDTO(creado.getId(), creado.getNombre(), creado.getEmail(),
				creado.getSaldo());

		return ResponseEntity.ok(response);
	}

	@GetMapping
	public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios() {
		List<UsuarioResponseDTO> responseList = usuarioRepository.findAll().stream()
				.map(u -> new UsuarioResponseDTO(u.getId(), u.getNombre(), u.getEmail(), u.getSaldo()))
				.collect(Collectors.toList());

		return ResponseEntity.ok(responseList);
	}
}