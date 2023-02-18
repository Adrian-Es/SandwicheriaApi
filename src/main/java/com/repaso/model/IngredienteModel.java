package com.repaso.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "ingredientes")
public class IngredienteModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 30)
	private String nombre;
	
	@Column(nullable = false)
	private Integer cantidadTotal;
	
	@OneToMany(mappedBy = "ingrediente",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private Set<DetalleRepartosModel> ingredienteComprado; 
	
	@OneToMany(mappedBy = "ingrediente",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<DetalleSangucheModel> ingredienteUsado;
	
	public IngredienteModel() {
		
	}
	
	public IngredienteModel(String nombre) {
		this.nombre = nombre;
		this.cantidadTotal = Integer.valueOf(0);
		}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCantidadTotal() {
		return cantidadTotal;
	}

	public void setCantitadTotal(Integer cantidadTotal) {
		this.cantidadTotal = cantidadTotal;
	}

	public Set<DetalleRepartosModel> getIngredienteComprado() {
		return ingredienteComprado;
	}

	public void setIngredienteComprado(HashSet<DetalleRepartosModel> ingredienteComprado) {
		this.ingredienteComprado = ingredienteComprado;
	}

	public Set<DetalleSangucheModel> getIngredienteUsado() {
		return ingredienteUsado;
	}

	public void setIngredienteUsado(HashSet<DetalleSangucheModel> ingredienteUsado) {
		this.ingredienteUsado = ingredienteUsado;
	}

	@Override
	public String toString() {
		return "IngredienteModel [id=" + id + ", nombre=" + nombre + ", cantitadTotal=" + cantidadTotal + "]";
	}
	
	
}
