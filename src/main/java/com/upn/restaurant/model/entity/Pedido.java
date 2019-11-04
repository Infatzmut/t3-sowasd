package com.upn.restaurant.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

	@OneToMany(mappedBy = "pedidoS", fetch = FetchType.LAZY)
	private List<DetallePedido> detallepedidos;

	@OneToOne(mappedBy = "pedidos")
	private Personal personales;

	public Pedido() {
		detallepedidos = new ArrayList<>();
	}

	public void addPedido(DetallePedido detallepedido) {
		detallepedido.setPedidos(this);
		this.detallepedidos.add(detallepedido);
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

	public List<DetallePedido> getDetallepedidos() {
		return detallepedidos;
	}

	public void setDetallepedidos(List<DetallePedido> detallepedidos) {
		this.detallepedidos = detallepedidos;
	}

	public Personal getPersonales() {
		return personales;
	}

	public void setPersonales(Personal personales) {
		this.personales = personales;
	}

}
