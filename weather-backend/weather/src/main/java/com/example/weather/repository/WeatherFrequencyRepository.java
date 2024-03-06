package com.example.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.weather.entity.WeatherFrequency;

@Repository
public interface WeatherFrequencyRepository extends JpaRepository<WeatherFrequency, Integer>{

}
