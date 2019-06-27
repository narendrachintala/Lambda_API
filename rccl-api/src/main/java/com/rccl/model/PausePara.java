package com.rccl.model;

import java.sql.Timestamp;

/**
 * The Class PausePara.
 */
public class PausePara {

	private ParameterFiltersData filterData;
	private Integer l1_pause;
	private Timestamp l1_insert_date;
	/**
	 * @return the filterData
	 */
	public ParameterFiltersData getFilterData() {
		return filterData;
	}
	/**
	 * @param filterData the filterData to set
	 */
	public void setFilterData(ParameterFiltersData filterData) {
		this.filterData = filterData;
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
}
