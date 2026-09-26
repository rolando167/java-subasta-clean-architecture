package com.example.demo.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.application.usecase.CrearUsuarioUseCase;
import com.example.demo.application.usecase.RegistrarPujaUseCase;
import com.example.demo.domain.repository.PujaRepository;
import com.example.demo.domain.repository.SubastaRepository;
import com.example.demo.domain.repository.UsuarioRepository;

@Configuration
public class UseCaseConfig {

	@Bean
	public RegistrarPujaUseCase registrarPujaUseCase(SubastaRepository subastaRepository,
			PujaRepository pujaRepository) {
		return new RegistrarPujaUseCase(subastaRepository, pujaRepository);
	}

	@Bean
	public CrearUsuarioUseCase crearUsuarioUseCase(UsuarioRepository usuarioRepository) {
		return new CrearUsuarioUseCase(usuarioRepository);
	}
}