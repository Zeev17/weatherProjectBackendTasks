package com.weatherProject.backendTasks.entity;

import java.util.Date;

public class Temperature {

    private  String id;
    private  short kelvin;
    private  String nameCity ;
    private String idCity;
    private Date recordCreated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public short getKelvin() {
        return kelvin;
    }

    public void setKelvin(short kelvin) {
        this.kelvin = kelvin;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getIdCity() {
        return idCity;
    }

    public void setIdCity(String idCity) {
        this.idCity = idCity;
    }

    public Date getRecordCreated() {
        return recordCreated;
    }

    public void setRecordCreated(Date recordCreated) {
        this.recordCreated = recordCreated;
    }

}
