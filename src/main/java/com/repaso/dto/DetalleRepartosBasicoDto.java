package com.repaso.dto;

import java.io.Serializable;

public class DetalleRepartosBasicoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id_ingrediente;
	private Integer cantidad;
	private Float coste;
	
	public DetalleRepartosBasicoDto(Integer id_ingrediente, Integer cantidad, Float coste) {
		super();
		this.id_ingrediente = id_ingrediente;
		this.cantidad = cantidad;
		this.coste = coste;
	}

	public Integer getId_ingrediente() {
		return id_ingrediente;
	}

	public void setId_ingrediente(Integer id_ingrediente) {
		this.id_ingrediente = id_ingrediente;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Float getCoste() {
		return coste;
	}

	public void setCoste(Float coste) {
		this.coste = coste;
	}
	
	
	
}
