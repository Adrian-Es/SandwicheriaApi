package com.repaso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_reparto")
public class DetalleRepartosModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private RepartosModel reparto;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private IngredienteModel ingrediente;

	@Column(nullable = false)
	private Integer cantidad;

	@Column(nullable = false)
	private Float coste;

	public DetalleRepartosModel(RepartosModel reparto, IngredienteModel ingrediente, Integer cantidad, Float coste) {
		super();
		this.reparto = reparto;
		this.ingrediente = ingrediente;
		this.cantidad = cantidad;
		this.coste = coste;
	}

	public DetalleRepartosModel() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RepartosModel getReparto() {
		return reparto;
	}

	public void setReparto(RepartosModel reparto) {
		this.reparto = reparto;
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

	public Float getCoste() {
		return coste;
	}

	public void setCoste(Float coste) {
		this.coste = coste;
	}

	@Override
	public String toString() {
		return "DetalleRepartosModel [id=" + id + ", reparto=" + reparto + ", ingrediente=" + ingrediente
				+ ", cantidad=" + cantidad + ", coste=" + coste + "]";
	}

}
