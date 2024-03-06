import React from 'react'

const WeatherHistory = (props) => {
    const { weatherHistory } = props
    return (
        <div>
            <h2>Weather History:</h2>
            <ul >
                {weatherHistory.map((weather, index) => (
                    <li key={index}>
                        Temperature: {weather.temperature}°C, City: {weather.city}, Timestamp: {weather.timestamp.toLocaleString()}
                    </li>
                ))}
            </ul>
        </div>
    )
}

export default WeatherHistory