package com.upn.restaurant.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upn.restaurant.model.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
