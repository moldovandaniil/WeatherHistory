package com.example.weathertask.servlet;


import com.example.weathertask.entity.WeatherHistory;
import com.example.weathertask.service.WeatherHistoryService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/weather/*")
public class WeatherServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postalCode = request.getParameter("postalCode");
        String postalCodePattern = "^\\d{5}(-\\d{4})?$";

        WeatherHistoryService weatherService = new WeatherHistoryService();
        if(postalCode.matches(postalCodePattern)){
            try {
                WeatherHistory currentWeather = weatherService.getWeather(postalCode);
                List<WeatherHistory> weatherHistory = weatherService.getWeatherHistoryByPostalCode(postalCode);

                request.setAttribute("currentWeather", currentWeather);
                request.setAttribute("weatherHistoryList", weatherHistory);

                request.getRequestDispatcher("/response.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                String errorMessage = "No weather data available for this postal code.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
        else{
            String errorMessage = "Invalid postal code format. Please enter a valid USA postal code.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WeatherHistoryService weatherService = new WeatherHistoryService();

        String pathInfo = request.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing action in request.");
            return;
        }

        String[] splits = pathInfo.split("/");
        if (splits.length != 2) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action in request.");
            return;
        }

        String action = splits[1];

        if ("history".equals(action)) {
            String postalCode = request.getParameter("postalCode");
            List<WeatherHistory> weatherHistoryList = weatherService.getWeatherHistoryByPostalCode(postalCode);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            new Gson().toJson(weatherHistoryList, response.getWriter());
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action in request.");
        }
    }

}



