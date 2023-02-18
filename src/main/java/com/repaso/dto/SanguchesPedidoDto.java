package com.repaso.dto;

import java.io.Serializable;
import java.util.Set;

public class SanguchesPedidoDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Set<DetalleSangucheDto> detalles;

	public SanguchesPedidoDto( Set<DetalleSangucheDto> detalles) {
		super();
		this.detalles = detalles;
	}

	public SanguchesPedidoDto() {
		super();
	}

	public Set<DetalleSangucheDto> getDetalles() {
		return detalles;
	}

	public void setDetalles(Set<DetalleSangucheDto> detalles) {
		this.detalles = detalles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
