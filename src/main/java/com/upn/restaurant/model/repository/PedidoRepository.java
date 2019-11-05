package com.upn.restaurant.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upn.restaurant.model.entity.Pedido;
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
