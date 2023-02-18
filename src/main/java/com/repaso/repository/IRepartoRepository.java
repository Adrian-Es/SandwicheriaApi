package com.repaso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.repaso.model.RepartosModel;

@Repository
public interface IRepartoRepository extends JpaRepository<RepartosModel, Integer>{

	
	@Query(nativeQuery = true,
			value = "SELECT * FROM repartos r WHERE r.proveedor_id = :proveedor_id")
	List<RepartosModel> repartosPorProveedor(@Param("proveedor_id") Integer id);
}
