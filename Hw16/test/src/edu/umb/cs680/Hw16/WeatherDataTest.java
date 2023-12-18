package edu.umb.cs680.Hw16;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeatherDataTest {
    private WeatherDataObservable weatherData;
    private Observer<WeatherData> currentConditions;
    private Observer<WeatherData> statisticsDisplay;
    private Observer<WeatherData> forecastDisplay;

    @Before
    public void setUp() {
        weatherData = new WeatherDataObservable();

        currentConditions = (sender, data) -> {
            System.out.println("Current Conditions: Temperature " + data.getTemperature() + "°C, Humidity " + data.getHumidity() + "%, Pressure " + data.getPressure() + " hPa");
        };

        statisticsDisplay = (sender, data) -> {
            System.out.println("Statistics: Temperature " + data.getTemperature() + "°C, Humidity " + data.getHumidity() + "%, Pressure " + data.getPressure() + " hPa");
        };

        forecastDisplay = (sender, data) -> {
            System.out.println("Weather Forecast: Pressure " + data.getPressure() + " hPa");
        };

        weatherData.addObserver(currentConditions);
        weatherData.addObserver(statisticsDisplay);
        weatherData.addObserver(forecastDisplay);
    }

    @Test
    public void testVerifyInitialObserverCount() {
        assertEquals(3, weatherData.countObservers());
    }

    @Test
    public void testRemoveMultipleObservers() {
        weatherData.removeObserver(statisticsDisplay);
        weatherData.removeObserver(currentConditions);
        assertEquals(1, weatherData.countObservers());
    }

    @Test
    public void testRemoveObserverForecastDisplay() {
        weatherData.removeObserver(forecastDisplay);
        assertEquals(2, weatherData.countObservers());
    }

    @Test
    public void testRemoveObserverStatisticsDisplay() {
        weatherData.removeObserver(statisticsDisplay);
        assertEquals(2, weatherData.countObservers());
    }

    @Test
    public void testRemoveObserverCurrentConditions() {
        weatherData.removeObserver(currentConditions);
        assertEquals(2, weatherData.countObservers());
    }

    @Test
    public void testVerifyClearAllObservers() {
        weatherData.clearObservers();
        assertEquals(0, weatherData.countObservers());
    }

    @Test
    public void testVerifyObserverCount() {
        assertEquals(3, weatherData.countObservers());
    }
}


