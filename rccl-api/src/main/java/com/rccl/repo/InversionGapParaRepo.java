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

/**
 * The Class InversionGapParaRepo.
 */
public class InversionGapParaRepo {
	
	/** The Constant logger. */
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(InversionGapParaRepo.class);

	
	/**
	 * Gets the invesion gap para.
	 *
	 * @param filterData the filter data
	 * @return the invesion gap para
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
			logger.error("Error occured in getinversionQuery: " + e);
			throw e;
		}

		return inversionData;

	}

}