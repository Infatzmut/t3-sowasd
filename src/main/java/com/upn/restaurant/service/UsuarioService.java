package com.upn.restaurant.service;

import java.util.Optional;

import com.upn.restaurant.model.entity.Usuario;

public interface UsuarioService extends CrudService<Usuario, Long> {
	Optional<Usuario> findByUsername(String username) throws Exception;
}
