package com.kintsugi.apientregador.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="value", nullable = false)
	private Double value;
	
	@Column(name="timestamp", nullable = false)
	private String timestamp;
	
	@Column(name="status", nullable = false)
	private String status;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	@JsonIgnoreProperties("ordersList")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="driver_id")
	@JsonIgnoreProperties("ordersList")
	private Driver driver;
	
	@OneToMany(mappedBy="order")
	@JsonIgnoreProperties("order")
	private List<Tracking> trackingList;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public List<Tracking> getTrackingList() {
		return trackingList;
	}
	public void setTrackingList(List<Tracking> trackingList) {
		this.trackingList = trackingList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}		
		
}
