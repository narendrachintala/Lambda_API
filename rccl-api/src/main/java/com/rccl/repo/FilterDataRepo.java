package com.rccl.repo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.dbutils.FiltersDBUtil;
import com.rccl.dbutils.QueryExecutor;
import com.rccl.dto.FilterDataDTO;
import com.rccl.model.FiltersData;
import com.rccl.processor.FilterDataProcessor;

/**
 * The Class FilterDataRepo.
 *
 * @author narendra.chintala
 */
public class FilterDataRepo {

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(FilterDataRepo.class);
	
	/** The instance. */
	// creating instance of class
	public static FilterDataRepo _instance = null;

	/**
	 * Gets the single instance of FilterDataRepo.
	 * 
	 * @return single instance of FilterDataRepo
	 */
	public static FilterDataRepo getInstance() {
		if (_instance == null) {
			_instance = new FilterDataRepo();
		}
		return _instance;
	}

	/**
	 * Gets the filter data.
	 *
	 * @param filterData    the filter data
	 * @param filter_column the filter column
	 * @param logger        the logger
	 * @return the filter data
	 */
	public FilterDataDTO getFilterData(FiltersData filterData, String filter_column) {
		FilterDataDTO results = new FilterDataDTO();
		FiltersDBUtil dbUtils = FiltersDBUtil.getInstance();
		QueryExecutor executor = QueryExecutor.getInstance();
		try {
			String filterQuery = dbUtils.generateFilterQuery(filterData, filter_column);
			FilterDataProcessor dataProcessor = new FilterDataProcessor();
			executor.execute(filterQuery, dataProcessor);
			results.setFilterData(dataProcessor.getResult());
		} catch (Exception e) {
			logger.error("Exception occured while executing getFilterData", e);
			throw e;
		}
		return results;

	}

}
