package com.upn.restaurant.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upn.restaurant.model.entity.Plato;
@Repository
public interface PlatoRepository extends JpaRepository<Plato, Integer>{

}
