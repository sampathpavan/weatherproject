package com.example.weather;

import java.util.Date;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
@EnableScheduling
public class WeatherApplication {
	
	Logger logger=(Logger) LoggerFactory.getLogger(WeatherApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
	}

//	@Scheduled(fixedRate = 2000L)
//	public void job() {
//		logger.info("curnt" + new Date());
//		
//	}
}
