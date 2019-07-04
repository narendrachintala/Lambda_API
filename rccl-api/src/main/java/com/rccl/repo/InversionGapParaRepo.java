package com.rccl.repo;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.rccl.dbutils.InversionGapParaUtils;
import com.rccl.dbutils.QueryExecutor;
import com.rccl.dto.InversionGapsParaDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.processor.InversionGapResultProcessor;

public class InversionGapParaRepo {
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(InversionGapParaRepo.class);

	/**
	 * Gets the price range data.
	 * 
	 * @param filterData   contains end user chosen filter criteria
	 * @param lambdaLogger
	 * @return the price range data
	 */
	public List<InversionGapsParaDTO> getInvesionGapPara(ParameterFiltersData filterData) {

		InversionGapParaUtils inversionGapParaUtils = InversionGapParaUtils.getInstance();
		QueryExecutor queryExecutor = new QueryExecutor();
		List<InversionGapsParaDTO> inversionData = new ArrayList<InversionGapsParaDTO>();

		try {
			String getinversionQuery = inversionGapParaUtils.getInversionGapParaDataQuery(filterData);
			InversionGapResultProcessor processor = new InversionGapResultProcessor();
			processor.setResult(inversionData);
			queryExecutor.execute(getinversionQuery, processor);
			inversionData = processor.getResult();
		} catch (Exception e) {
			//logger.error("Error occured in getPriceRangeData: " + e);
			throw e;
		}

		return inversionData;

	}

}
