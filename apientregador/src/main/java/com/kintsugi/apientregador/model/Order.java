package com.kintsugi.apientregador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private Double value;

	@Column(nullable = false)
	private String timestamp;

	@Column(nullable = false)
	private Integer status;

	@ManyToOne
	@JoinColumn(name = "driver_id")
	private Driver driver;

	// @ManyToOne
	// @JoinColumn(name = "client_id")
	// @JsonIgnoreProperties("ordersList")
	// private Client client;

	// @ManyToOne
	// @JoinColumn(name = "driver_id")
	// @JsonIgnoreProperties("ordersList")
	// private Driver driver;

	// @OneToMany(mappedBy = "order")
	// @JsonIgnoreProperties("order")
	// private List<Tracking> trackingList;

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

	// public Client getClient() {
	// return client;
	// }

	// public void setClient(Client client) {
	// this.client = client;
	// }

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	// public List<Tracking> getTrackingList() {
	// return trackingList;
	// }

	// public void setTrackingList(List<Tracking> trackingList) {
	// this.trackingList = trackingList;
	// }

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	// @Override
	// public String toString() {
	// return "Order [id=" + id + ", value=" + value + ", timestamp=" + timestamp +
	// ", status=" + status + ", client="
	// + client + ", driver=" + driver + ", trackingList=" + trackingList + "]";
	// }

}
