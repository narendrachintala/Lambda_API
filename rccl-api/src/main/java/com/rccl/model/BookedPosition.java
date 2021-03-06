package com.rccl.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
/**
 * The Class BookedPosition.
 */
@JsonPOJOBuilder
public class BookedPosition {
	
	/** The filters data. */
	private ParameterFiltersData filtersData;	
	
	/** The booked position. */
	private Double booked_position;
	
	/** The l 1 insert date. */
	private Timestamp l1_insert_date;
	
	/** The user id. */
	private String user_id;
	
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
	public Double getBooked_position() {
		return booked_position;
	}
	
	/**
	 * Sets the booked position.
	 *
	 * @param booked_position the new booked position
	 */
	public void setBooked_position(Double booked_position) {
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
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	/**
	 * To string.
	 * @return the string
	 */
	@Override
	public String toString() {
		return "BookedPosition [filtersData=" + filtersData + ", booked_position=" + booked_position
				+ ", l1_insert_date=" + l1_insert_date + ", user_id=" + user_id + "]";
	}
}
