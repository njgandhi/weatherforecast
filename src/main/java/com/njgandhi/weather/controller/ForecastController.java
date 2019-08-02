package com.njgandhi.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.njgandhi.weather.service.ForecastService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/weather")
public class ForecastController {
	
	@Autowired
	private ForecastService forecastService;

	@ApiOperation("Return a JSON object that gives the weather averages.")
	@GetMapping(value = "/city-forecast", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> weatherForecastAverage(@ApiParam("City") @RequestParam(required = true) String city) {
		return forecastService.weatherForecastAverage(city);
	}

}
