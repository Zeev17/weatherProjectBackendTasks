package com.weatherProject.backendTasks.core.entity;


public class Temperature {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKelvin() {
        return kelvin;
    }

    public void setKelvin(Long kelvin) {
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

    public Long getRecordCreated() {
        return recordCreated;
    }

    public void setRecordCreated(Long recordCreated) {
        this.recordCreated = recordCreated;
    }

    private  Long id;
    private  Long kelvin;
    private  String nameCity ;
    private String idCity;
    private Long recordCreated;



}
