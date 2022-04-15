package com.weatherProject.backendTasks.core.repository;

import com.weatherProject.backendTasks.core.entity.Temperature;

import java.util.List;

public interface TemperatureRepositoryInterface {
    Temperature add(Temperature temperature);
    List<Temperature> list();
    Temperature getById(long id);
}
