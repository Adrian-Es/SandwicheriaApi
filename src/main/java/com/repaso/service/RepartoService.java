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
	private IRepartoRepository iRepartoRepository;

	@Override
	public RepartosModel create(RepartosModel reparto) {
		return iRepartoRepository.save(reparto);
	}
	@Override
	public RepartosModel findById(Integer id) {
		Optional<RepartosModel> op = iRepartoRepository.findById(id);
		
		return op.orElse(null);
	}

	@Override
	public List<RepartosModel> FindAll() {
		return iRepartoRepository.findAll();
	}

	@Override
	public List<RepartosModel> repartosPorProveedor(Integer proveedor_id) {
		return iRepartoRepository.repartosPorProveedor(proveedor_id);
	}

	@Override
	public void deleteById(Integer id) {
		iRepartoRepository.deleteById(id);
	}
	
}
