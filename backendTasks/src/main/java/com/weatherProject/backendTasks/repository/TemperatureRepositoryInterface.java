package com.weatherProject.backendTasks.repository;

import com.weatherProject.backendTasks.entity.Temperature;

import java.util.List;

public interface TemperatureRepositoryInterface {
    Temperature add(Temperature temperature);
    List<Temperature> list();
    Temperature getById(long id);
}
