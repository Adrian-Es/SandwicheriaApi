package com.repaso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repaso.model.PedidoModel;
import com.repaso.repository.IPedidoRepository;

@Service
public class PedidoService implements IPedidoService{

	@Autowired
	private IPedidoRepository iPedidoRepository;

	@Override
	public PedidoModel create(PedidoModel pedido) {
		return iPedidoRepository.save(pedido);
	}

	@Override
	public PedidoModel update(PedidoModel pedido) {
		return iPedidoRepository.save(pedido);
	}

	@Override
	public PedidoModel findById(Integer id) {
		Optional<PedidoModel> op = iPedidoRepository.findById(id);
		
		return op.orElse(null);
	}

	@Override
	public List<PedidoModel> findAll() {
		return iPedidoRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		iPedidoRepository.deleteById(id);
	}
	
}
