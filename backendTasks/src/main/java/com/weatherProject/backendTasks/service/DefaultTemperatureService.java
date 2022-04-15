package com.weatherProject.backendTasks.service;

import com.weatherProject.backendTasks.entity.Temperature;
import com.weatherProject.backendTasks.repository.TemperatureRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultTemperatureService implements TemperatureServiceInterface {

    @Autowired
    private TemperatureRepositoryInterface temperatureRepository;

    public TemperatureRepositoryInterface getTemperatureRepository() {
        return temperatureRepository;
    }

    public void setTemperatureRepository(TemperatureRepositoryInterface temperatureRepository) {
        this.temperatureRepository = temperatureRepository;
    }

    public Temperature registerTemperature(Temperature temperature){
        return temperatureRepository.add(temperature);
    }

    @Override
    public List<Temperature> getTemperatureList() {
        return null;
    }

    @Override
    public Temperature getTemperatureById(long id){
        return temperatureRepository.getById(id);
    }
}
