package com.example.demo.domain.model;

public class Usuario {
	private Long id;
	private String nombre;
	private String email;
	private String password;
	private Double saldo;

	public Usuario() {
	}

	public Usuario(Long id, String nombre, String email, String password, Double saldo) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.saldo = saldo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}