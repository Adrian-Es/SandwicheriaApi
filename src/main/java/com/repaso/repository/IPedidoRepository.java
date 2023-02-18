package com.repaso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repaso.model.PedidoModel;

@Repository
public interface IPedidoRepository extends JpaRepository<PedidoModel, Integer>{

}
