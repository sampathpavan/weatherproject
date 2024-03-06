package com.example.weather.service;

import org.springframework.stereotype.Service;

@Service
public class UpdateFrequencyService {
	
	// Default update frequency
    private int updateFrequency = 3; // Default update frequency is 3 minutes

    // Method to set the update frequency
    public void setUpdateFrequency(int newFrequency) {
        // Validate the new frequency (if needed)
        if (newFrequency > 0) {
            updateFrequency = newFrequency;
        } else {
            // Handle invalid frequency (throw exception, log error, etc.)
            // For simplicity, let's set a default value
            updateFrequency = 3;
        }
    }


	// Method to get the current update frequency
    public int getUpdateFrequency() {
        return updateFrequency;
    }

}
