package com.kintsugi.apientregador.service;

import java.util.List;

import com.kintsugi.apientregador.dao.DriverDAO;
import com.kintsugi.apientregador.dao.OrderDAO;
import com.kintsugi.apientregador.dto.OrderListagemDTO;
import com.kintsugi.apientregador.model.Driver;
import com.kintsugi.apientregador.model.Order;
import com.kintsugi.apientregador.utils.OrderStatusEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    DriverDAO driverDAO;

    public ResponseEntity<?> listarPedidosEmAberto(Integer idDriver) {
        try {
            Integer status = OrderStatusEnum.EM_ESPERA.getStatus();
            List<Order> list = orderDAO.listOrdersFiltered(status, idDriver);

            return ResponseEntity.status(200).body(list.stream().map(o -> new OrderListagemDTO(o)));

        } catch (RuntimeException ex) {
            return ResponseEntity.status(500).body("Erro no servidor");
        }
    }

    public ResponseEntity<?> startOrderTracking(Integer id, Integer driverId) {
        try {

            Order order = orderDAO.findById(id).orElse(null);

            if (order == null) {
                return ResponseEntity.status(404).body("Pedido não encontrado");
            }

            order.setStatus(OrderStatusEnum.EM_TRANSITO.getStatus());

            Driver driver = driverDAO.findById(driverId).get();

            order.setDriver(driver);

            orderDAO.save(order);

            OrderListagemDTO order2 = new OrderListagemDTO(order);

            return ResponseEntity.status(200).body(order2);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(500).body("Erro no servidor");
        }
    }

}
