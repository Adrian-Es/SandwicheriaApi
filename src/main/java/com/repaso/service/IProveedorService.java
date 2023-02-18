package com.repaso.service;

import java.util.List;

import com.repaso.model.ProveedorModel;

public interface IProveedorService {
	ProveedorModel create(ProveedorModel proveedor);
	
	ProveedorModel update(ProveedorModel proveedor);
	
	ProveedorModel findByID(Integer id);
	
	List<ProveedorModel> findAll();
	
	void deleteById(Integer id);
}
