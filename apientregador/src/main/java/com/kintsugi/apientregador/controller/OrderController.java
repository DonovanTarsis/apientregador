package com.kintsugi.apientregador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kintsugi.apientregador.dao.OrderDAO;
import com.kintsugi.apientregador.model.Order;

@RestController
public class OrderController {

	@Autowired

	private OrderDAO dao;

	@GetMapping("/orders")
	public List<Order> listarPedidos() {
		return (List<Order>) dao.findAllWhereStatusEmEspera();
	}

	@GetMapping("/orders/driver/{idDriver}")
	public List<Order> recuperarPedidoIdDriver(@PathVariable Integer idDriver) {
		List<Order> lista;
		lista = (List<Order>) dao.findAllByIdDriverAndStatusInTransit(idDriver);
		return lista;
	}

}
