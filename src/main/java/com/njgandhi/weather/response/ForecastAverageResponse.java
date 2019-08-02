package com.njgandhi.weather.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.njgandhi.weather.vo.WeatherForecastVO;

public class ForecastAverageResponse implements Serializable {

	private static final long serialVersionUID = -2046075020330078257L;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate date;

	private BigDecimal daily;

	private BigDecimal nightly;

	private BigDecimal pressure;

	@JsonIgnore
	private BigDecimal totalDaily;

	@JsonIgnore
	private Integer quantDaily;

	@JsonIgnore
	private BigDecimal totalNightly;

	@JsonIgnore
	private Integer quantNightly;

	@JsonIgnore
	private BigDecimal totalPressure;

	@JsonIgnore
	private Integer quantPressure;

	public ForecastAverageResponse() {
		this.totalDaily = BigDecimal.ZERO;
		this.totalNightly = BigDecimal.ZERO;
		this.totalPressure = BigDecimal.ZERO;
		this.quantDaily = 0;
		this.quantNightly = 0;
		this.quantPressure = 0;
	}

	public ForecastAverageResponse(LocalDate date, BigDecimal daily, BigDecimal nightly, BigDecimal pressure,
			BigDecimal totalDaily, Integer quantDaily, BigDecimal totalNightly, Integer quantNightly,
			BigDecimal totalPressure, Integer quantPressure) {
		this.date = date;
		this.daily = daily;
		this.nightly = nightly;
		this.pressure = pressure;
		this.totalDaily = totalDaily;
		this.quantDaily = quantDaily;
		this.totalNightly = totalNightly;
		this.quantNightly = quantNightly;
		this.totalPressure = totalPressure;
		this.quantPressure = quantPressure;
	}

	public void addWeatherForecast(WeatherForecastVO weatherForecast) {
		if (weatherForecast.isDaily()) {
			this.totalDaily = this.totalDaily.add(weatherForecast.getMain().getTemp());
			this.quantDaily++;
		} else {
			this.totalNightly = this.totalNightly.add(weatherForecast.getMain().getTemp());
			this.quantNightly++;
		}
		this.totalPressure = this.totalPressure.add(weatherForecast.getMain().getTemp());
		this.quantPressure++;
	}

	public void totalize() {
		this.daily = (this.quantDaily > 0)
				? this.totalDaily.divide(new BigDecimal(this.quantDaily.toString()), 2, RoundingMode.HALF_UP)
				: null;
		this.nightly = (this.quantNightly > 0)
				? this.totalNightly.divide(new BigDecimal(this.quantNightly.toString()), 2, RoundingMode.HALF_UP)
				: null;
		this.pressure = (this.quantPressure > 0)
				? this.totalPressure.divide(new BigDecimal(this.quantPressure.toString()), 2, RoundingMode.HALF_UP)
				: null;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public BigDecimal getDaily() {
		return daily;
	}

	public void setDaily(BigDecimal daily) {
		this.daily = daily;
	}

	public BigDecimal getNightly() {
		return nightly;
	}

	public void setNightly(BigDecimal nightly) {
		this.nightly = nightly;
	}

	public BigDecimal getPressure() {
		return pressure;
	}

	public void setPressure(BigDecimal pressure) {
		this.pressure = pressure;
	}

	public BigDecimal getTotalDaily() {
		return totalDaily;
	}

	public void setTotalDaily(BigDecimal totalDaily) {
		this.totalDaily = totalDaily;
	}

	public Integer getQuantDaily() {
		return quantDaily;
	}

	public void setQuantDaily(Integer quantDaily) {
		this.quantDaily = quantDaily;
	}

	public BigDecimal getTotalNightly() {
		return totalNightly;
	}

	public void setTotalNightly(BigDecimal totalNightly) {
		this.totalNightly = totalNightly;
	}

	public Integer getQuantNightly() {
		return quantNightly;
	}

	public void setQuantNightly(Integer quantNightly) {
		this.quantNightly = quantNightly;
	}

	public BigDecimal getTotalPressure() {
		return totalPressure;
	}

	public void setTotalPressure(BigDecimal totalPressure) {
		this.totalPressure = totalPressure;
	}

	public Integer getQuantPressure() {
		return quantPressure;
	}

	public void setQuantPressure(Integer quantPressure) {
		this.quantPressure = quantPressure;
	}

}
