package com.example.weathertask.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "weather_history")
public class WeatherHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="location")
    private String location;

    @Column(name="country")
    private String country;

    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "temperature_celsius")
    private Double temperatureCelsius;

    @Column(name = "condition_text")
    private String conditionText;

    @Column(name = "wind_kph")
    private Double windKph;

    @Column(name = "wind_degree")
    private Integer windDegree;

    @Column(name = "pressure_mb")
    private Double pressureMb;

    @Column(name = "precip_mm")
    private Double precipMm;

    @Column(name = "humidity")
    private Integer humidity;

    @Column(name = "feels_like_celsius")
    private Double feelsLikeCelsius;

    public WeatherHistory(Long id, Date timestamp, String postalCode, Double temperatureCelsius, String conditionText,
                          Double windKph, Integer windDegree, Double pressureMb, Double precipMm, Integer humidity,
                          Double feelsLikeCelsius) {
        this.id = id;
        this.timestamp = timestamp;
        this.postalCode = postalCode;
        this.temperatureCelsius = temperatureCelsius;
        this.conditionText = conditionText;
        this.windKph = windKph;
        this.windDegree = windDegree;
        this.pressureMb = pressureMb;
        this.precipMm = precipMm;
        this.humidity = humidity;
        this.feelsLikeCelsius = feelsLikeCelsius;
    }

    public WeatherHistory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Double getTemperatureCelsius() {
        return temperatureCelsius;
    }

    public void setTemperatureCelsius(Double temperatureCelsius) {
        this.temperatureCelsius = temperatureCelsius;
    }

    public String getConditionText() {
        return conditionText;
    }

    public void setConditionText(String conditionText) {
        this.conditionText = conditionText;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public Double getWindKph() {
        return windKph;
    }

    public void setWindKph(Double windKph) {
        this.windKph = windKph;
    }

    public Integer getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(Integer windDegree) {
        this.windDegree = windDegree;
    }

    public Double getPressureMb() {
        return pressureMb;
    }

    public void setPressureMb(Double pressureMb) {
        this.pressureMb = pressureMb;
    }

    public Double getPrecipMm() {
        return precipMm;
    }

    public void setPrecipMm(Double precipMm) {
        this.precipMm = precipMm;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Double getFeelsLikeCelsius() {
        return feelsLikeCelsius;
    }

    public void setFeelsLikeCelsius(Double feelsLikeCelsius) {
        this.feelsLikeCelsius = feelsLikeCelsius;
    }
}
