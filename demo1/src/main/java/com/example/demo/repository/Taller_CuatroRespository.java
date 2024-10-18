package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Taller_Cuatro;

@Repository
public interface Taller_CuatroRespository extends JpaRepository <Taller_Cuatro,Long>{

}