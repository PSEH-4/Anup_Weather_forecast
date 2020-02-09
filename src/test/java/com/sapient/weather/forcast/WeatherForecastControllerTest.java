package com.sapient.weather.forcast;

import static org.junit.Assert.assertEquals;

import com.sapient.weather.forcast.service.WeatherForecastService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WeatherForecastControllerTest {

    @MockBean
    private WeatherForecastService weatherForecastService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testWeatherController() throws Exception {
        String response = "Weather conditions are normal";

        Mockito.when(weatherForecastService.getWeatherForeCasteByCity(Mockito.anyString())).thenReturn(response);

        final RequestBuilder builder = MockMvcRequestBuilders.get("/weather/forecast/delhi");

        final MvcResult mvcResult = mockMvc.perform(builder).andReturn();
        final MockHttpServletResponse httpResponse = mvcResult.getResponse();
        final String resultJson = httpResponse.getContentAsString();

        org.assertj.core.api.Assertions.assertThat(resultJson).isEqualTo(response);
        assertEquals(HttpStatus.OK.value(), httpResponse.getStatus());
    }
}