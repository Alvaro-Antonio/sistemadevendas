package com.udemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.models.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
