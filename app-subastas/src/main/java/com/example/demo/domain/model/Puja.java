package com.example.demo.domain.model;

import java.time.LocalDateTime;

public class Puja {
	private Long id;
	private Subasta subasta;
	private Usuario usuario;
	private Double monto;
	private LocalDateTime fechaPuja;

	public Puja() {
	}

	public Puja(Long id, Subasta subasta, Usuario usuario, Double monto, LocalDateTime fechaPuja) {
		this.id = id;
		this.subasta = subasta;
		this.usuario = usuario;
		this.monto = monto;
		this.fechaPuja = fechaPuja;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Subasta getSubasta() {
		return subasta;
	}

	public void setSubasta(Subasta subasta) {
		this.subasta = subasta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public LocalDateTime getFechaPuja() {
		return fechaPuja;
	}

	public void setFechaPuja(LocalDateTime fechaPuja) {
		this.fechaPuja = fechaPuja;
	}

}
