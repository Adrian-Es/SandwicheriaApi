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
	private ISanguchesPedidoRepository spr;

	@Override
	public SanguchesPedidoModel create(SanguchesPedidoModel sanguchePedido) {
		// TODO Auto-generated method stub
		return spr.save(sanguchePedido);
	}

	@Override
	public SanguchesPedidoModel update(SanguchesPedidoModel sanguchePedido) {
		// TODO Auto-generated method stub
		return spr.save(sanguchePedido);
	}

	@Override
	public SanguchesPedidoModel findById(Integer id) {
		// TODO Auto-generated method stub
		Optional<SanguchesPedidoModel> optional = spr.findById(id);
		return optional.orElse(null);
	}

	@Override
	public List<SanguchesPedidoModel> FindAll() {
		// TODO Auto-generated method stub
		return spr.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		spr.deleteById(id);
	}
	
	
	
}
