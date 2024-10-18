package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.repository.Taller_CuatroRespository;

@Service
public class Taller_CuatroService {
	
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	//This function is of Taller_cuatro 
	public boolean checkPassword(String p_usuario, String p_contrasena) {
	    try {
	        String sql = "SELECT validar_usuario_contraseña(?, ?) FROM dual";
	        int resultado = jdbcTemplate.queryForObject(sql, Integer.class, p_usuario, p_contrasena);
	        return resultado == 1; 
	    } catch (DataAccessException e) {
	        System.out.print("Error al ejecutar el procedimiento: " + e.getMessage());
	    } catch (Exception e) {
	        System.out.println("Ocurrió un error inesperado: " + e.getMessage());
	    }
	    return false; 
	}
}
