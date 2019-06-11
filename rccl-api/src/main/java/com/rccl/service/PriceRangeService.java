package com.rccl.service;

import java.util.List;
import java.util.Map;

import com.rccl.dto.FilterDataDTO;
import com.rccl.repo.PriceRangeRepo;

/**
 * 
 * @author narendra.chintala
 *
 */
public class PriceRangeService {
	
	public FilterDataDTO getPriceRangeData(Map<String, List<String>> map, String filter_column) {
		FilterDataDTO filterData = null;
		try {
			PriceRangeRepo repo = new PriceRangeRepo();
			filterData = repo.getFilterData(map, filter_column);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return filterData;
	}

}
