package com.repaso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repaso.model.IngredienteModel;

@Repository
public interface IIngredienteRepository extends JpaRepository<IngredienteModel, Integer>{

}
