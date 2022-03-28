package com.kintsugi.apientregador.controller;

import javax.websocket.server.PathParam;

import com.kintsugi.apientregador.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/orders")
	public ResponseEntity<?> listarPedidosEmAberto(@RequestParam("driver_id") Integer idDriver) {
		return orderService.listarPedidosEmAberto(idDriver);
	}

	@PutMapping("/orders/{id}/start-tracking")
	public ResponseEntity<?> startTracking(@PathVariable("id") Integer id,
			@RequestParam("driver_id") Integer driverId) {
		return orderService.startOrderTracking(id, driverId);
	}

}
