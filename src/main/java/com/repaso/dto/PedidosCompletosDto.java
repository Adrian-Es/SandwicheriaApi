package com.repaso.dto;

import java.io.Serializable;
import java.util.Set;

public class PedidosCompletosDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String direccionEntrega;
	private String fecha;
	private Set<SanguchesPedidoDto> sanguches;

	public PedidosCompletosDto(String direccionEntrega, String fecha,
			Set<SanguchesPedidoDto> sanguches) {
		super();
		this.direccionEntrega = direccionEntrega;
		this.fecha = fecha;
		this.sanguches = sanguches;
	}

	public PedidosCompletosDto() {
		super();
	}

	public String getDireccionEntrega() {
		return direccionEntrega;
	}

	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Set<SanguchesPedidoDto> getSanguches() {
		return sanguches;
	}

	public void setSanguches(Set<SanguchesPedidoDto> sanguches) {
		this.sanguches = sanguches;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
