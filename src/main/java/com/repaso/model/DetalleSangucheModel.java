package com.repaso.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_sanguche")
public class DetalleSangucheModel {
	@EmbeddedId
	DetalleSangucheKey id;

	@ManyToOne(optional = false)
	@MapsId("idSanguchePedido")
	@JoinColumn(name = "id_sanguche_pedido")
	private SanguchesPedidoModel sanguchePedido;

	@ManyToOne(optional = false)
	@MapsId("idIngrediente")
	@JoinColumn(name = "id_ingrediente")
	private IngredienteModel ingrediente;

	@Column(nullable = false)
	private Integer cantidad;

	public DetalleSangucheModel(SanguchesPedidoModel sanguchePedido, IngredienteModel ingrediente, Integer cantidad) {
		super();
		this.sanguchePedido = sanguchePedido;
		this.ingrediente = ingrediente;
		this.cantidad = cantidad;
		setId(new DetalleSangucheKey(sanguchePedido.getId(), ingrediente.getId()));
	}

	public DetalleSangucheModel() {
		super();
	}

	public DetalleSangucheKey getId() {
		return id;
	}

	public void setId(DetalleSangucheKey id) {
		this.id = id;
	}

	public SanguchesPedidoModel getSanguchePedido() {
		return sanguchePedido;
	}

	public void setSanguchePedido(SanguchesPedidoModel sanguchePedido) {
		this.sanguchePedido = sanguchePedido;
	}

	public IngredienteModel getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(IngredienteModel ingrediente) {
		this.ingrediente = ingrediente;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "DetalleSangucheModel [id=" + id + ", sanguchePedido=" + sanguchePedido + ", ingrediente=" + ingrediente
				+ ", cantidad=" + cantidad + "]";
	}

}
