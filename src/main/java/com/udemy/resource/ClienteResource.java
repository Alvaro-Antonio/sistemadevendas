package com.udemy.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.models.Cliente;
import com.udemy.services.ClienteService;
import com.udemy.services.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {
	@Autowired
	private ClienteService cliService;
	
	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException{
			
		Cliente c1 = cliService.buscar(id);			
		return ResponseEntity.ok(c1);
	}

}