package com.example.demo.infrastructure.rest.dto;

public class UsuarioResponseDTO {
	private final Long id;
	private final String nombre;
	private final String email;
	private final Double saldo;

	public UsuarioResponseDTO(Long id, String nombre, String email, Double saldo) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.saldo = saldo;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	public Double getSaldo() {
		return saldo;
	}
}