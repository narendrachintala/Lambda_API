package com.rccl.repo;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.dbutils.PriceRangeDBUtil;
import com.rccl.dbutils.QueryExecutor;
import com.rccl.dto.PriceRangeDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.PriceRange;
import com.rccl.processor.PriceRangeResultProcessor;

/**
 * 
 * @author narendra.chintala
 *
 */
public class PriceRangeRepo {

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(PriceRangeRepo.class);

	/**
	 * Gets the price range data.
	 * 
	 * @param filterData   contains end user chosen filter criteria
	 * @param lambdaLogger
	 * @return the price range data
	 */
	public List<PriceRangeDTO> getPriceRangeData(ParameterFiltersData filterData) {

		PriceRangeDBUtil priceRangeDBUtil = PriceRangeDBUtil.getInstance();
		QueryExecutor queryExecutor = new QueryExecutor();
		List<PriceRangeDTO> priceData = new ArrayList<PriceRangeDTO>();

		try {
			String getPriceRangeQuery = priceRangeDBUtil.getPriceRangeDataQuery(filterData);
			PriceRangeResultProcessor processor = new PriceRangeResultProcessor();
			processor.setResult(priceData);
			queryExecutor.execute(getPriceRangeQuery, processor);
			priceData = processor.getResult();
		} catch (Exception e) {
			logger.error("Error occured in getPriceRangeData: " + e);
			throw e;
		}

		return priceData;

	}

	/**
	 * Update price range data.
	 * 
	 * @param priceRangeReq the price range req
	 * @param logger
	 * @return true, if successful
	 */
	public boolean updatePriceRangeData(PriceRange priceRangeReq) {
		PriceRangeDBUtil priceRangeDBUtil = PriceRangeDBUtil.getInstance();
		Integer status = 0;
		QueryExecutor queryExecutor = new QueryExecutor();
		try {
			/* generates update query for price range table */
			String updatePriceRangeQuery = priceRangeDBUtil.generateUpdatePriceRangeDataQuery(priceRangeReq);
			logger.debug("updatePriceRangeQuery: " + updatePriceRangeQuery);
			status = queryExecutor.executeUpdate(updatePriceRangeQuery, null);

		} catch (Exception e) {
			logger.error("Error occured while executing updatePriceRangeData: " + e);
			throw e;
		}
		if (status == 0) {
			return false;
		} else {
			return true;
		}
	}

}
