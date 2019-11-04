package com.upn.restaurant.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.upn.restaurant.model.entity.Plato;
import com.upn.restaurant.model.repository.PlatoRepository;
import com.upn.restaurant.service.PlatoService;

public class PlatoServiceImpl implements PlatoService {

	@Autowired
	private PlatoRepository platoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Plato> findAll() throws Exception {
		// TODO Auto-generated method stub
		return platoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Plato> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return platoRepository.findById(id);
	}

	@Override
	@Transactional
	public Plato save(Plato entity) throws Exception {
		// TODO Auto-generated method stub
		return platoRepository.save(entity);
	}

	@Override
	@Transactional
	public Plato update(Plato entity) throws Exception {
		// TODO Auto-generated method stub
		return platoRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		platoRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		platoRepository.deleteAll();
	}

}
