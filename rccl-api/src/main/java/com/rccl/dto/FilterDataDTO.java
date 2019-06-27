package com.rccl.dto;

import java.util.List;

/**
 * The Class FilterDataDTO.
 *
 * @author narendra.chintala
 */
public class FilterDataDTO {

	/** The filter data. */
	List<String> filterData;

	/**
	 * Gets the filter data.
	 *
	 * @return the filter data
	 */
	public List<String> getFilterData() {
		return filterData;
	}

	/**
	 * Sets the filter data.
	 *
	 * @param filterData the new filter data
	 */
	public void setFilterData(List<String> filterData) {
		this.filterData = filterData;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FilterDataDTO [filterData=" + filterData + "]";
	}

}
