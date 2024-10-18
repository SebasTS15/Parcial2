package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Taller_Cuatro")
public class Taller_Cuatro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id_Taller_Cuatro;
	
	@Column(name = "Usuario")
	private String Usuario;
	@Column(name = "Contrasena")
	private String Contrasena;
	
	

	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getContrasena() {
		return Contrasena;
	}
	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}
	
}
