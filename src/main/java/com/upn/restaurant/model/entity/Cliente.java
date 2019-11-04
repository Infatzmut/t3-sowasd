package com.upn.restaurant.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Cliente {
	@Id
	@Column
	private Integer id;
}
