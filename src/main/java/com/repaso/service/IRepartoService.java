package com.repaso.service;

import java.util.List;

import com.repaso.model.RepartosModel;

public interface IRepartoService {
	RepartosModel create(RepartosModel reparto);
	
	RepartosModel findById(Integer id);
	
	List<RepartosModel> FindAll();
	
	List<RepartosModel> repartosPorProveedor(Integer proveedor_id);
	
	void deleteById(Integer id);
}
