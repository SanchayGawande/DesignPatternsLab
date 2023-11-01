package edu.umb.cs680.Hw05;

public class WeatherData {
    private double temperature;
    private double humidity;
    private double pressure;

    public WeatherData(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public static void main(String[] args) {
        WeatherDataObservable weatherData = new WeatherDataObservable();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
        ForecastDisplay forecastDisplay = new ForecastDisplay();

        weatherData.addObserver(currentDisplay);
        weatherData.addObserver(statisticsDisplay);
        weatherData.addObserver(forecastDisplay);

        for (int i = 0; i < 5; i++) {
            double temperature = Math.random() * 30;
            double humidity = Math.random() * 100;
            double pressure = Math.random() * 1000;

            weatherData.setWeatherData(temperature, humidity, pressure);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}



