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

            return ResponseEntity.status(500).body("Erro no servidor");
        }

    }

    public ResponseEntity<?> atualizarDriverPeloId(Integer id, Driver driverBody) {
        try {
            Driver driver = driverDAO.findById(id).orElse(null);
            if(driver == null) {
                return ResponseEntity.status(404).body("Driver não encontrado");
            }
            
            Driver buscaEmail = driverDAO.findByEmailEquals(driverBody.getEmail());
            if(buscaEmail != null && buscaEmail.getId() != driver.getId()) {
                return ResponseEntity.status(400).body("Email já existente");
            }               
            if(driverBody.getEmail() != null) {
                driver.setEmail(driverBody.getEmail());
            }
            

            if(driverBody.getName() != null) {
                driver.setName(driverBody.getName());
            }
            if(driverBody.getPassword() != null) {
                driver.setPassword(driverBody.getPassword());
            }
            if(driverBody.getLatitude() != null) {
                driver.setLatitude(driverBody.getLatitude());
            }
            if(driverBody.getLongitude() != null) {
                driver.setLongitude(driverBody.getLongitude());
            }
            if(driverBody.getPhoneNumber() != null) {
                driver.setPhoneNumber(driverBody.getPhoneNumber());
            }

            driverDAO.save(driver);

            return ResponseEntity.status(200).body("Driver atualizado com sucesso");

        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body("Erro no servidor");
        }
    }
}
