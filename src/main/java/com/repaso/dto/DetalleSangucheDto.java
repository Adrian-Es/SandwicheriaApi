package com.repaso.dto;

import java.io.Serializable;

public class DetalleSangucheDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idIngrediente;
	private Integer cantidad;
	
	public DetalleSangucheDto(Integer idIngrediente, Integer cantidad) {
		super();
		this.idIngrediente = idIngrediente;
		this.cantidad = cantidad;
	}

	public DetalleSangucheDto() {
		super();
	}

	public Integer getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(Integer idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
