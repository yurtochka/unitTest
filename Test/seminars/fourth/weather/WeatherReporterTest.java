package seminars.fourth.weather;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class WeatherReporterTest {

    @Test
    void testWeatherReporterGenerateReport(){
        WeatherService weatherService = mock(WeatherService.class);
        WeatherReporter weatherReporter = new WeatherReporter(weatherService);
        when(weatherService.getCurrentTemperature()).thenReturn(15);

        String res = weatherReporter.generateReport();

        assertThat(res).isEqualTo("Текущая температура: " + 15 + " градусов.");

        verify(weatherService, times(3)).getCurrentTemperature();
    }

}