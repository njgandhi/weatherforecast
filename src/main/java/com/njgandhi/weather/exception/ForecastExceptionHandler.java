package com.njgandhi.weather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import springfox.documentation.spring.web.json.Json;

@RestControllerAdvice
public class ForecastExceptionHandler {

	@ExceptionHandler(value = CityNotFoundExecption.class)
	public ResponseEntity<Object> exception(CityNotFoundExecption exception) {
		return new ResponseEntity<>(new Json("City "+exception.getCity()+" not found."), HttpStatus.NOT_FOUND);
	}

}
