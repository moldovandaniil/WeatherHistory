<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.weathertask.entity.WeatherHistory" %>
<%@ page import="java.text.SimpleDateFormat" %>

<html>
<head>
    <title>Weather Data</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        text-align: center;
        padding: 20px;
    }
    table {
        width: 80%;
        margin-left: auto;
        margin-right: auto;
        border-collapse: collapse;
    }
    th, td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: left;
    }
    th {
        background-color: #4CAF50;
        color: white;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
</style>
<body>
<h2>Current Weather</h2>
<p>Time: ${currentWeather.timestamp}</p>
<p>Country: ${currentWeather.country}</p>
<p>Location: ${currentWeather.location}</p>
<p>Temperature: ${currentWeather.temperatureCelsius} °C</p>
<p>Condition: ${currentWeather.conditionText}</p>
<p>Wind Speed: ${currentWeather.windKph} kph</p>
<p>Wind Degree: ${currentWeather.windDegree}°</p>
<p>Pressure: ${currentWeather.pressureMb} mb</p>
<p>Precipitation: ${currentWeather.precipMm} mm</p>
<p>Humidity: ${currentWeather.humidity}%</p>
<p>Feels Like: ${currentWeather.feelsLikeCelsius} °C</p>

<h2>Weather History</h2>
<% List<WeatherHistory> historyList = (List<WeatherHistory>) request.getAttribute("weatherHistoryList"); %>
<% if(historyList != null && !historyList.isEmpty()) { %>
<table border="1">
    <tr>
        <th>Date</th>
        <th>Country</th>
        <th>Location</th>
        <th>Temperature</th>
        <th>Condition</th>
        <th>Wind Speed (kph)</th>
        <th>Wind Degree</th>
        <th>Pressure (mb)</th>
        <th>Precipitation (mm)</th>
        <th>Humidity (%)</th>
        <th>Feels Like (°C)</th>
    </tr>
    <% for(WeatherHistory history : historyList) { %>
    <tr>
        <% SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); %>
        <% String formattedDate = dateFormat.format(history.getTimestamp()); %>
        <td><%= formattedDate %></td>
        <td><%= history.getCountry() %></td>
        <td><%= history.getLocation() %></td>
        <td><%= history.getTemperatureCelsius() %> °C</td>
        <td><%= history.getConditionText() %></td>
        <td><%= history.getWindKph() %> kph</td>
        <td><%= history.getWindDegree() %>°</td>
        <td><%= history.getPressureMb() %> mb</td>
        <td><%= history.getPrecipMm() %> mm</td>
        <td><%= history.getHumidity() %>%</td>
        <td><%= history.getFeelsLikeCelsius() %> °C</td>
    </tr>
    <% } %>
</table>
<% } else { %>
<p>No weatherFW history available.</p>
<% } %>
</body>
</html>
