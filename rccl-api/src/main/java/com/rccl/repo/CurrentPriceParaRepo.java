package com.rccl.repo;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.dbutils.CurrentPriceParaDBUtil;
import com.rccl.dbutils.QueryExecutor;
import com.rccl.dto.CurrentPriceParaDTO;
import com.rccl.model.CurrentPricePara;
import com.rccl.model.ParameterFiltersData;
import com.rccl.processor.CurrentPriceResultProcessor;

/**
 * The Class CurrentPriceParaRepo.
 */
public class CurrentPriceParaRepo {

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(CurrentPriceParaRepo.class);

	/** The instance. */
	// creating instance of class
	public static CurrentPriceParaRepo _instance = null;

	/**
	 * Gets the single instance of CurrentPriceParaRepo.
	 * 
	 * @return single instance of CurrentPriceParaRepo
	 */
	public static CurrentPriceParaRepo getInstance() {
		if (_instance == null) {
			_instance = new CurrentPriceParaRepo();
		}
		return _instance;
	}

	/**
	 * Gets the current price para.
	 * 
	 * @param filterData   contains end user chosen filter criteria
	 * @param lambdaLogger
	 * @return the current price para
	 */
	public List<CurrentPriceParaDTO> getCurrentPriceData(ParameterFiltersData filterData) {
		CurrentPriceParaDBUtil currentPriceParaDBUtil = CurrentPriceParaDBUtil.getInstance();
		QueryExecutor queryExecutor = QueryExecutor.getInstance();
		List<CurrentPriceParaDTO> currentPriceParaData = new ArrayList<CurrentPriceParaDTO>();
		try {
			String getCurrentPriceParaQuery = currentPriceParaDBUtil.getCurrentPriceDataQuery(filterData);
			CurrentPriceResultProcessor processor = new CurrentPriceResultProcessor();
			processor.setResult(currentPriceParaData);
			logger.debug("Query to GET current price data : " + getCurrentPriceParaQuery);
			queryExecutor.execute(getCurrentPriceParaQuery, processor);
			currentPriceParaData = processor.getResult();
		} catch (Exception e) {
			logger.error("Error occured in getCurrentPriceData: " + e);
			throw e;
		}
		return currentPriceParaData;
	}

	/**
	 * Update current price para data.
	 * 
	 * @param currentPriceParaReq the price range req
	 * @param logger
	 * @return true, if successful
	 */
	public boolean updateCurrentPriceData(CurrentPricePara currentPriceParaReq) {
		CurrentPriceParaDBUtil currentPriceParaDBUtil = CurrentPriceParaDBUtil.getInstance();
		Integer status = 0;
		QueryExecutor queryExecutor = QueryExecutor.getInstance();
		try {
			/* generates update query for price range table */
			String updateCurrentPriceQuery = currentPriceParaDBUtil
					.generateUpdateCurrentPriceDataQuery(currentPriceParaReq);
			logger.debug("updateCurrentPriceQuery: " + updateCurrentPriceQuery);
			status = queryExecutor.executeUpdate(updateCurrentPriceQuery, null);

		} catch (Exception e) {
			logger.error("Error occured while executing updateCurrentPriceData : " + e);
			throw e;
		}
		if (status == 0) {
			return false;
		} else {
			return true;
		}
	}

}