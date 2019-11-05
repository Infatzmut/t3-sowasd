package com.upn.restaurant.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upn.restaurant.model.entity.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
