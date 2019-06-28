package com.rccl.repo;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import com.rccl.dbutils.PauseParaDBUtils;
import com.rccl.dto.PauseParaDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.PausePara;
import com.rccl.processor.PauseParaResultProcessor;
import com.rccl.processor.QueryExecutor;

/**
 * The Class PauseParaDataRepo.
 */
public class PauseParaDataRepo {
	
	/**
	 * Gets the pause para.
	 * @param filterData the filter data
	 * @param logger the logger
	 * @return returns list of records based on filter condition
	 */
	// This method is used to fetch results from DB
	public List<PauseParaDTO> getPausePara(ParameterFiltersData filterData,Logger logger) {
		List<PauseParaDTO> PauseParaData = new ArrayList<PauseParaDTO>();
		QueryExecutor queryExecutor = new QueryExecutor();
		PauseParaDBUtils dbUtils = PauseParaDBUtils.getInstance();
		try {
			String getPauseParaQuery = dbUtils.getPauseParaDataQuery(filterData, logger);
			PauseParaResultProcessor processor = new PauseParaResultProcessor();
			processor.setResult(PauseParaData);
			queryExecutor.execute(getPauseParaQuery, logger, processor);
			PauseParaData = processor.getResult();
		} catch (Exception e) {
			throw e;
		}
		return PauseParaData;
	}
	
	/**
	 * Update pause para data.
	 * @param request the request
	 * @param logger the logger
	 * @return true, if successful
	 */
	public boolean updatePauseParaData(PausePara request, Logger logger ) {
		PauseParaDBUtils dbUtils = PauseParaDBUtils.getInstance();
		QueryExecutor queryExecutor = new QueryExecutor();
		Integer status = 0;
		try {
			String updatePauseParaQuery = dbUtils.updatePauseParaDataQuery(request, logger );
			status = queryExecutor.executeUpdate(updatePauseParaQuery, null, logger );
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
	