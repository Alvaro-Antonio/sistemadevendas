package com.udemy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.models.Categoria;
import com.udemy.repositories.CategoriaRepository;

@Service
public class CategoriaServices {
	@Autowired
	CategoriaRepository categoriaRepo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = categoriaRepo.findById(id);
		return obj.orElse(null);
	}
}
