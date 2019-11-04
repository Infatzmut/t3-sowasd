package com.upn.restaurant.model.entity;

import java.util.ArrayList;
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
@Table(name="platos")
public class Plato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="plato_id")
	private Integer id;
	
	@Column(name ="descrip")
	private String descripcion;
	
	@Column(name ="prec")
	private String precio;
	///
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@OneToMany (mappedBy ="plato" , fetch = FetchType.LAZY)
	private List<DetallePedido> detallepedidos;
	
	
	public Plato(){
		this.detallepedidos = new ArrayList<>();
	}
		
	public void addDetallePedido(DetallePedido detallepedido) {
		detallepedido.setPlatos(this);
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
	
	public String getPrecio() {
		return precio;
	}
	
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<DetallePedido> getDetallepedidos() {
		return detallepedidos;
	}
	
	public void setDetallepedidos(List<DetallePedido> detallepedidos) {
		this.detallepedidos = detallepedidos;
	}	
}
