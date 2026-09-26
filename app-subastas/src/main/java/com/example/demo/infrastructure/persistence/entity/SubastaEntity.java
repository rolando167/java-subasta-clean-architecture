package com.example.demo.infrastructure.persistence.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "subastas")
public class SubastaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "articulo_id", nullable = false)
	private ArticuloEntity articulo;

	@Column(nullable = false)
	private Double precioInicial;

	@Column(nullable = false)
	private LocalDateTime fechaInicio;

	@Column(nullable = false)
	private LocalDateTime fechaFin;

	@Column(nullable = false)
	private String estado; // ACTIVA, FINALIZADA

	public SubastaEntity() {
	}

	public SubastaEntity(Long id, ArticuloEntity articulo, Double precioInicial, LocalDateTime fechaInicio,
			LocalDateTime fechaFin, String estado) {
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

	public ArticuloEntity getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticuloEntity articulo) {
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
