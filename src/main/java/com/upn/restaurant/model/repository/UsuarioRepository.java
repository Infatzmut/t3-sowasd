package com.upn.restaurant.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.upn.restaurant.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByUsername(String username);

}
