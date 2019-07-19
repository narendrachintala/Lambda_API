package com.rccl.model;

import java.sql.Timestamp;
/**
 * The Class BookedPosition.
 */
public class BookedPosition {
	
	/** The filters data. */
	private ParameterFiltersData filtersData;	
	
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
	/**
	 * To string.
	 * @return the string
	 */
	@Override
	public String toString() {
		return "BookedPosition [filtersData=" + filtersData + ", booked_position=" + booked_position + ", l1_insert_date=" + l1_insert_date+ 
				", getBooked_position()=" + getBooked_position() +", getL1_insert_date()=" + getL1_insert_date() + "]";
		}
}
