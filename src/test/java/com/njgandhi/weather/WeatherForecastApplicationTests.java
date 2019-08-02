package com.njgandhi.weather;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WeatherForecastApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void weatherForecastAverageTest() throws Exception {

		String city = "Ahmedabad";

		mvc.perform(get("/forecast/city")
				.contentType(MediaType.APPLICATION_JSON)
				.param("city", city))
				.andDo(print())
				.andExpect(status().isOk());

		city = "xyztest";

		mvc.perform(get("/forecast/city")
				.contentType(MediaType.APPLICATION_JSON)
				.param("city", city))
				.andDo(print())
				.andExpect(status().isNotFound());

		mvc.perform(get("/forecast/city")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isBadRequest());
	}


}
