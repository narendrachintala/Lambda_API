package com.rccl.repo;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.rccl.dbutils.PriceRangeDBUtil;
import com.rccl.dto.PriceRangeDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.PriceRange;
import com.rccl.processor.PriceRangeResultProcessor;
import com.rccl.processor.QueryExecutor;
import com.rccl.utils.helper.RCCLException;

/**
 * 
 * @author narendra.chintala
 *
 */
public class PriceRangeRepo {

	/**
	 * Gets the price range data.
	 * 
	 * @param filterData   contains end user chosen filter criteria
	 * @param lambdaLogger
	 * @return the price range data
	 */
	public List<PriceRangeDTO> getPriceRangeData(ParameterFiltersData filterData, LambdaLogger logger) {

		PriceRangeDBUtil priceRangeDBUtil = PriceRangeDBUtil.getInstance();
		QueryExecutor queryExecutor = new QueryExecutor();
		List<PriceRangeDTO> priceData = new ArrayList<PriceRangeDTO>();

		try {
			String getPriceRangeQuery = priceRangeDBUtil.getPriceRangeDataQuery(filterData);
			PriceRangeResultProcessor processor = new PriceRangeResultProcessor();
			processor.setResult(priceData);
			queryExecutor.execute(getPriceRangeQuery, logger, processor);
			priceData = processor.getResult();
		} catch (Exception e) {
			logger.log(e.getMessage());
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
	public boolean updatePriceRangeData(PriceRange priceRangeReq, LambdaLogger logger) {
		PriceRangeDBUtil priceRangeDBUtil = PriceRangeDBUtil.getInstance();
		Integer status = 0;
		QueryExecutor queryExecutor = new QueryExecutor();
		try {
			/* generates update query for price range table */
			String updatePriceRangeQuery = priceRangeDBUtil.generateUpdatePriceRangeDataQuery(priceRangeReq);
			System.out.println("updatePriceRangeQuery: " + updatePriceRangeQuery);
			status = queryExecutor.executeUpdate(updatePriceRangeQuery, null, logger);

		} catch (Exception e) {
			// logger.log("Error occured while executing updatePriceRangeData: " + e);
			throw new RCCLException(
					"Error while executing SQL query in com.rccl.repo.PriceRangeRepo.updatePriceRangeData(PriceRange, LambdaLogger): ",
					e);
		}
		if (status == 0) {
			return false;
		} else {
			return true;
		}
	}

}
