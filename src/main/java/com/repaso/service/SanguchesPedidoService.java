package com.repaso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repaso.model.SanguchesPedidoModel;
import com.repaso.repository.ISanguchesPedidoRepository;

@Service
public class SanguchesPedidoService implements ISanguchesPedidoService{

	@Autowired
	private ISanguchesPedidoRepository sanguchesPedidoRepository;

	@Override
	public SanguchesPedidoModel create(SanguchesPedidoModel sanguchePedido) {
		return sanguchesPedidoRepository.save(sanguchePedido);
	}

	@Override
	public SanguchesPedidoModel update(SanguchesPedidoModel sanguchePedido) {
		return sanguchesPedidoRepository.save(sanguchePedido);
	}

	@Override
	public SanguchesPedidoModel findById(Integer id) {
		Optional<SanguchesPedidoModel> optional = sanguchesPedidoRepository.findById(id);
		return optional.orElse(null);
	}

	@Override
	public List<SanguchesPedidoModel> FindAll() {
		return sanguchesPedidoRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		sanguchesPedidoRepository.deleteById(id);
	}
	
	
	
}
