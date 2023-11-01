package edu.umb.cs680.Hw05;

public class WeatherDataObservable extends Observable<WeatherData> {
    private double temperature;
    private double humidity;
    private double pressure;

    public void setWeatherData(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers(new WeatherData(temperature, humidity, pressure));
    }

}