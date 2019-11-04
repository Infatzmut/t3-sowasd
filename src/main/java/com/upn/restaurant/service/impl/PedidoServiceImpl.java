package com.upn.restaurant.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.upn.restaurant.model.entity.Pedido;
import com.upn.restaurant.model.repository.PedidoRepository;
import com.upn.restaurant.service.PedidoService;

public class PedidoServiceImpl implements PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Pedido> findAll() throws Exception {
		// TODO Auto-generated method stub
		return pedidoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Pedido> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return pedidoRepository.findById(id);
	}

	@Override
	@Transactional
	public Pedido save(Pedido entity) throws Exception {
		// TODO Auto-generated method stub
		return pedidoRepository.save(entity);
	}

	@Override
	@Transactional
	public Pedido update(Pedido entity) throws Exception {
		// TODO Auto-generated method stub
		return pedidoRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		pedidoRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		pedidoRepository.deleteAll();
	}

}
