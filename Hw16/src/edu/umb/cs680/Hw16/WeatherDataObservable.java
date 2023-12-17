package edu.umb.cs680.Hw16;

public class WeatherDataObservable extends Observable<WeatherData> {
    public void setWeatherData(double temperature, double humidity, double pressure) {
        notifyObservers(new WeatherData(temperature, humidity, pressure));
    }
}
