package edu.umb.cs680.Hw05;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class WeatherDataTest {
    private WeatherData weatherData;
    private CurrentConditionsDisplay currentDisplay;
    private StatisticsDisplay statisticsDisplay;
    private ForecastDisplay forecastDisplay;

    @Before
    public void setUp() {
        weatherData = new WeatherData();
        currentDisplay = new CurrentConditionsDisplay();
        statisticsDisplay = new StatisticsDisplay();
        forecastDisplay = new ForecastDisplay();

        weatherData.addObserver(currentDisplay);
        weatherData.addObserver(statisticsDisplay);
        weatherData.addObserver(forecastDisplay);
    }

    @Test
    public void testInitialObserverCount() {
        assertEquals(3, weatherData.countObservers());
    }

    @Test
    public void testWeatherDataUpdates() {
        double temperature = 25.0;
        double humidity = 50.0;
        double pressure = 1013.0;

        weatherData.setWeatherData(temperature, humidity, pressure);

        assertEquals(temperature, currentDisplay.getWeatherData().getTemperature(), 0.01);
        assertEquals(humidity, currentDisplay.getWeatherData().getHumidity(), 0.01);

        assertEquals(temperature, statisticsDisplay.getWeatherData().getTemperature(), 0.01);
        assertEquals(humidity, statisticsDisplay.getWeatherData().getHumidity(), 0.01);

        assertEquals(pressure, forecastDisplay.getWeatherData().getPressure(), 0.01);
    }

    @Test
    public void testObserverRemove() {
        weatherData.removeObserver(forecastDisplay);

        double temperature = 22.5;
        double humidity = 60.0;
        double pressure = 1010.0;

        weatherData.setWeatherData(temperature, humidity, pressure);

        assertEquals(temperature, currentDisplay.getWeatherData().getTemperature(), 0.01);
        assertEquals(humidity, currentDisplay.getWeatherData().getHumidity(), 0.01);

        assertEquals(temperature, statisticsDisplay.getWeatherData().getTemperature(), 0.01);
        assertEquals(humidity, statisticsDisplay.getWeatherData().getHumidity(), 0.01);

        assertNull(forecastDisplay.getWeatherData());
    }

    @Test
    public void testWeatherDataPressureUpdates() {
        double temperature = 25.0;
        double humidity = 50.0;
        double pressure = 1013.0;

        weatherData.setWeatherData(temperature, humidity, pressure);

        assertEquals(pressure, forecastDisplay.getWeatherData().getPressure(), 0.01);
    }

    @Test
    public void testGetObservers() {
        List<Observer<WeatherData>> observers = weatherData.getObservers();

        assertTrue(observers.contains(currentDisplay));
        assertTrue(observers.contains(statisticsDisplay));
        assertTrue(observers.contains(forecastDisplay));
    }

    @Test
    public void testClearAllObservers() {
        weatherData.clearObservers();
        assertEquals(0, weatherData.countObservers());
    }
}
