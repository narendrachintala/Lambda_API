package com.rccl.model;

import java.sql.Timestamp;

/**
 * The Class PausePara.
 */
public class PausePara {

	/** The filters data. */
	private ParameterFiltersData filtersData;
	
	/** The l 1 pause. */
	private Integer l1_pause;
	
	/** The l 1 insert date. */
	private Timestamp l1_insert_date;
	
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
	 * To string.
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PausePara [filtersData=" + filtersData + ", l1_pause=" + l1_pause + ", l1_insert_date=" + l1_insert_date
				+ ", getFiltersData()=" + getFiltersData() + ", getL1_pause()=" + getL1_pause()
				+ ", getL1_insert_date()=" + getL1_insert_date() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
