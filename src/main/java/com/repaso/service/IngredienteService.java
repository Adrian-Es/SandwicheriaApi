package com.repaso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repaso.model.IngredienteModel;
import com.repaso.repository.IIngredienteRepository;

@Service
public class IngredienteService implements IIngredienteService{
	
	@Autowired
	private IIngredienteRepository iir;
	
	@Override
	public IngredienteModel create(IngredienteModel ingrediente) {
		return iir.save(ingrediente);
	}

	@Override
	public IngredienteModel update(IngredienteModel ingrediente) {
		return iir.save(ingrediente);
	}

	@Override
	public IngredienteModel findById(Integer id) {
		Optional<IngredienteModel> optional =iir.findById(id);
		
		return optional.orElse(null);
	}

	@Override
	public List<IngredienteModel> findAll() {
		return iir.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		iir.deleteById(id);
	}

}
