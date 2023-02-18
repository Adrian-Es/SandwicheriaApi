package com.repaso.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DetalleSangucheKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "id_sanguche_pedido")
	private Integer idSanguchePedido;

	@Column(name = "id_ingrediente")
	private Integer idIngrediente;

	public DetalleSangucheKey(Integer idSanguchePedido, Integer idIngrediente) {
		super();
		this.idSanguchePedido = idSanguchePedido;
		this.idIngrediente = idIngrediente;
	}

	public DetalleSangucheKey() {
		super();
	}

	public Integer getIdSanguchePedido() {
		return idSanguchePedido;
	}

	public void setIdSanguchePedido(Integer idSanguchePedido) {
		this.idSanguchePedido = idSanguchePedido;
	}

	public Integer getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(Integer idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DetalleSangucheKey [idSanguchePedido=" + idSanguchePedido + ", idIngrediente=" + idIngrediente + "]";
	}

}
