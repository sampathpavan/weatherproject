package com.example.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.weather.entity.WeatherHistory;

@Repository
public interface WeatherHistoryRepository extends JpaRepository<WeatherHistory, Integer> {

}
