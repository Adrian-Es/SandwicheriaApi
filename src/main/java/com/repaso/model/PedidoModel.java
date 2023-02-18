package com.repaso.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class PedidoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Set<SanguchesPedidoModel> sanguches;

	@Column(length = 75, nullable = false)
	private String direccionEntrega;

	@Column(nullable = false)
	private LocalDate fecha;

	public PedidoModel(String direccionEntrega, LocalDate fecha) {
		super();
		this.direccionEntrega = direccionEntrega;
		this.fecha = fecha;
	}

	public PedidoModel() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<SanguchesPedidoModel> getSanguches() {
		return sanguches;
	}

	public void setSanguches(Set<SanguchesPedidoModel> sanguches) {
		this.sanguches = sanguches;
	}

	public String getDireccionEntrega() {
		return direccionEntrega;
	}

	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "PedidoModel [id=" + id + ", direccionEntrega=" + direccionEntrega + ", fecha="
				+ fecha + "]";
	}

}
