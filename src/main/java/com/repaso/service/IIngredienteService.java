package com.repaso.service;

import java.util.List;

import com.repaso.model.IngredienteModel;

public interface IIngredienteService {
	IngredienteModel create(IngredienteModel ingrediente);
	
	IngredienteModel update(IngredienteModel ingrediente);
	
	IngredienteModel findById(Integer id);
	
	List<IngredienteModel> findAll();
	
	void deleteById(Integer id);
}
