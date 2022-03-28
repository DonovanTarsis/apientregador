package com.kintsugi.apientregador.service;

import java.util.List;

import com.kintsugi.apientregador.dao.OrderDAO;
import com.kintsugi.apientregador.dto.OrderListagemDTO;
import com.kintsugi.apientregador.model.Order;
import com.kintsugi.apientregador.utils.OrderStatusEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderDAO orderDAO;

    public ResponseEntity<?> listarPedidosEmAberto(Integer idDriver) {
        try {
            Integer status = OrderStatusEnum.EM_ESPERA.getStatus();
            List<Order> list = orderDAO.listOrdersFiltered(status, idDriver);

            return ResponseEntity.status(200).body(list.stream().map(o -> new OrderListagemDTO(o)));

        } catch (RuntimeException ex) {
            return ResponseEntity.status(500).body("Erro no servidor");
        }
    }

}
