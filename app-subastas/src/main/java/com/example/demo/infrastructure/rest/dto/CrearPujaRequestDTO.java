package com.example.demo.infrastructure.rest.dto;

public class CrearPujaRequestDTO {
	private Long usuarioId;
	private Double monto;

	// Getters y Setters
	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}
}