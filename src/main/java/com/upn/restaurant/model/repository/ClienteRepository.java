package com.upn.restaurant.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upn.restaurant.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
