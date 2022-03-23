package com.kintsugi.apientregador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="orders")
public class Orders {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="value", nullable = false)
	private Double value;
	
	@Column(name="timestamp", nullable = false)
	private String timestamp;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	@JsonIgnoreProperties("ordersList")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="driver_id")
	@JsonIgnoreProperties("ordersList")
	private Driver driver;
	
	
	
	
	
}
