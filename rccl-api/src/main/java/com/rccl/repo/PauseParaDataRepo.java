package com.rccl.repo;


import java.util.ArrayList;
import java.util.List;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.rccl.dbutils.PauseParaDBUtils;
import com.rccl.dto.PauseParaDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.processor.PauseParaResultProcessor;
import com.rccl.processor.QueryExecutor;


public class PauseParaDataRepo {
	public List<PauseParaDTO> getPausePara(ParameterFiltersData filterData,LambdaLogger logger) {
		
		List<PauseParaDTO> PauseParaData = new ArrayList<PauseParaDTO>();
		QueryExecutor queryExecutor = new QueryExecutor();
		PauseParaDBUtils dbUtils = PauseParaDBUtils.getInstance();
		
		try {
			String getPauseParaQuery = dbUtils.getPauseParaDataQuery(filterData);
			PauseParaResultProcessor processor = new PauseParaResultProcessor();
			processor.setResult(PauseParaData);
			queryExecutor.execute(getPauseParaQuery, logger, processor);
			PauseParaData = processor.getResult();
			

		} catch (Exception e) {
			logger.log(e.getMessage());
			throw e;
		}

		return PauseParaData;

	}

}
	