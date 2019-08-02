package com.njgandhi.weather.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class WeatherForecastVO implements Serializable{

	private static final long serialVersionUID = 4870349065542441155L;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dt_txt;

	private WeatherForecastMainVO main;


	public LocalDateTime getDt_txt() {
		return dt_txt;
	}

	public void setDt_txt(LocalDateTime dt_txt) {
		this.dt_txt = dt_txt;
	}

	public WeatherForecastMainVO getMain() {
		return main;
	}

	public void setMain(WeatherForecastMainVO main) {
		this.main = main;
	}

	@JsonIgnore
	public Boolean isDaily() {
		return (this.dt_txt.getHour() >= 6 && this.dt_txt.getHour() < 18);
	}

	@Override
	public String toString() {
		return "WeatherForecastVO [dt_txt=" + dt_txt + ", main=" + main + "]";
	}
	
	

}
