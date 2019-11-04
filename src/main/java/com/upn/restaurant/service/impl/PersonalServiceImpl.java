package com.upn.restaurant.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.upn.restaurant.model.entity.Personal;
import com.upn.restaurant.model.repository.PersonalRepository;
import com.upn.restaurant.service.PersonalService;

public class PersonalServiceImpl implements PersonalService {

	@Autowired
	private PersonalRepository personalRepository;
	@Override
	@Transactional(readOnly = true)
	public List<Personal> findAll() throws Exception {
		// TODO Auto-generated method stub
		return personalRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Personal> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return personalRepository.findById(id);
	}

	@Override
	@Transactional
	public Personal save(Personal entity) throws Exception {
		// TODO Auto-generated method stub
		return personalRepository.save(entity);
	}

	@Override
	@Transactional
	public Personal update(Personal entity) throws Exception {
		// TODO Auto-generated method stub
		return personalRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		personalRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		personalRepository.deleteAll();
	}

}
