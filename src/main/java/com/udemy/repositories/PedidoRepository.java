package com.udemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
