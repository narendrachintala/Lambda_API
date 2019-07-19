package com.rccl.model;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * The Class RefundablePremium.
 */
@JsonPOJOBuilder
public class RefundablePremium {
	
	/** The filters data. */
	private ParameterFiltersData filtersData;
	
	/** The gap type. */
	private String gap_type;
	
	/** The current gap pct. */
	private Double current_gap_pct;
	
	/** The standard gap pct. */
	private Double standard_gap_pct;
	
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
	 * Gets the gap type.
	 *
	 * @return the gap type
	 */
	public String getGap_type() {
		return gap_type;
	}
	
	/**
	 * Sets the gap type.
	 *
	 * @param gap_type the new gap type
	 */
	public void setGap_type(String gap_type) {
		this.gap_type = gap_type;
	}
	
	/**
	 * Gets the current gap pct.
	 *
	 * @return the current gap pct
	 */
	public Double getCurrent_gap_pct() {
		return current_gap_pct;
	}
	
	/**
	 * Sets the current gap pct.
	 *
	 * @param current_gap_pct the new current gap pct
	 */
	public void setCurrent_gap_pct(Double current_gap_pct) {
		this.current_gap_pct = current_gap_pct;
	}
	
	/**
	 * Gets the standard gap pct.
	 *
	 * @return the standard gap pct
	 */
	public Double getStandard_gap_pct() {
		return standard_gap_pct;
	}
	
	/**
	 * Sets the standard gap pct.
	 *
	 * @param standard_gap_pct the new standard gap pct
	 */
	public void setStandard_gap_pct(Double standard_gap_pct) {
		this.standard_gap_pct = standard_gap_pct;
	}
}
