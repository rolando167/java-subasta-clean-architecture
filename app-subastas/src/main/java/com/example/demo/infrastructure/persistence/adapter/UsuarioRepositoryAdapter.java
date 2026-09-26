package com.example.demo.infrastructure.persistence.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.model.Usuario;
import com.example.demo.domain.repository.UsuarioRepository;
import com.example.demo.infrastructure.persistence.entity.UsuarioEntity;
import com.example.demo.infrastructure.persistence.repository.SpringUsuarioRepository;

@Repository
public class UsuarioRepositoryAdapter implements UsuarioRepository {

	private final SpringUsuarioRepository springUsuarioRepository;

	public UsuarioRepositoryAdapter(SpringUsuarioRepository springUsuarioRepository) {
		this.springUsuarioRepository = springUsuarioRepository;
	}

	@Override
	public Usuario save(Usuario usuario) {
		UsuarioEntity entity = new UsuarioEntity(usuario.getId(), usuario.getNombre(), usuario.getEmail(),
				usuario.getPassword(), usuario.getSaldo());
		UsuarioEntity saved = springUsuarioRepository.save(entity);
		return new Usuario(saved.getId(), saved.getNombre(), saved.getEmail(), saved.getPassword(), saved.getSaldo());
	}

	@Override
	public Optional findById(Long id) {
		return springUsuarioRepository.findById(id)
				.map(e -> new Usuario(e.getId(), e.getNombre(), e.getEmail(), e.getPassword(), e.getSaldo()));
	}

	@Override
	public Optional findByEmail(String email) {
		return springUsuarioRepository.findByEmail(email)
				.map(e -> new Usuario(e.getId(), e.getNombre(), e.getEmail(), e.getPassword(), e.getSaldo()));
	}

	@Override
	public List<Usuario> findAll() {
		return springUsuarioRepository.findAll().stream().map(entity -> new Usuario(entity.getId(), entity.getNombre(),
				entity.getEmail(), entity.getPassword(), entity.getSaldo())).collect(Collectors.toList());
	}
}