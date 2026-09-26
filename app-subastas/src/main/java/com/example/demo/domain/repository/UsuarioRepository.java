package com.example.demo.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.model.Usuario;

public interface UsuarioRepository {
	Usuario save(Usuario usuario);

	List<Usuario> findAll(); // <--- Añade esto aquí

	Optional<Usuario> findById(Long id);

	Optional<Usuario> findByEmail(String email);
}
