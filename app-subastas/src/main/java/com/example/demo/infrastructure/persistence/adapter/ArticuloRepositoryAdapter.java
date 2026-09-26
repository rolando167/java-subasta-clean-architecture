package com.example.demo.infrastructure.persistence.adapter;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.model.Articulo;
import com.example.demo.domain.model.Usuario;
import com.example.demo.domain.repository.ArticuloRepository;
import com.example.demo.infrastructure.persistence.entity.ArticuloEntity;
import com.example.demo.infrastructure.persistence.entity.UsuarioEntity;
import com.example.demo.infrastructure.persistence.repository.SpringArticuloRepository;

@Repository
public class ArticuloRepositoryAdapter implements ArticuloRepository {

	private final SpringArticuloRepository springArticuloRepository;

	public ArticuloRepositoryAdapter(SpringArticuloRepository springArticuloRepository) {
		this.springArticuloRepository = springArticuloRepository;
	}

	@Override
	public Articulo save(Articulo articulo) {

		ArticuloEntity entity = new ArticuloEntity();
		entity.setId(articulo.getId());
		entity.setTitulo(articulo.getTitulo());
		entity.setDescripcion(articulo.getDescripcion());

		Usuario vendedor = articulo.getVendedor();

		UsuarioEntity vendedorEntity = new UsuarioEntity(vendedor.getId(), vendedor.getNombre(), vendedor.getEmail(),
				vendedor.getPassword(), vendedor.getSaldo());

		entity.setVendedor(vendedorEntity);

		ArticuloEntity saved = springArticuloRepository.save(entity);

		UsuarioEntity savedVendedor = saved.getVendedor();

		Usuario usuario = new Usuario(savedVendedor.getId(), savedVendedor.getNombre(), savedVendedor.getEmail(),
				savedVendedor.getPassword(), savedVendedor.getSaldo());

		return new Articulo(saved.getId(), saved.getTitulo(), saved.getDescripcion(), usuario);
	}

	@Override
	public Optional<Articulo> findById(Long id) {

		return springArticuloRepository.findById(id).map(e -> {

			UsuarioEntity vendedor = e.getVendedor();

			Usuario usuario = new Usuario(vendedor.getId(), vendedor.getNombre(), vendedor.getEmail(),
					vendedor.getPassword(), vendedor.getSaldo());

			return new Articulo(e.getId(), e.getTitulo(), e.getDescripcion(), usuario);
		});
	}
}