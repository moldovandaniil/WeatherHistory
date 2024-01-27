package com.example.weathertask.service;

import com.example.weathertask.entity.WeatherHistory;
import com.example.weathertask.repository.WeatherHistoryRepository;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class WeatherHistoryService {
    private final WeatherHistoryRepository weatherHistoryRepository;
    private final WeatherApiService weatherApiService;

    public WeatherHistoryService() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("default").createEntityManager();
        this.weatherHistoryRepository = new WeatherHistoryRepository(entityManager);
        this.weatherApiService = new WeatherApiService();
    }

    public WeatherHistory getWeather(String postalCode) throws Exception {
        WeatherHistory weatherHistory = weatherApiService.fetchWeather(postalCode);
        saveWeatherData(weatherHistory);

        return weatherHistory;
    }

    public void saveWeatherData(WeatherHistory weatherData) {
        weatherHistoryRepository.save(weatherData);
    }

    public List<WeatherHistory> getWeatherHistoryByPostalCode(String postalCode) {
        return weatherHistoryRepository.findByPostalCode(postalCode);
    }

    public List<WeatherHistory> getAllWeatherHistory() {
        return weatherHistoryRepository.findAll();
    }
}

