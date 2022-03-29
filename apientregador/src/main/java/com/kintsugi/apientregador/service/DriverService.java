package com.kintsugi.apientregador.service;

import com.kintsugi.apientregador.dao.DriverDAO;
import com.kintsugi.apientregador.dto.DriverByIdDTO;
import com.kintsugi.apientregador.model.Driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
    @Autowired 
    private DriverDAO driverDAO;

    public ResponseEntity<?> pegarDriverPeloId(Integer id){
        try {
            Driver driver= driverDAO.findById(id).orElse(null);
            if(driver == null){
                return ResponseEntity.status(404).body("driver não encontrado");
            
            }
            DriverByIdDTO driverByIdDTO= new DriverByIdDTO(driver);
            return ResponseEntity.status(200).body(driverByIdDTO);
            
        } catch (RuntimeException e) {

            return ResponseEntity.status(500).body("erro no servidor");
        }

    }
}
