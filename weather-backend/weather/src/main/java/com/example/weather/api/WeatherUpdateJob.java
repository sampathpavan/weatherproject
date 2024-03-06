package com.example.weather.api;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.weather.entity.WeatherData;
import com.example.weather.repository.WeatherRepository;

@Component
public class WeatherUpdateJob implements Job {
	
	@Autowired
	private WeatherRepository weatherRepository;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		double latitude = 0.0; // Replace with actual latitude
        double longitude = 0.0; // Replace with actual longitude

        // Make API call to OpenWeatherMap
        String apiKey = "bc71d72710fa01a17bbfa9a6605faf4d"; // Replace with your OpenWeatherMap API key
        String apiUrl = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%f&lon=%f&appid=%s&units=metric",
                latitude, longitude, apiKey);
        RestTemplate restTemplate = new RestTemplate();
        WeatherData weatherData = restTemplate.getForObject(apiUrl, WeatherData.class);

        // Save the retrieved weather data to the database
        weatherRepository.save(weatherData);
		
	}

}
