package com.udemy.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.models.Categoria;
import com.udemy.services.CategoriaServices;
import com.udemy.services.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	@Autowired
	private CategoriaServices catService;
	
	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException{
			
		Categoria c1 = catService.buscar(id);			
		return ResponseEntity.ok(c1);
	}

}
