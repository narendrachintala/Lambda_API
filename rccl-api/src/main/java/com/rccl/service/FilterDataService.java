package com.rccl.service;

import com.rccl.dto.FilterDataDTO;
import com.rccl.model.FiltersData;
import com.rccl.repo.FilterDataRepo;

/**
 * 
 * @author narendra.chintala
 *
 */
public class FilterDataService {

	public FilterDataDTO getFilterData(FiltersData request, String filter_column) {
		FilterDataDTO filterData = null;
		
		  try { FilterDataRepo repo = new FilterDataRepo(); filterData =
		  repo.getFilterData(request, filter_column);
		  
		  } catch (Exception e) { e.printStackTrace(); }
		 
		return filterData;
	}
}
