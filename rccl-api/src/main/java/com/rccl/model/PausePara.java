package com.rccl.model;

import java.sql.Timestamp;

/**
 * The Class PausePara.
 */
public class PausePara {

	private ParameterFiltersData filtersData;
	private Integer l1_pause;
	private Timestamp l1_insert_date;
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
	 * @return the l1_pause
	 */
	public Integer getL1_pause() {
		return l1_pause;
	}
	/**
	 * @param l1_pause the l1_pause to set
	 */
	public void setL1_pause(Integer l1_pause) {
		this.l1_pause = l1_pause;
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
	@Override
	public String toString() {
		return "PausePara [filtersData=" + filtersData + ", l1_pause=" + l1_pause + ", l1_insert_date=" + l1_insert_date
				+ ", getFiltersData()=" + getFiltersData() + ", getL1_pause()=" + getL1_pause()
				+ ", getL1_insert_date()=" + getL1_insert_date() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
