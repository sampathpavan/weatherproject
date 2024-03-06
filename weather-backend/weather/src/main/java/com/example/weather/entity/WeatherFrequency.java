package com.example.weather.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WeatherFrequency {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int frequency;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public WeatherFrequency(int id, int frequency) {
		super();
		this.id = id;
		this.frequency = frequency;
	}
	public WeatherFrequency() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
