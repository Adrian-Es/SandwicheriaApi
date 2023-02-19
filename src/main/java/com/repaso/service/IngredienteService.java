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
	private IIngredienteRepository ingredienteRepository;
	
	@Override
	public IngredienteModel create(IngredienteModel ingrediente) {
		return ingredienteRepository.save(ingrediente);
	}

	@Override
	public IngredienteModel update(IngredienteModel ingrediente) {
		return ingredienteRepository.save(ingrediente);
	}

	@Override
	public IngredienteModel findById(Integer id) {
		Optional<IngredienteModel> optional =ingredienteRepository.findById(id);
		
		return optional.orElse(null);
	}

	@Override
	public List<IngredienteModel> findAll() {
		return ingredienteRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		ingredienteRepository.deleteById(id);
	}

}
