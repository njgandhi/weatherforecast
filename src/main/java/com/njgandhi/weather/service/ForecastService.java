package com.njgandhi.weather.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.njgandhi.weather.exception.CityNotFoundExecption;
import com.njgandhi.weather.response.ForecastAverageResponse;
import com.njgandhi.weather.vo.WeatherForecastListVO;
import com.njgandhi.weather.vo.WeatherForecastVO;

import springfox.documentation.spring.web.json.Json;

@Service
public class ForecastService {

	private final RestTemplate forecastRestTemplate;

	private final String apiUri = "http://api.openweathermap.org/data/2.5/forecast";

	private final String apiKey = "a925b0529a5dbd65653a1b00f56ec488";

	public ForecastService(RestTemplateBuilder restTemplateBuilder) {
		this.forecastRestTemplate = restTemplateBuilder.build();
	}

	public ResponseEntity<?> weatherForecastAverage(String city) {
		List<ForecastAverageResponse> result = new ArrayList<ForecastAverageResponse>();
		try {
			WeatherForecastListVO weatherForecastList = this.forecastRestTemplate.getForObject(this.url(city),
					WeatherForecastListVO.class);

			for (LocalDate reference = LocalDate.now(); reference
					.isBefore(LocalDate.now().plusDays(4)); reference = reference.plusDays(1)) {
				final LocalDate ref = reference;
				List<WeatherForecastVO> collect = weatherForecastList.getList().stream()
						.filter(x -> x.getDt_txt().toLocalDate().equals(ref)).collect(Collectors.toList());
				if (!CollectionUtils.isEmpty(collect)) {
					result.add(this.average(collect));
				}

			}
		} catch (HttpClientErrorException e) {
			if(HttpStatus.NOT_FOUND.equals(e.getStatusCode()))
				throw new CityNotFoundExecption(city);
			else 
				return new ResponseEntity<>(new Json(e.getResponseBodyAsString()), e.getStatusCode());
		}

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	private ForecastAverageResponse average(List<WeatherForecastVO> list) {
		ForecastAverageResponse result = new ForecastAverageResponse();

		for (WeatherForecastVO weatherForecast : list) {
			result.setDate(weatherForecast.getDt_txt().toLocalDate());
			result.addWeatherForecast(weatherForecast);
		}

		result.totalize();

		return result;
	}

	private String url(String city) {
		return String.format(apiUri.concat("?q=%s").concat("&appid=%s").concat("&units=metric"), city, apiKey);
	}

}
