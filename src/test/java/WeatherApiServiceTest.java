import com.example.weathertask.entity.WeatherHistory;
import com.example.weathertask.service.WeatherApiService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class WeatherApiServiceTest {

    @Mock
    private WeatherApiService weatherApiService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFetchWeather() throws Exception {
        WeatherHistory expectedWeather = new WeatherHistory();
        expectedWeather.setLocation("City");
        expectedWeather.setCountry("Country");
        expectedWeather.setTemperatureCelsius(20.0);
        expectedWeather.setConditionText("Sunny");

        when(weatherApiService.fetchWeather("12345")).thenReturn(expectedWeather);
        WeatherHistory weatherHistory = weatherApiService.fetchWeather("12345");

        assertEquals("City", weatherHistory.getLocation());
        assertEquals("Country", weatherHistory.getCountry());
        assertEquals(20.0, weatherHistory.getTemperatureCelsius(), 0.01);
        assertEquals("Sunny", weatherHistory.getConditionText());
    }

}
