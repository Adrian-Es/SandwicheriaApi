package com.repaso.service;

import java.util.List;

import com.repaso.model.SanguchesPedidoModel;

public interface ISanguchesPedidoService {
	SanguchesPedidoModel create(SanguchesPedidoModel sanguchePedido);
	
	SanguchesPedidoModel update(SanguchesPedidoModel sanguchePedido);
	
	SanguchesPedidoModel findById(Integer id);
	
	List<SanguchesPedidoModel> FindAll();
	
	void deleteById(Integer id);
}
