package com.udemy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.models.Categoria;
import com.udemy.repositories.CategoriaRepository;
import com.udemy.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaServices {
	@Autowired
	CategoriaRepository categoriaRepo;
	
	public Categoria buscar(Integer id) throws ObjectNotFoundException {
		Optional<Categoria> obj = categoriaRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
}
