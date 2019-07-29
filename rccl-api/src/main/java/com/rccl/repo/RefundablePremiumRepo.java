package com.rccl.repo;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.dbutils.QueryExecutor;
import com.rccl.dbutils.RefundablePremiumDBUtil;
import com.rccl.dto.RefundablePremiumDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.RefundablePremium;
import com.rccl.processor.RefundablePremiumResultProcessor;

/**
 * The Class RefundablePremiumRepo.
 */
public class RefundablePremiumRepo {

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(RefundablePremiumRepo.class);

	/** The instance. */
	// creating instance of class
	public static RefundablePremiumRepo _instance = null;

	/**
	 * Gets the single instance of RefundablePremiumRepo.
	 * 
	 * @return single instance of RefundablePremiumRepo
	 */
	public static RefundablePremiumRepo getInstance() {
		if (_instance == null) {
			_instance = new RefundablePremiumRepo();
		}
		return _instance;
	}

	/**
	 * Gets the refundable premium data.
	 * 
	 * @param request the request
	 * @return the refundable premium data
	 */
	public List<RefundablePremiumDTO> getRefundablePremiumData(ParameterFiltersData request) {
		RefundablePremiumDBUtil refundablePremiumDBUtil = RefundablePremiumDBUtil.getInstance();
		QueryExecutor queryExecutor = QueryExecutor.getInstance();
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

	/**
	 * Update refundable premium data.
	 *
	 * @param request the request
	 * @return true, if successful
	 */
	public boolean updateRefundablePremiumData(RefundablePremium request) {
		RefundablePremiumDBUtil dbUtils = RefundablePremiumDBUtil.getInstance();
		QueryExecutor queryExecutor = QueryExecutor.getInstance();
		Integer status = 0;
		try {
			String updateRefundablePremiumQuery = dbUtils.updateRefundablePremiumDataQuery(request);
			logger.debug("updateRefundablePremiumData: " + updateRefundablePremiumQuery);
			status = queryExecutor.executeUpdate(updateRefundablePremiumQuery, null);
		} catch (Exception e) {
			logger.error("Error occured while executing updateRefundablePremiumQuery: " + e);
			throw e;
		}
		if (status == 0) {
			return false;
		} else {
			return true;
		}
	}

}
