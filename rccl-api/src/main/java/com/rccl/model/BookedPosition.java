package com.rccl.model;

import java.sql.Timestamp;
/**
 * The Class BookedPosition.
 */
public class BookedPosition {
	
	/** The filters data. */
	private ParameterFiltersData filtersData;	
	
	/** The currency. */
	private String currency;
	
	/** The booked position. */
	private Integer booked_position;
	
	/** The l 1 insert date. */
	private Timestamp l1_insert_date;
	
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
	 * Gets the currency.
	 *
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	
	/**
	 * Sets the currency.
	 *
	 * @param currency the new currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	/**
	 * Gets the booked position.
	 *
	 * @return the booked position
	 */
	public Integer getBooked_position() {
		return booked_position;
	}
	
	/**
	 * Sets the booked position.
	 *
	 * @param booked_position the new booked position
	 */
	public void setBooked_position(Integer booked_position) {
		this.booked_position = booked_position;
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
}
