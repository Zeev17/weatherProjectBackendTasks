package com.weatherProject.backendTasks.core.service;

import com.weatherProject.backendTasks.core.entity.Temperature;

import java.util.List;

public interface TemperatureServiceInterface {
    Temperature registerTemperature(Temperature temperature);
    List<Temperature> getTemperatureList();
    Temperature getTemperatureById(long id);
}
