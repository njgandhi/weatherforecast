package com.njgandhi.weather.exception;

public class CityNotFoundExecption extends RuntimeException {
	
	
	private static final long serialVersionUID = -1229989094129233810L;
	
	public CityNotFoundExecption(String city) {
		this.city = city;
	}
	
	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
