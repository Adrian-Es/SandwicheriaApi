package com.repaso.service;

import java.util.List;

import com.repaso.model.DetalleSangucheKey;
import com.repaso.model.DetalleSangucheModel;

public interface IDetalleSangucheService {
	DetalleSangucheModel create(DetalleSangucheModel detalleSanguche);
	
	DetalleSangucheModel update(DetalleSangucheModel detalleSanguche);
	
	DetalleSangucheModel findById(DetalleSangucheKey id);
	
	List<DetalleSangucheModel> FindAll();
}
