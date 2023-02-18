package com.repaso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repaso.model.ProveedorModel;
import com.repaso.repository.IProveedorRepository;

@Service
public class ProveedorService implements IProveedorService{
	
	@Autowired
	private IProveedorRepository ipr;
	
	@Override
	public ProveedorModel create(ProveedorModel proveedor) {
		return ipr.save(proveedor);
	}

	@Override
	public ProveedorModel update(ProveedorModel proveedor) {
		return ipr.save(proveedor);
	}

	@Override
	public ProveedorModel findByID(Integer id) {
		Optional<ProveedorModel> op = ipr.findById(id);
		return op.orElse(null);
	}

	@Override
	public List<ProveedorModel> findAll() {
		return ipr.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		ipr.deleteById(id);
	}

}
