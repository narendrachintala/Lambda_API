package com.rccl.model;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.rccl.testdata.FiltersData;

public class PriceRange {

	private Map<String, List<String>> filters;
	private Double l1_range_min;
	private Double l1_range_max;
	private Double l1_insert_date;
	private Double l2_range_min;
	private Double l2_range_max;

	public Map<String, List<String>> getFilters() {
		return filters;
	}

	public void setFilters(Map<String, List<String>> filters) {
		this.filters = filters;
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

	public static void main(String[] args) {

		PriceRange priceRangeDTO = new PriceRange();
		FiltersData filtersData = new FiltersData();
		priceRangeDTO.setFilters(filtersData.getRequestData());
		priceRangeDTO.setL1_range_max(1d);
		priceRangeDTO.setL1_range_min(-1d);
		priceRangeDTO.setL2_range_max(2d);
		priceRangeDTO.setL2_range_min(-2d);

		Gson gson = new Gson();
		System.out.println(gson.toJson(priceRangeDTO));

	}

}
