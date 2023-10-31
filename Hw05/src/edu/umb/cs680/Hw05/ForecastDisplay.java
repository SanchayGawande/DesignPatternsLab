package edu.umb.cs680.Hw05;
public class ForecastDisplay implements Observer<WeatherData> {
    @Override
    public void update(Observable<WeatherData> sender, WeatherData event) {
        double pressure = event.getPressure();
        wd = event;
        System.out.println("Weather Forecast: Pressure " + pressure + " hPa");
    }
    private WeatherData wd;
    public WeatherData getWeatherData() {
        return wd;
    }
}