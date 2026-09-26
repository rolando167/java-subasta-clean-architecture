package com.example.demo.infrastructure.persistence.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pujas")
public class PujaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subasta_id", nullable = false)
	private SubastaEntity subasta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id", nullable = false)
	private UsuarioEntity usuario;

	@Column(nullable = false)
	private Double monto;

	@Column(nullable = false)
	private LocalDateTime fechaPuja;

	public PujaEntity() {
	}

	public PujaEntity(Long id, SubastaEntity subasta, UsuarioEntity usuario, Double monto, LocalDateTime fechaPuja) {
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

	public SubastaEntity getSubasta() {
		return subasta;
	}

	public void setSubasta(SubastaEntity subasta) {
		this.subasta = subasta;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
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