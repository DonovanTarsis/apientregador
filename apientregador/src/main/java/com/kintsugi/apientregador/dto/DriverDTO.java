package com.kintsugi.apientregador.dto;

import com.kintsugi.apientregador.model.Driver;

public class DriverDTO {

    private Integer id;
    private String name;

    public DriverDTO(Driver driver) {
        this.id = driver.getId();
        this.name = driver.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
