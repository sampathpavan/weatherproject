# Weather App using spring boot and React

This Application uses OpenWeather api and empowers users to access real-time weather data based on their location coordinates. In the main UI user will be asked to allow the permission and after allowing
the permission user will be able to see the temperature, cityname, latitude and longitude. 
User can also able to see the weather history, weather chart based on frequency.

# OpenWeather API
<a>https://openweathermap.org/api</a>

# Tech-stack
1.) React

2.) Spring Boot

3.) Mysql

4.) Postman

# IDE used

1.) STS

2.) VS Code

3.) MySQL DB

# Features 

# 1. Geolocation

The app initially asks users to allow the location and if the user allows the location then the user's latitude and longitude will be automatically fetched.

# 2. Weather Display

Based on the Coordinates we can display the temperature,city,humidity and other climatic conditions. Users can instantly view the weather conditions without any input.

# 3.  Update Frequency

Users have the flexibility to customize the frequency at which rate data should be updated.
Ex: Suppose if user entered 1 min then for every one minute the data will be displayed on the UI.

# 4.  Weather History

The app has the flexibility to display the history of weather data that includes temperature,cityname and timestamp. Users can easily compare the past data with present.

# 5.  Weather Chart

For visualizing the data the app generates a line chart that gives temperature changes over time.

# Backend

Different endpoints are created for fetching the data, weather history and weather frequency.
Data of each will be stored in the respective tables

# Sample UI output

![weatherOutput](https://github.com/sampathpavan/weatherproject/assets/73058239/7ddaf0f4-ae5d-4661-91ec-baec43418016)
![weatherHistoryChart](https://github.com/sampathpavan/weatherproject/assets/73058239/e9a50c50-8473-4573-b6c6-6a3b552e40e4)


# Setup

Clone the repository which contains backend and frontend code.
Add the required dependencies in the frontend and backend by using npm install command in react project.
Run both backend and frontend projects.

# Dependencies

# 1.) Axios : For making HTTP requests to the OpenWeatherMap API and backend server.
# 2.) Chart.js : For creating interactive charts to visualize weather data.
# 3.) React and react-dom: Essential libraries for building user interfaces and managing component rendering in React.

# Important Points

## 1.) Make sure to replace apikey.
## 2.) Make sure to see the port numbers in frontend and backend


