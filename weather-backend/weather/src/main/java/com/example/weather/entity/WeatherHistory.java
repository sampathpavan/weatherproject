package com.example.weather.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class WeatherHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private long temperature;
	private String city;
	private Date timestamp;
	
	
	public WeatherHistory(int id, long temperature, String city, Date timestamp) {
		super();
		this.id = id;
		this.temperature = temperature;
		this.city = city;
		this.timestamp=timestamp;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public WeatherHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getTemperature() {
		return temperature;
	}
	public void setTemperature(long temperature) {
		this.temperature = temperature;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	} 
	

}
