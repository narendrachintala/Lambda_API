package com.rccl.repo;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.dbutils.QueryExecutor;
import com.rccl.dbutils.RefundablePremiumDBUtil;
import com.rccl.dto.RefundablePremiumDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.processor.RefundablePremiumResultProcessor;

/**
 * The Class RefundablePremiumRepo.
 */
public class RefundablePremiumRepo {
	
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(RefundablePremiumRepo.class);

	/**
	 * Gets the refundable premium data.
	 * @param request the request
	 * @return the refundable premium data
	 */
	public List<RefundablePremiumDTO> getRefundablePremiumData(ParameterFiltersData request) {
		RefundablePremiumDBUtil refundablePremiumDBUtil = RefundablePremiumDBUtil.getInstance();
		QueryExecutor queryExecutor = new QueryExecutor();
		List<RefundablePremiumDTO> list = new ArrayList<RefundablePremiumDTO>();
		try {
			String getRefundablePremiumQuery = refundablePremiumDBUtil.getRefundablePremiumQuery(request);
			RefundablePremiumResultProcessor processor = new RefundablePremiumResultProcessor();
			processor.setResult(list);
			queryExecutor.execute(getRefundablePremiumQuery, processor);
			list = processor.getResult();
		} catch (Exception e) {
			logger.error("Error occured in getRollingWindowData: " + e);
			throw e;
		}
		return list;
	}

}
