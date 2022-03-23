package com.kintsugi.apientregador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tracking")
public class Tracking {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="timestamp", nullable = false)
	private String timestamp;
	
	@Column(name="latitude", nullable = false)
	private Double latitude;
	
	@Column(name="longitude", nullable = false)
	private Double longitude;
	
	@Column(name="order_id", nullable = false)
	private Integer OrderId;
}
