package com.upn.restaurant.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upn.restaurant.model.entity.DetallePedido;
@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer>{

}
