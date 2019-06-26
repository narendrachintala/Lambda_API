package com.rccl.repo;

import org.apache.logging.log4j.Logger;

import com.rccl.dbutils.FiltersDBUtil;
import com.rccl.dto.FilterDataDTO;
import com.rccl.model.FiltersData;
import com.rccl.processor.FilterDataProcessor;
import com.rccl.processor.QueryExecutor;
import com.rccl.utils.helper.RCCLException;

/**
 * 
 * @author narendra.chintala
 *
 */
public class FilterDataRepo {

	public FilterDataDTO getFilterData(FiltersData filterData, String filter_column, Logger logger) {
		FilterDataDTO results = new FilterDataDTO();
		FiltersDBUtil dbUtils = FiltersDBUtil.getInstance();
		QueryExecutor executor = new QueryExecutor();
		try {
			String filterQuery = dbUtils.generateFilterQuery(filterData, filter_column);
			FilterDataProcessor dataProcessor = new FilterDataProcessor();
			executor.execute(filterQuery, logger, dataProcessor);
			results.setFilterData(dataProcessor.getResult());
		} catch (Exception e) {
			throw new RCCLException("Exception occured while executing getFilterData", e);
		}
		return results;

	}

}
