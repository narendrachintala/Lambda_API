package com.rccl.model;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

// TODO: Auto-generated Javadoc
/**
* The Class CurrentPricePara.
*
* @author chandrabhan.birla
*/
@JsonPOJOBuilder
public class CurrentPricePara {
	
	/** The filters data. */
	private ParameterFiltersData filtersData;
	
	/** The price window. */
	private Double price_window;
	
	/** The l 1 range min. */
	private Double l1_range_min;
	
	/** The l 1 range max. */
	private Double l1_range_max;
	
	/** The l 1 insert date. */
	private String l1_insert_date;
	
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
	 * Gets the price window.
	 *
	 * @return the price window
	 */
	public Double getPrice_window() {
		return price_window;
	}
	
	/**
	 * Sets the price window.
	 *
	 * @param price_window the new price window
	 */
	public void setPrice_window(Double price_window) {
		this.price_window = price_window;
	}
	
	/**
	 * Gets the l 1 range min.
	 *
	 * @return the l 1 range min
	 */
	public Double getL1_range_min() {
		return l1_range_min;
	}
	
	/**
	 * Sets the l 1 range min.
	 *
	 * @param l1_range_min the new l 1 range min
	 */
	public void setL1_range_min(Double l1_range_min) {
		this.l1_range_min = l1_range_min;
	}
	
	/**
	 * Gets the l 1 range max.
	 *
	 * @return the l 1 range max
	 */
	public Double getL1_range_max() {
		return l1_range_max;
	}
	
	/**
	 * Sets the l 1 range max.
	 *
	 * @param l1_range_max the new l 1 range max
	 */
	public void setL1_range_max(Double l1_range_max) {
		this.l1_range_max = l1_range_max;
	}
	
	/**
	 * Gets the l 1 insert date.
	 *
	 * @return the l 1 insert date
	 */
	public String getL1_insert_date() {
		return l1_insert_date;
	}
	
	/**
	 * Sets the l 1 insert date.
	 *
	 * @param l1_insert_date the new l 1 insert date
	 */
	public void setL1_insert_date(String l1_insert_date) {
		this.l1_insert_date = l1_insert_date;
	}

	/**
	 * To string.
	 * @return the string
	 */
	@Override
	public String toString() {
		return "CurrentPricePara [filtersData=" + filtersData + ", price_window=" + price_window + ", l1_range_min="
				+ l1_range_min + ", l1_range_max=" + l1_range_max + ", l1_insert_date=" + l1_insert_date + "]";
	}
}
