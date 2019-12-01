package com.hawken.db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private String name;
	
	@ManyToMany(mappedBy="products", cascade = CascadeType.ALL)
	private List<Order> orders = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}