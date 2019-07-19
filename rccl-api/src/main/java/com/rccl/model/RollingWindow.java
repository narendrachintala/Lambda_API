package com.rccl.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * The Class RollingWindow.
 */
@JsonPOJOBuilder
public class RollingWindow {

	/** The filters data. */
	private ParameterFiltersData filtersData;

	/** The prev forecast. */
	private Integer prev_forecast;

	/** The fut forecast. */
	private Integer fut_forecast;

	/** The price window. */
	private Integer price_window;

	/** The wts. */
	private Integer wts;

	/** The l 1 insert date. */
	private Timestamp l1_insert_date;

	/** The prev demand window. */
	private Integer prev_demand_window;

	/** The fut demand window. */
	private Integer fut_demand_window;

	/**
	 * Gets the filters data.
	 *
	 * @return the filters data
	 */
	public ParameterFiltersData getFiltersData() {
		return filtersData;
	}

	/**
	 * Sets the filters data.
	 *
	 * @param filtersData the new filters data
	 */
	public void setFiltersData(ParameterFiltersData filtersData) {
		this.filtersData = filtersData;
	}

	/**
	 * Gets the prev forecast.
	 *
	 * @return the prev forecast
	 */
	public Integer getPrev_forecast() {
		return prev_forecast;
	}

	/**
	 * Sets the prev forecast.
	 *
	 * @param prev_forecast the new prev forecast
	 */
	public void setPrev_forecast(Integer prev_forecast) {
		this.prev_forecast = prev_forecast;
	}

	/**
	 * Gets the fut forecast.
	 *
	 * @return the fut forecast
	 */
	public Integer getFut_forecast() {
		return fut_forecast;
	}

	/**
	 * Sets the fut forecast.
	 *
	 * @param fut_forecast the new fut forecast
	 */
	public void setFut_forecast(Integer fut_forecast) {
		this.fut_forecast = fut_forecast;
	}

	/**
	 * Gets the price window.
	 *
	 * @return the price window
	 */
	public Integer getPrice_window() {
		return price_window;
	}

	/**
	 * Sets the price window.
	 *
	 * @param price_window the new price window
	 */
	public void setPrice_window(Integer price_window) {
		this.price_window = price_window;
	}

	/**
	 * Gets the wts.
	 *
	 * @return the wts
	 */
	public Integer getWts() {
		return wts;
	}

	/**
	 * Sets the wts.
	 *
	 * @param wts the new wts
	 */
	public void setWts(Integer wts) {
		this.wts = wts;
	}

	/**
	 * Gets the l 1 insert date.
	 *
	 * @return the l 1 insert date
	 */
	public Timestamp getL1_insert_date() {
		return l1_insert_date;
	}

	/**
	 * Sets the l 1 insert date.
	 *
	 * @param l1_insert_date the new l 1 insert date
	 */
	public void setL1_insert_date(Timestamp l1_insert_date) {
		this.l1_insert_date = l1_insert_date;
	}

	/**
	 * Gets the prev demand window.
	 *
	 * @return the prev demand window
	 */
	public Integer getPrev_demand_window() {
		return prev_demand_window;
	}

	/**
	 * Sets the prev demand window.
	 *
	 * @param prev_demand_window the new prev demand window
	 */
	public void setPrev_demand_window(Integer prev_demand_window) {
		this.prev_demand_window = prev_demand_window;
	}

	/**
	 * Gets the fut demand window.
	 *
	 * @return the fut demand window
	 */
	public Integer getFut_demand_window() {
		return fut_demand_window;
	}

	/**
	 * Sets the fut demand window.
	 *
	 * @param fut_demand_window the new fut demand window
	 */
	public void setFut_demand_window(Integer fut_demand_window) {
		this.fut_demand_window = fut_demand_window;
	}

	@Override
	public String toString() {
		return "RollingWindow [filtersData=" + filtersData + ", prev_forecast=" + prev_forecast + ", fut_forecast="
				+ fut_forecast + ", price_window=" + price_window + ", wts=" + wts + ", l1_insert_date="
				+ l1_insert_date + ", prev_demand_window=" + prev_demand_window + ", fut_demand_window="
				+ fut_demand_window + "]";
	}

}
