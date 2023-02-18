package com.repaso.dto;

import java.io.Serializable;
import java.util.Set;

public class RepartosCompletosDto implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id_proveedor;
	private String fecha;
	private Set<DetalleRepartosBasicoDto> detalles;
	
	public RepartosCompletosDto(Integer id_proveedor, String fecha, Set<DetalleRepartosBasicoDto> detalles) {
		super();
		this.id_proveedor = id_proveedor;
		this.fecha = fecha;
		this.detalles = detalles;
	}
	
	public RepartosCompletosDto() {
	}

	public Integer getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(Integer id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Set<DetalleRepartosBasicoDto> getDetalles() {
		return detalles;
	}

	public void setDetalles(Set<DetalleRepartosBasicoDto> detalles) {
		this.detalles = detalles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
