package com.repaso.service;

import java.util.List;

import com.repaso.model.DetalleRepartosModel;

public interface IDetalleRepartoService {
	DetalleRepartosModel create(DetalleRepartosModel detalleReparto);
	
	DetalleRepartosModel update(DetalleRepartosModel detalleReparto);
	
	DetalleRepartosModel findById(Integer id);
	
	List<DetalleRepartosModel> FindAll();
	
	void deleteById(Integer id);
}
