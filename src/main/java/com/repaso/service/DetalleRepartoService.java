package com.repaso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repaso.model.DetalleRepartosModel;
import com.repaso.repository.IDetalleRepartoRepository;

@Service
public class DetalleRepartoService implements IDetalleRepartoService{

	@Autowired
	private IDetalleRepartoRepository iDetalleRepartoRepository;
	
	@Override
	public DetalleRepartosModel create(DetalleRepartosModel detalleReparto) {
		// TODO Auto-generated method stub
		return iDetalleRepartoRepository.save(detalleReparto);
	}

	@Override
	public DetalleRepartosModel update(DetalleRepartosModel detalleReparto) {
		// TODO Auto-generated method stub
		return iDetalleRepartoRepository.save(detalleReparto);
	}

	@Override
	public DetalleRepartosModel findById(Integer id) {
		// TODO Auto-generated method stub
		Optional<DetalleRepartosModel> optional = iDetalleRepartoRepository.findById(id);
		return optional.orElse(null);
	}

	@Override
	public List<DetalleRepartosModel> FindAll() {
		// TODO Auto-generated method stub
		return iDetalleRepartoRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		iDetalleRepartoRepository.deleteById(id);
	}


}
