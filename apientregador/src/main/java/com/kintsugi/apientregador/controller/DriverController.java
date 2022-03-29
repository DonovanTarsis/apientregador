package com.kintsugi.apientregador.controller;

import com.kintsugi.apientregador.dao.DriverDAO;
import com.kintsugi.apientregador.service.DriverService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverController {
    @Autowired
    private DriverService driverService;

    @GetMapping("/drivers/{id}")
    public ResponseEntity<?> pegarDriverPeloId(@PathVariable("id") Integer id){
        return driverService.pegarDriverPeloId(id);
    }
}
