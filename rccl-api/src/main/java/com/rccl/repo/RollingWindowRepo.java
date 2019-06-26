package com.rccl.repo;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import com.rccl.dbutils.RollingWindowDBUtil;
import com.rccl.dto.RollingWindowDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.RollingWindow;
import com.rccl.processor.QueryExecutor;
import com.rccl.processor.RollingWindowResultProcessor;

/**
 * The Class RollingWindowRepo.
 */
public class RollingWindowRepo {

	/**
	 * Gets the rolling window data.
	 * @param request the request
	 * @return the rolling window data
	 */
	// This method is used to fetch results from DB
	public List<RollingWindowDTO> getRollingWindowData(ParameterFiltersData request, Logger logger) {
		RollingWindowDBUtil rollingWindowDBUtil = RollingWindowDBUtil.getInstance();
		QueryExecutor queryExecutor = new QueryExecutor();
		List<RollingWindowDTO> list = new ArrayList<RollingWindowDTO>();
		try {
			String getRollingWindowQuery = rollingWindowDBUtil.getRollingWindowQuery(request, logger);
			RollingWindowResultProcessor processor = new RollingWindowResultProcessor();
			processor.setResult(list);
			queryExecutor.execute(getRollingWindowQuery, logger, processor);
			list = processor.getResult();
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return list;
	}
	
	/**
	 * Update rolling window data.
	 * @param request the request
	 * @return true, if successful
	 */
	public boolean updateRollingWindowData(RollingWindow request, Logger logger) {
		RollingWindowDBUtil dbUtils = RollingWindowDBUtil.getInstance();
		QueryExecutor queryExecutor = new QueryExecutor();
		Integer status = 0;
		try {
			String updateRollingWindowQuery = dbUtils.updateRollingWindowDataQuery(request, logger);
			status = queryExecutor.executeUpdate(updateRollingWindowQuery, null, logger);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		if (status == 0) {
			return false;
		} else {
			return true;
		}
	}

}
