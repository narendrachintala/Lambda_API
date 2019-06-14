package com.rccl.service;

import java.util.List;
import java.util.Map;

import com.rccl.model.FilterDataDTO;
import com.rccl.repo.FilterDataRepo;

/**
 * 
 * @author narendra.chintala
 *
 */
public class FilterDataService {

	public FilterDataDTO getFilterData(Map<String, List<String>> map, String filter_column) {
		FilterDataDTO filterData = null;
		try {
			FilterDataRepo repo = new FilterDataRepo();
			filterData = repo.getFilterData(map, filter_column);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return filterData;
	}
}
