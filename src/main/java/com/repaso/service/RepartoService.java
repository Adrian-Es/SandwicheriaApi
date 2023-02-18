package com.repaso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repaso.model.RepartosModel;
import com.repaso.repository.IRepartoRepository;

@Service
public class RepartoService implements IRepartoService{
	
	@Autowired
	private IRepartoRepository irr;

	@Override
	public RepartosModel create(RepartosModel reparto) {
		return irr.save(reparto);
	}
	@Override
	public RepartosModel findById(Integer id) {
		Optional<RepartosModel> op = irr.findById(id);
		
		return op.orElse(null);
	}

	@Override
	public List<RepartosModel> FindAll() {
		return irr.findAll();
	}

	@Override
	public List<RepartosModel> repartosPorProveedor(Integer proveedor_id) {
		return irr.repartosPorProveedor(proveedor_id);
	}

	@Override
	public void deleteById(Integer id) {
		irr.deleteById(id);
	}
	
}
