package com.rccl.repo;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.dbutils.PauseParaDBUtils;
import com.rccl.dbutils.QueryExecutor;
import com.rccl.dto.PauseParaDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.PausePara;
import com.rccl.processor.PauseParaResultProcessor;

/**
 * The Class PauseParaDataRepo.
 */
public class PauseParaDataRepo {

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(PauseParaDataRepo.class);

	/**
	 * Gets the pause para.
	 * 
	 * @param filterData the filter data
	 * @param logger     the logger
	 * @return returns list of records based on filter condition
	 */
	// This method is used to fetch results from DB
	public List<PauseParaDTO> getPausePara(ParameterFiltersData filterData) {
		List<PauseParaDTO> PauseParaData = new ArrayList<PauseParaDTO>();
		QueryExecutor queryExecutor = new QueryExecutor();
		PauseParaDBUtils dbUtils = PauseParaDBUtils.getInstance();
		try {
			String getPauseParaQuery = dbUtils.getPauseParaDataQuery(filterData, logger);
			PauseParaResultProcessor processor = new PauseParaResultProcessor();
			processor.setResult(PauseParaData);
			queryExecutor.execute(getPauseParaQuery, processor);
			PauseParaData = processor.getResult();
		} catch (Exception e) {
			logger.error("Error occured in getPausePara: " + e);
			throw e;
		}
		return PauseParaData;
	}

	/**
	 * Update pause para data.
	 * 
	 * @param request the request
	 * @return true, if successful
	 */
	public boolean updatePauseParaData(PausePara request) {
		PauseParaDBUtils dbUtils = PauseParaDBUtils.getInstance();
		QueryExecutor queryExecutor = new QueryExecutor();
		Integer status = 0;
		try {
			String updatePauseParaQuery = dbUtils.updatePauseParaDataQuery(request);
			status = queryExecutor.executeUpdate(updatePauseParaQuery, null);
		} catch (Exception e) {
			logger.error("Error occured in updatePauseParaData: " + e);
			throw e;
		}
		if (status == 0) {
			return false;
		} else {
			return true;
		}
	}
}
