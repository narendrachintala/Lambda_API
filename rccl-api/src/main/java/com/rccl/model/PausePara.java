package com.rccl.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * The Class PausePara.
 */
@JsonPOJOBuilder
public class PausePara {

	/** The filters data. */
	private ParameterFiltersData filtersData;
	
	/** The l 1 pause. */
	private Integer l1_pause;
	
	/** The l 1 insert date. */
	private Timestamp l1_insert_date;
	
	/** The RESUME_PUSH_WTS. */
	private Integer resume_push_wts;
	
	/** The STOP_PUSH_WTS. */
	private Integer stop_push_wts;
	
	/** The user id. */
	private String user_id;
	
	/**
	 * Gets the filters data.
	 * @return the filters data
	 */
	public ParameterFiltersData getFiltersData() {
		return filtersData;
	}

	/**
	 * Sets the filters data.
	 * @param filtersData the new filters data
	 */
	public void setFiltersData(ParameterFiltersData filtersData) {
		this.filtersData = filtersData;
	}

	/**
	 * Gets the resume_push_wts.
	 * @return the resume_push_wts
	 */
	public Integer getresume_push_wts() {
		return resume_push_wts;
	}
	
	/**
	 * Sets the resume_push_wts.
	 * @param resume_push_wts the new resume_push_wts
	 */
	public void setresume_push_wts(Integer resume_push_wts) {
		this.resume_push_wts=resume_push_wts;
	}
	/**
	 * Gets the stop_push_wts.
	 * @return the stop_push_wts
	 */
	public Integer getstop_push_wts() {
		return stop_push_wts;
	}
	
	/**
	 * Sets the stop_push_wts.
	 * @param stop_push_wts the new stop_push_wts
	 */
	public void setstop_push_wts(Integer stop_push_wts) {
		this.stop_push_wts=stop_push_wts;
	}
	/**
	 * Gets the l 1 pause.
	 * @return the l 1 pause
	 */
	public Integer getL1_pause() {
		return l1_pause;
	}

	/**
	 * Sets the l 1 pause.
	 * @param l1_pause the new l 1 pause
	 */
	public void setL1_pause(Integer l1_pause) {
		this.l1_pause = l1_pause;
	}

	/**
	 * Gets the l 1 insert date.
	 * @return the l 1 insert date
	 */
	public Timestamp getL1_insert_date() {
		return l1_insert_date;
	}

	/**
	 * Sets the l 1 insert date.
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
		return "PausePara [filtersData=" + filtersData + ", l1_pause=" + l1_pause + ", l1_insert_date=" + l1_insert_date
				+ ", resume_push_wts=" + resume_push_wts + ", stop_push_wts=" + stop_push_wts + ", user_id=" + user_id
				+ "]";
	}
}
