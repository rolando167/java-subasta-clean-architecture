package com.example.demo.domain.model;

public class Articulo {
	private Long id;
	private String titulo;
	private String descripcion;
	private Usuario vendedor;

	public Articulo() {
	}

	public Articulo(Long id, String titulo, String descripcion, Usuario vendedor) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.vendedor = vendedor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Usuario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}

}