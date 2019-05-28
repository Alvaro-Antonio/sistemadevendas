package com.udemy.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.models.Pedido;
import com.udemy.services.PedidoService;
import com.udemy.services.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoResourse {
	@Autowired
	private PedidoService cliService;
	
	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException{
			
		Pedido c1 = cliService.buscar(id);			
		return ResponseEntity.ok(c1);
	}

}
