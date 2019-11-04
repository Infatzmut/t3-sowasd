package com.upn.restaurant.model.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;





@Entity
@Table(name = "pedidos")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pedido_id", length = 5)
	private Integer id;

	@Column(name = "descripcion", length = 100)
	private String descripcion;

	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "personal_id")
	private Personal personales;
	
	 @OneToMany(mappedBy = "pedidos")
		private List<DetallePedido> detallepedidos;
	 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
		private Cliente cliente;
	


	public List<DetallePedido> getDetallepedidos() {
		return detallepedidos;
	}

	public void setDetallepedidos(List<DetallePedido> detallepedidos) {
		this.detallepedidos = detallepedidos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Personal getPersonales() {
		return personales;
	}

	public void setPersonales(Personal personales) {
		this.personales = personales;
	}

	public List<DetallePedido> getDetallepedido() {
		return detallepedidos;
	}

	public void setDetallepedido(List<DetallePedido> detallepedido) {
		this.detallepedidos = detallepedido;
	}


}
