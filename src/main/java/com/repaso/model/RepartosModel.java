package com.repaso.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "repartos")
public class RepartosModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "proveedor_id")
	private ProveedorModel proveedor;

	@OneToMany(mappedBy = "reparto", cascade = CascadeType.ALL)
	private Set<DetalleRepartosModel> detalles;

	@Column(nullable = false)
	private LocalDate fecha;

	@Column(nullable = false)
	private Float costeTotal;

	public RepartosModel(ProveedorModel proveedor, LocalDate fecha, Float costeTotal) {
		super();
		this.proveedor = proveedor;
		this.fecha = fecha;
		this.costeTotal = costeTotal;
	}

	public RepartosModel() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProveedorModel getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorModel proveedor) {
		this.proveedor = proveedor;
	}

	public Set<DetalleRepartosModel> getDetalles() {
		return detalles;
	}

	public void setDetalles(Set<DetalleRepartosModel> detalles) {
		this.detalles = detalles;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Float getCosteTotal() {
		return costeTotal;
	}

	public void setCosteTotal(Float costeTotal) {
		this.costeTotal = costeTotal;
	}

	@Override
	public String toString() {
		return "RepartosModel [id=" + id + ", proveedor=" + proveedor + ", fecha=" + fecha + ", costeTotal="
				+ costeTotal + "]";
	}

}
