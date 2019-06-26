package com.rccl.service;

import org.apache.logging.log4j.Logger;

import com.rccl.dto.FilterDataDTO;
import com.rccl.model.FiltersData;
import com.rccl.repo.FilterDataRepo;
import com.rccl.utils.helper.RCCLException;

/**
 * 
 * @author narendra.chintala
 *
 */
public class FilterDataService {

	public FilterDataDTO getFilterData(FiltersData request, String filter_column, Logger logger) {
		FilterDataDTO filterData = null;

		try {
			FilterDataRepo repo = new FilterDataRepo();
			filterData = repo.getFilterData(request, filter_column, logger);

		} catch (Exception e) {
			throw new RCCLException("Error occured while executing getFilterData", e);
		}

		return filterData;
	}
}
