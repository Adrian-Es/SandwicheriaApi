package com.repaso.service;

import java.util.List;

import com.repaso.model.PedidoModel;

public interface IPedidoService {
	PedidoModel create(PedidoModel pedido);
	
	PedidoModel update(PedidoModel pedido);
	
	PedidoModel findById(Integer id);
	
	List<PedidoModel> findAll();
	
	void deleteById(Integer id);
}
