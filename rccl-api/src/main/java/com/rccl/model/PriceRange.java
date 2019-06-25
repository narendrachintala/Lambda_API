package com.rccl.model;

/**
 * @author narendra.chintala
 *
 */
public class PriceRange {

	private ParameterFiltersData filterData;
	private Double l1_range_min;
	private Double l1_range_max;
	private Double l1_insert_date;
	private Double l2_range_min;
	private Double l2_range_max;

	public ParameterFiltersData getFilterData() {
		return filterData;
	}

	public void setFilterData(ParameterFiltersData filterData) {
		this.filterData = filterData;
	}

	public Double getL1_range_min() {
		return l1_range_min;
	}

	public void setL1_range_min(Double l1_range_min) {
		this.l1_range_min = l1_range_min;
	}

	public Double getL1_range_max() {
		return l1_range_max;
	}

	public void setL1_range_max(Double l1_range_max) {
		this.l1_range_max = l1_range_max;
	}

	public Double getL1_insert_date() {
		return l1_insert_date;
	}

	public void setL1_insert_date(Double l1_insert_date) {
		this.l1_insert_date = l1_insert_date;
	}

	public Double getL2_range_min() {
		return l2_range_min;
	}

	public void setL2_range_min(Double l2_range_min) {
		this.l2_range_min = l2_range_min;
	}

	public Double getL2_range_max() {
		return l2_range_max;
	}

	public void setL2_range_max(Double l2_range_max) {
		this.l2_range_max = l2_range_max;
	}

	@Override
	public String toString() {
		return "PriceRange [filterData=" + filterData + ", l1_range_min=" + l1_range_min + ", l1_range_max="
				+ l1_range_max + ", l1_insert_date=" + l1_insert_date + ", l2_range_min=" + l2_range_min
				+ ", l2_range_max=" + l2_range_max + "]";
	}

}
