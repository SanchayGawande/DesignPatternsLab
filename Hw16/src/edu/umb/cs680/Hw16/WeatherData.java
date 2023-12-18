package edu.umb.cs680.Hw16;

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

    }

}



