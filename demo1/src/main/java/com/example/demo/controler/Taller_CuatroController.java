package com.example.demo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Taller_Cuatro;
import com.example.demo.services.Taller_CuatroService;


public class Taller_CuatroController {

	
	@Autowired
	private Taller_CuatroService service;
	
	
	@PostMapping("TC/checkPassword")
	public ResponseEntity<Boolean> checkPassword(@RequestBody Taller_Cuatro TM) {
	    String contr = TM.getContrasena();
	    String user = TM.getUsuario();
	    boolean isValid = service.checkPassword(user, contr);
	    return new ResponseEntity<>(isValid, HttpStatus.OK);
	}


	
	
}
