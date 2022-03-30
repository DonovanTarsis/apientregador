package com.kintsugi.apientregador.services;

import com.kintsugi.apientregador.dao.DriverDAO;
import com.kintsugi.apientregador.dto.DriverLoginDTO;
import com.kintsugi.apientregador.model.Driver;
import com.kintsugi.apientregador.security.Token;
import com.kintsugi.apientregador.security.TokenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DriverServiceImpl implements IDriverService{

    @Autowired
    private DriverDAO dao;

    @Override
    public Token gerarTokenDeDriverLogado(DriverLoginDTO dadosLogin) {
        Driver driver = dao.findByEmailEquals(dadosLogin.getEmail());
        if(driver != null){
            boolean passwordIsValid = driver.getPassword().equals(dadosLogin.getPassword());
            
            if(passwordIsValid){
                return new Token(TokenUtil.createToken(driver));
            }
        }
        return null;
    }
    
}
