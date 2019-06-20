package com.rccl.model;

/**
 * The Class RollingWindow.
 */
public class RollingWindow extends FiltersData {
	private Integer prev_forecast;
	private Integer fut_forecast;
	private Integer price_window;
	private Integer wts;
	/**
	 * @return the prev_forecast
	 */
	public Integer getPrev_forecast() {
		return prev_forecast;
	}
	/**
	 * @param prev_forecast the prev_forecast to set
	 */
	public void setPrev_forecast(Integer prev_forecast) {
		this.prev_forecast = prev_forecast;
	}
	/**
	 * @return the fut_forecast
	 */
	public Integer getFut_forecast() {
		return fut_forecast;
	}
	/**
	 * @param fut_forecast the fut_forecast to set
	 */
	public void setFut_forecast(Integer fut_forecast) {
		this.fut_forecast = fut_forecast;
	}
	/**
	 * @return the price_window
	 */
	public Integer getPrice_window() {
		return price_window;
	}
	/**
	 * @param price_window the price_window to set
	 */
	public void setPrice_window(Integer price_window) {
		this.price_window = price_window;
	}
	/**
	 * @return the wts
	 */
	public Integer getWts() {
		return wts;
	}
	/**
	 * @param wts the wts to set
	 */
	public void setWts(Integer wts) {
		this.wts = wts;
	}
}
