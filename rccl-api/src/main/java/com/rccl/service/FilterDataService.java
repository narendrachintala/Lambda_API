package com.rccl.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.dto.FilterDataDTO;
import com.rccl.model.FiltersData;
import com.rccl.repo.FilterDataRepo;

// TODO: Auto-generated Javadoc
/**
 * The Class FilterDataService.
 *
 * @author narendra.chintala
 */
public class FilterDataService {
	
	// Initialize the Log4j logger.
		static final Logger logger = LogManager.getLogger(FilterDataService.class);

	/**
	 * Gets the filter data.
	 *
	 * @param request the request
	 * @param filter_column the filter column
	 * @param logger the logger
	 * @return the filter data
	 */
	public FilterDataDTO getFilterData(FiltersData request, String filter_column) {
		FilterDataDTO filterData = null;

		try {
			FilterDataRepo repo = new FilterDataRepo();
			filterData = repo.getFilterData(request, filter_column);

		} catch (Exception e) {
			logger.error("Error occurred while invoking getFilterData: " + e);
			throw e;
		}

		return filterData;
	}
}
