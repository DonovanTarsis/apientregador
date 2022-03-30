package com.kintsugi.apientregador.services;

import com.kintsugi.apientregador.dto.DriverLoginDTO;
import com.kintsugi.apientregador.security.Token;

public interface IDriverService {
    public Token gerarTokenDeDriverLogado(DriverLoginDTO dadosLogin);
}