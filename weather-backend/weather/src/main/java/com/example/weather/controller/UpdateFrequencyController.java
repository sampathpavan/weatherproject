package com.example.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.weather.entity.WeatherFrequency;
import com.example.weather.repository.WeatherFrequencyRepository;
import com.example.weather.repository.WeatherHistoryRepository;
import com.example.weather.service.UpdateFrequencyService;
//
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UpdateFrequencyController {
	
	@Autowired
	private WeatherFrequencyRepository wfr;
//	
//	@Autowired
//	private UpdateFrequencyService updateFrequencyService;
//
////    public UpdateFrequencyController(UpdateFrequencyService updateFrequencyService) {
////        this.updateFrequencyService = updateFrequencyService;
////    }
//
    @PostMapping("/api/updateFrequency")
    public WeatherFrequency updateFrequency(@RequestBody WeatherFrequency wf) {
    	
       System.out.println("frequeny"+ wf.getFrequency());
       return wfr.save(wf);
    }

}
