package com.rccl.model;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class PriceRange.
 *
 * @author narendra.chintala
 */
@JsonPOJOBuilder
public class PriceRange {

	/** The filter data. */
	private ParameterFiltersData filtersData;

	/** The l 1 range min. */
	private Double l1_range_min;

	/** The l 1 range max. */
	private Double l1_range_max;

	/** The l 1 insert date. */
	private Double l1_insert_date;

	/** The l 2 range min. */
	private Double l2_range_min;

	/** The l 2 range max. */
	private Double l2_range_max;

	/**
	 * Gets the filter data.
	 *
	 * @return the filter data
	 */
	public ParameterFiltersData getFiltersData() {
		return filtersData;
	}

	/**
	 * Sets the filter data.
	 *
	 * @param filterData the new filter data
	 */
	public void setFiltersData(ParameterFiltersData filtersData) {
		this.filtersData = filtersData;
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
	public Double getL1_insert_date() {
		return l1_insert_date;
	}

	/**
	 * Sets the l 1 insert date.
	 *
	 * @param l1_insert_date the new l 1 insert date
	 */
	public void setL1_insert_date(Double l1_insert_date) {
		this.l1_insert_date = l1_insert_date;
	}

	/**
	 * Gets the l 2 range min.
	 *
	 * @return the l 2 range min
	 */
	public Double getL2_range_min() {
		return l2_range_min;
	}

	/**
	 * Sets the l 2 range min.
	 *
	 * @param l2_range_min the new l 2 range min
	 */
	public void setL2_range_min(Double l2_range_min) {
		this.l2_range_min = l2_range_min;
	}

	/**
	 * Gets the l 2 range max.
	 *
	 * @return the l 2 range max
	 */
	public Double getL2_range_max() {
		return l2_range_max;
	}

	/**
	 * Sets the l 2 range max.
	 *
	 * @param l2_range_max the new l 2 range max
	 */
	public void setL2_range_max(Double l2_range_max) {
		this.l2_range_max = l2_range_max;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PriceRange [filterData=" + filtersData + ", l1_range_min=" + l1_range_min + ", l1_range_max="
				+ l1_range_max + ", l1_insert_date=" + l1_insert_date + ", l2_range_min=" + l2_range_min
				+ ", l2_range_max=" + l2_range_max + "]";
	}

	/*
	 * public static void main(String[] args) { PriceRange p = new PriceRange();
	 * p.setL1_range_min(-0.06); ValidatorFactory factory =
	 * Validation.buildDefaultValidatorFactory(); Validator validator =
	 * factory.getValidator(); Set<ConstraintViolation<PriceRange>> validations =
	 * validator.validate(p); for(ConstraintViolation<PriceRange> t : validations) {
	 * System.out.println(t.getMessage()); } }
	 */

}
