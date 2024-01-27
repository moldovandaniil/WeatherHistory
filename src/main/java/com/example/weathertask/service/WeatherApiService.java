package com.example.weathertask.service;


import com.example.weathertask.entity.WeatherHistory;
import com.example.weathertask.utils.WeatherApiResponse;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class WeatherApiService {
    private static final String API_URL = "http://api.weatherapi.com/v1/current.json";
    private static final String API_KEY = "c928e09eaca74905b8d94414242701";
    private String postalCode;

    public WeatherHistory fetchWeather(String postalCode) throws Exception {
        this.postalCode = postalCode;
        String urlString = API_URL + "?key=" + API_KEY + "&q=" + postalCode + "&aqi=no";
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            WeatherApiResponse response = new Gson().fromJson(reader, WeatherApiResponse.class);
            return mapResponseToWeatherHistory(response);
        } finally {
            connection.disconnect();
        }
    }

    private WeatherHistory mapResponseToWeatherHistory(WeatherApiResponse response) {
        if (response == null || response.getCurrent() == null) {
            throw new IllegalStateException("No weather data available");
        }

        WeatherHistory weatherHistory = new WeatherHistory();
        weatherHistory.setTimestamp(new java.util.Date());
        weatherHistory.setLocation(response.getLocation().getName());
        weatherHistory.setCountry(response.getLocation().getCountry());
        weatherHistory.setPostalCode(postalCode);
        weatherHistory.setTemperatureCelsius(response.getCurrent().getTemp_c());
        weatherHistory.setConditionText(response.getCurrent().getCondition().getText());
        weatherHistory.setWindKph(response.getCurrent().getWind_kph());
        weatherHistory.setWindDegree(response.getCurrent().getWind_degree());
        weatherHistory.setPressureMb(response.getCurrent().getPressure_mb());
        weatherHistory.setPrecipMm(response.getCurrent().getPrecip_mm());
        weatherHistory.setHumidity(response.getCurrent().getHumidity());
        weatherHistory.setFeelsLikeCelsius(response.getCurrent().getFeelslike_c());

        return weatherHistory;
    }
}
