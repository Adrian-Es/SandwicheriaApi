package com.repaso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.repaso.model.DetalleSangucheKey;
import com.repaso.model.DetalleSangucheModel;

public interface IDetalleSangucheRepository extends JpaRepository<DetalleSangucheModel, DetalleSangucheKey>{

}
