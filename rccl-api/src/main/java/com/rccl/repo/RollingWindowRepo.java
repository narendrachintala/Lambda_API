package com.rccl.repo;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.dbutils.QueryExecutor;
import com.rccl.dbutils.RollingWindowDBUtil;
import com.rccl.dto.RollingWindowDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.RollingWindow;
import com.rccl.processor.RollingWindowResultProcessor;

/**
 * The Class RollingWindowRepo.
 */
public class RollingWindowRepo {

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(RollingWindowRepo.class);

	/**
	 * Gets the rolling window data.
	 * 
	 * @param request the request
	 * @param logger  the logger
	 * @return the rolling window data
	 */
	// This method is used to fetch results from DB
	public List<RollingWindowDTO> getRollingWindowData(ParameterFiltersData request) {
		RollingWindowDBUtil rollingWindowDBUtil = RollingWindowDBUtil.getInstance();
		QueryExecutor queryExecutor = new QueryExecutor();
		List<RollingWindowDTO> list = new ArrayList<RollingWindowDTO>();
		try {
			String getRollingWindowQuery = rollingWindowDBUtil.getRollingWindowQuery(request);
			RollingWindowResultProcessor processor = new RollingWindowResultProcessor();
			processor.setResult(list);
			queryExecutor.execute(getRollingWindowQuery, processor);
			list = processor.getResult();
		} catch (Exception e) {
			logger.error("Error occured in getRollingWindowData: " + e);
			throw e;
		}
		return list;
	}

	/**
	 * Update rolling window data.
	 * 
	 * @param request the request
	 * @param logger  the logger
	 * @return true, if successful
	 */
	public boolean updateRollingWindowData(RollingWindow request) {
		RollingWindowDBUtil dbUtils = RollingWindowDBUtil.getInstance();
		QueryExecutor queryExecutor = new QueryExecutor();
		Integer status = 0;
		try {
			String updateRollingWindowQuery = dbUtils.updateRollingWindowDataQuery(request);
			logger.debug("updatePriceRangeQuery: " + updateRollingWindowQuery);
			status = queryExecutor.executeUpdate(updateRollingWindowQuery, null);
		} catch (Exception e) {
			logger.error("Error occured while executing updateRollingWindowData: " + e);
			throw e;
		}
		if (status == 0) {
			return false;
		} else {
			return true;
		}
	}
}
