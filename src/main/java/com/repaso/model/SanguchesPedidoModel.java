package com.repaso.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sanguches_pedido")
public class SanguchesPedidoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	private PedidoModel pedido;

	@OneToMany(mappedBy = "sanguchePedido", cascade = CascadeType.ALL)
	private Set<DetalleSangucheModel> detallesSanguche;

	public SanguchesPedidoModel(PedidoModel pedido) {
		super();
		this.pedido = pedido;
	}

	public SanguchesPedidoModel() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PedidoModel getPedido() {
		return pedido;
	}

	public void setPedido(PedidoModel pedido) {
		this.pedido = pedido;
	}


	public Set<DetalleSangucheModel> getDetallesSanguche() {
		return detallesSanguche;
	}

	public void setDetallesSanguche(Set<DetalleSangucheModel> detallesSanguche) {
		this.detallesSanguche = detallesSanguche;
	}

	@Override
	public String toString() {
		return "SanguchesPedidoModel [id=" + id + ", pedido=" + pedido + "]";
	}

}
