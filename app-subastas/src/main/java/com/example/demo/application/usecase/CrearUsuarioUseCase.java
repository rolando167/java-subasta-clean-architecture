package com.example.demo.application.usecase;

import com.example.demo.domain.model.Usuario;
import com.example.demo.domain.repository.UsuarioRepository;

public class CrearUsuarioUseCase {
	private final UsuarioRepository usuarioRepository;

	public CrearUsuarioUseCase(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Usuario ejecutar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
}