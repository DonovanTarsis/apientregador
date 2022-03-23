package com.kintsugi.apientregador.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="driver")
public class Driver {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name", length = 100, nullable = false)
	private String name;
	
	@Column(name="phone_number", length = 11, nullable = false)
	private String phoneNumber;
	
	@Column(name="email", length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@Column(name="latitude", nullable = false)
	private Double latitude;
	
	@Column(name="longitute", nullable = false)
	private Double longitude;
	
	@OneToMany(mappedBy="driver")
	@JsonIgnoreProperties("driver")
	private List<Orders> ordersList;
	
}
