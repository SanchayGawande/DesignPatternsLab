package edu.umb.cs680.Hw05;
public class StatisticsDisplay implements Observer<WeatherData> {
    @Override
    public void update(Observable<WeatherData> sender, WeatherData event) {
        double temperature = event.getTemperature();
        double humidity = event.getHumidity();
        double pressure = event.getPressure();
        wd = event;

        System.out.println("Statistics: Temperature " + temperature + "°C, Humidity " + humidity + "%, Pressure " + pressure + " hPa");
    }
    private WeatherData wd;
    public WeatherData getWeatherData() {
        return wd;
    }
}