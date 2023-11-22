package seminars.fourth.weather;

public class WeatherReporter {
    private WeatherService weatherService;

    // Внедрение зависимости через конструктор
    public WeatherReporter(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public String generateReport() {
        int temperature = weatherService.getCurrentTemperature();
        int temperatureMorning = weatherService.getCurrentTemperature();
        int temperatureEvening = weatherService.getCurrentTemperature();

        return "Текущая температура: " + ((temperatureMorning + temperatureEvening)/2) + " градусов.";
    }
}
