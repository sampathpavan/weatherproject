import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Chart from 'chart.js/auto';
import './App.css';
import Data from './Data';
import WeatherHistory from './WeatherHistory';
import WeatherChart from './WeatherChart';
import WeatherFrequency from './WeatherFrequency';

const App = () => {
    const [latitude, setLatitude] = useState(0);
    const [longitude, setLongitude] = useState(0);
    const [temperature, setTemperature] = useState(0);
    const [city, setCity] = useState('');
    const [updateFrequency, setUpdateFrequency] = useState(3); // Default update frequency is 3 minutes
    const [weatherHistory, setWeatherHistory] = useState([]);
    const [isUpdating, setIsUpdating] = useState(false);
    const [newFrequency, setNewFrequency] = useState(3);
    const [hasDisplayedInitialWeather, setHasDisplayedInitialWeather] = useState(false);
    const [chart, setChart] = useState(null);
    const [coordinatesSent, setCoordinatesSent] = useState(false);

    useEffect(() => {
        const fetchWeather = async () => {
            try {
                const position = await new Promise((resolve, reject) => {
                    navigator.geolocation.getCurrentPosition(resolve, reject);
                });
                setLatitude(position.coords.latitude);
                setLongitude(position.coords.longitude);
                const response = await axios.get(`https://api.openweathermap.org/data/2.5/weather?lat=${position.coords.latitude}&lon=${position.coords.longitude}&appid=bc71d72710fa01a17bbfa9a6605faf4d&units=metric`);
                const { main, name } = response.data;
                setTemperature(main.temp);
                setCity(name);

                // Add weather data to history only if it's updating and hasn't displayed initial weather
                if (isUpdating && !hasDisplayedInitialWeather) {
                    setHasDisplayedInitialWeather(true);
                    return;
                }

                if (isUpdating) {
                    setWeatherHistory(prevHistory => [...prevHistory, { temperature: main.temp, city: name, timestamp: new Date() }]);
                    //sending backend
                    await axios.post('http://localhost:8989/api/weather/history', { temperature: main.temp, city: name, timestamp: new Date() })
                }
            } catch (error) {
                console.error(error);
            }
        };

        // Fetch weather initially
        fetchWeather();

        const interval = setInterval(() => {
            if (isUpdating) {
                fetchWeather();
            }
        }, updateFrequency * 60 * 1000);

        return () => clearInterval(interval);
    }, [updateFrequency, isUpdating, hasDisplayedInitialWeather]);

    useEffect(() => {
        if (latitude !== 0 && longitude !== 0 && !coordinatesSent) {
            saveCoordinates(latitude, longitude);
        }
    }, [latitude, longitude, coordinatesSent]);

    const saveCoordinates = async (latitude, longitude) => {
        try {
            await axios.post('http://localhost:8989/api/data', { latitude, longitude });
            console.log("Coordinates saved successfully");
        } catch (error) {
            console.error("Error saving coordinates", error);
        }
    };

    useEffect(() => {
        if (weatherHistory.length > 0) {
            if (!chart) {
                const ctx = document.getElementById('weatherChart');
                const newChart = new Chart(ctx, {
                    type: 'line',
                    data: {
                        labels: weatherHistory.map(weather => weather.timestamp.toLocaleString()),
                        datasets: [{
                            label: 'Temperature (°C)',
                            data: weatherHistory.map(weather => weather.temperature),
                            borderColor: 'rgb(75, 192, 192)',
                            tension: 0.1
                        }]
                    },
                    options: {
                        scales: {
                            y: {
                                beginAtZero: true
                            }
                        }
                    }
                });
                setChart(newChart);
            } else {
                chart.data.labels = weatherHistory.map(weather => weather.timestamp.toLocaleString());
                chart.data.datasets[0].data = weatherHistory.map(weather => weather.temperature);
                chart.update();
            }
        }
    }, [weatherHistory, chart]);

    const handleFrequencyChange = (e) => {
        setNewFrequency(parseInt(e.target.value, 10));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setUpdateFrequency(newFrequency);
        setIsUpdating(true);
        setWeatherHistory([]);
        setHasDisplayedInitialWeather(false);
        try {
            await axios.post('http://localhost:8989/api/updateFrequency', { frequency: newFrequency });
        } catch (error) {
            console.error('Error updating frequency:', error);
        }
    };
    return (
        <div className="app-wrapper">
            <div className="container">
                <div>
                    <Data latitude={latitude} longitude={longitude} temperature={temperature}
                        city={city} frequency={updateFrequency} />
                    <WeatherFrequency newFrequency={newFrequency} handleFrequencyChange={handleFrequencyChange}
                        handleSubmit={handleSubmit} />
                    <WeatherHistory weatherHistory={weatherHistory} />
                    <WeatherChart />
                </div>
            </div>
        </div>
    );
};
export default App;