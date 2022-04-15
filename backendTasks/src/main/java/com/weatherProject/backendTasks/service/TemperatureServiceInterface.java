package com.weatherProject.backendTasks.service;

import com.weatherProject.backendTasks.entity.Temperature;

import java.util.List;

public interface TemperatureServiceInterface {
    Temperature registerTemperature(Temperature temperature);
    List<Temperature> getTemperatureList();
    Temperature getTemperatureById(long id);
}
