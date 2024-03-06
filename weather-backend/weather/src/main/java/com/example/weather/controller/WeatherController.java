package com.example.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weather.entity.WeatherData;
import com.example.weather.repository.WeatherRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/data")
public class WeatherController {
	
	@Autowired
	private WeatherRepository weatherRepository;
	
	@PostMapping
    public WeatherData receiveData(@RequestBody WeatherData wd) {
        // Handle the received data here
        System.out.println("Received dataaa: " + wd.getLatitude() + ", " + wd.getLongitude());
        System.out.println(wd);
        return weatherRepository.save(wd);
        
    }

}
