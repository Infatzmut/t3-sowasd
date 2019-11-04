package com.upn.restaurant.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.upn.restaurant.model.entity.Usuario;
import com.upn.restaurant.model.repository.UsuarioRepository;
import com.upn.restaurant.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id);
	}

	@Override
	@Transactional
	public Usuario save(Usuario entity) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.save(entity);
	}

	@Override
	@Transactional
	public Usuario update(Usuario entity) throws Exception {
		// TODO Auto-generated method stub
		return usuarioRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(id);
	}
	
	@Override
	@Transactional
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		usuarioRepository.deleteAll();
	}
}
