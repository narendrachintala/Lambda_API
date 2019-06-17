package com.rccl.dto;

import java.util.List;

/**
 * 
 * @author narendra.chintala
 *
 */
public class FilterDataDTO {

	List<String> filterData;

	public List<String> getFilterData() {
		return filterData;
	}

	public void setFilterData(List<String> filterData) {
		this.filterData = filterData;
	}

	@Override
	public String toString() {
		return "FilterDataDTO [filterData=" + filterData + "]";
	}

}
