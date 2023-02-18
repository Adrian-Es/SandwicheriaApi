package com.repaso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repaso.model.ProveedorModel;

@Repository
public interface IProveedorRepository extends JpaRepository<ProveedorModel, Integer>{

}
