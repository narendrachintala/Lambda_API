package com.rccl.model;

import java.sql.Timestamp;

/**
 * The Class RollingWindow.
 */
public class RollingWindow {

	private ParameterFiltersData filtersData;
	
	private Integer prev_forecast;
	private Integer fut_forecast;
	private Integer price_window;
	private Integer wts;
	private Timestamp l1_insert_date;
	private Integer prev_demand_window;
	private Integer fut_demand_window;

	/**
	 * @return the filtersData
	 */
	public ParameterFiltersData getFiltersData() {
		return filtersData;
	}

	/**
	 * @param filtersData the filtersData to set
	 */
	public void setFiltersData(ParameterFiltersData filtersData) {
		this.filtersData = filtersData;
	}

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

	/**
	 * @return the l1_insert_date
	 */
	public Timestamp getL1_insert_date() {
		return l1_insert_date;
	}

	/**
	 * @param l1_insert_date the l1_insert_date to set
	 */
	public void setL1_insert_date(Timestamp l1_insert_date) {
		this.l1_insert_date = l1_insert_date;
	}

	/**
	 * @return the prev_demand_window
	 */
	public Integer getPrev_demand_window() {
		return prev_demand_window;
	}

	/**
	 * @param prev_demand_window the prev_demand_window to set
	 */
	public void setPrev_demand_window(Integer prev_demand_window) {
		this.prev_demand_window = prev_demand_window;
	}

	/**
	 * @return the fut_demand_window
	 */
	public Integer getFut_demand_window() {
		return fut_demand_window;
	}

	/**
	 * @param fut_demand_window the fut_demand_window to set
	 */
	public void setFut_demand_window(Integer fut_demand_window) {
		this.fut_demand_window = fut_demand_window;
	}
}
