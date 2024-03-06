package com.example.weather.controller;

import java.sql.Date;
import java.util.List;

//import org.hibernate.boot.jaxb.JaxbLogger_.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weather.entity.WeatherData;
import com.example.weather.entity.WeatherFrequency;
import com.example.weather.entity.WeatherHistory;
import com.example.weather.repository.WeatherFrequencyRepository;
import com.example.weather.repository.WeatherHistoryRepository;
import com.example.weather.repository.WeatherRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/weather")
public class WeatherHistoryController {
	
	@Autowired
	private WeatherHistoryRepository whr;
	private WeatherFrequencyRepository wfr;
	
	@PostMapping("/history")
	public WeatherHistory historyData(@RequestBody WeatherHistory wh) {
		System.out.println(wh.getCity());
		System.out.println(wh.getTemperature());
		System.out.println(wh.getTimestamp());
		return whr.save(wh) ;
		
	}
	@GetMapping("/getAllHistory")
    public List<WeatherHistory> getAllHistoryData() {
    	return whr.findAll();
    }

}
