package com.upn.restaurant.model.entity;

import java.util.List;
import java.util.ArrayList;
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
@Table(name = "clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id", length = 5)
	private Integer id;
	
	@Column(name = "nombre", length = 80)
	private String nombre;
	
	@OneToMany(mappedBy = "clientes", fetch = FetchType.LAZY)
	private List<Plato> platos;
	
	@OneToOne(mappedBy = "clientes")
	private Usuario usuarios;
	
	public Cliente() {
		platos = new ArrayList<>();
	}
	
	public void addPlato(Plato plato) {
		plato.setCliente(this);
		this.platos.add(plato);
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

	public List<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(List<Plato> platos) {
		this.platos = platos;
	}

	public Usuario getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}
	
	
	

}