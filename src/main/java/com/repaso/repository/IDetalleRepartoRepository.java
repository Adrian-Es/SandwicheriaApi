package com.repaso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.repaso.model.DetalleRepartosModel;

public interface IDetalleRepartoRepository extends JpaRepository<DetalleRepartosModel, Integer> {

}
