package com.repaso.dto;

import java.io.Serializable;

public class IngredienteDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;
	private Integer cantidadTotal;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantidadTotal(Integer cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public IngredienteDto() {
		super();
	}

	public IngredienteDto(String nombre, Integer cantidadTotal) {
		super();
		this.nombre = nombre;
		this.cantidadTotal = cantidadTotal;
	}

}
