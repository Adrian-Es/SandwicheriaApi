package com.repaso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repaso.model.DetalleSangucheKey;
import com.repaso.model.DetalleSangucheModel;
import com.repaso.repository.IDetalleSangucheRepository;

@Service
public class DetalleSangucheService implements IDetalleSangucheService{
	
	@Autowired
	private IDetalleSangucheRepository drr;

	@Override
	public DetalleSangucheModel create(DetalleSangucheModel detalleSanguche) {
		// TODO Auto-generated method stub
		return drr.save(detalleSanguche);
	}

	@Override
	public DetalleSangucheModel update(DetalleSangucheModel detalleSanguche) {
		// TODO Auto-generated method stub
		return drr.save(detalleSanguche);
	}

	@Override
	public DetalleSangucheModel findById(DetalleSangucheKey id) {
		// TODO Auto-generated method stub
		Optional<DetalleSangucheModel> optional = drr.findById(id);
		return optional.orElse(null);
	}

	@Override
	public List<DetalleSangucheModel> FindAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
