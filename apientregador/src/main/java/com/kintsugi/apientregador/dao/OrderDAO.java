package com.kintsugi.apientregador.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kintsugi.apientregador.model.Order;

public interface OrderDAO extends CrudRepository<Order, Integer>{
	@Query(value="SELECT * FROM order WHERE status ='EM_ESPERA'" , nativeQuery= true)
	public List<Order> findAllWhereStatusEmEspera();
	
}
