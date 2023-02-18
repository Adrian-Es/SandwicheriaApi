package com.repaso.model;


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
@Table(name = "proveedores")
public class ProveedorModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false,length = 40)
	private String nombre;
	
	@Column(nullable = false,length = 75)
	private String direccion;

	@Column(length = 20)
	private String telefono;
	
	@OneToMany(mappedBy = "proveedor",cascade = CascadeType.ALL)
	private Set<RepartosModel> repartos;
	
	public ProveedorModel(String nombre, String direccion, String telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	public ProveedorModel() {
		
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Set<RepartosModel> getRepartos() {
		return repartos;
	}

	public void setRepartos(Set<RepartosModel> repartos) {
		this.repartos = repartos;
	}

	@Override
	public String toString() {
		return "ProveedorModel [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ "]";
	}
	
	
}
