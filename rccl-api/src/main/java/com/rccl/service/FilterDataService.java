package com.rccl.service;

import org.apache.logging.log4j.Logger;

import com.rccl.dto.FilterDataDTO;
import com.rccl.model.FiltersData;
import com.rccl.repo.FilterDataRepo;
import com.rccl.utils.helper.RCCLException;

// TODO: Auto-generated Javadoc
/**
 * The Class FilterDataService.
 *
 * @author narendra.chintala
 */
public class FilterDataService {

	/**
	 * Gets the filter data.
	 *
	 * @param request the request
	 * @param filter_column the filter column
	 * @param logger the logger
	 * @return the filter data
	 */
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
