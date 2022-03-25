package com.kintsugi.apientregador.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kintsugi.apientregador.model.Order;

public interface OrderDAO extends CrudRepository<Order, Integer> {
	
	@Query(value="select * from orders where driver_id = :driverId and status = 'EM_TRANSITO'", nativeQuery= true)
	public List<Order> findAllByIdDriverAndStatusInTransit(int driverId);

}
