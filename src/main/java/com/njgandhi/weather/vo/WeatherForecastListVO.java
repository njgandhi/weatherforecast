/**
 * 
 */
package com.njgandhi.weather.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author niravgandhi
 *
 */
public class WeatherForecastListVO implements Serializable {

	private static final long serialVersionUID = -3743440567336470742L;
	
	private String cod;

	private BigDecimal message;

	private Integer cnt;
	
	private List<WeatherForecastVO> list;

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public BigDecimal getMessage() {
		return message;
	}

	public void setMessage(BigDecimal message) {
		this.message = message;
	}

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	public List<WeatherForecastVO> getList() {
		return list;
	}

	public void setList(List<WeatherForecastVO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "WeatherForecastListVO [cod=" + cod + ", message=" + message + ", cnt=" + cnt + ", list=" + list + "]";
	}


}
