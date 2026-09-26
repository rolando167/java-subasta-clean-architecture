package com.example.demo.domain.model;

import java.time.LocalDateTime;

public class Subasta {
	private Long id;
	private Articulo articulo;
	private Double precioInicial;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private String estado;

	public Subasta() {
	}

	public Subasta(Long id, Articulo articulo, Double precioInicial, LocalDateTime fechaInicio, LocalDateTime fechaFin,
			String estado) {
		this.id = id;
		this.articulo = articulo;
		this.precioInicial = precioInicial;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Double getPrecioInicial() {
		return precioInicial;
	}

	public void setPrecioInicial(Double precioInicial) {
		this.precioInicial = precioInicial;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
