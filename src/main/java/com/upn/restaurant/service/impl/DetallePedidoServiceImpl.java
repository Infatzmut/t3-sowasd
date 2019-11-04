package com.upn.restaurant.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.upn.restaurant.model.entity.DetallePedido;
import com.upn.restaurant.model.repository.DetallePedidoRepository;
import com.upn.restaurant.service.DetallePedidoService;

public class DetallePedidoServiceImpl implements DetallePedidoService {

	@Autowired
	private DetallePedidoRepository detallePedidoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<DetallePedido> findAll() throws Exception {
		// TODO Auto-generated method stub
		return detallePedidoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<DetallePedido> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return detallePedidoRepository.findById(id);
	}

	@Override
	@Transactional
	public DetallePedido save(DetallePedido entity) throws Exception {
		// TODO Auto-generated method stub
		return detallePedidoRepository.save(entity);
	}

	@Override
	@Transactional
	public DetallePedido update(DetallePedido entity) throws Exception {
		// TODO Auto-generated method stub
		return detallePedidoRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		detallePedidoRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		detallePedidoRepository.deleteAll();
	}

}
