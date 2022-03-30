package com.kintsugi.apientregador.dao;

import org.springframework.data.repository.CrudRepository;
import com.kintsugi.apientregador.model.Driver;
public interface DriverDAO extends CrudRepository <Driver, Integer> {
    public Driver findByEmail(String email);
}
