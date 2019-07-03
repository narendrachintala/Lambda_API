package com.rccl.repo;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import com.rccl.dbutils.CurrentPriceParaDBUtil;
import com.rccl.dbutils.QueryExecutor;
import com.rccl.dto.CurrentPriceParaDTO;
import com.rccl.model.CurrentPricePara;
import com.rccl.model.ParameterFiltersData;
import com.rccl.processor.CurrentPriceResultProcessor;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;

/**
 * 
 * @author chandrabhan.birla
 *
 */

public class CurrentPriceParaRepo {

	/**
	 * Gets the current price para.
	 * 
	 * @param filterData   contains end user chosen filter criteria
	 * @param lambdaLogger
	 * @return the current price para
	 */
	public List<CurrentPriceParaDTO> getCurrentPriceData(ParameterFiltersData filterData, Logger logger) {

		CurrentPriceParaDBUtil currentPriceParaDBUtil = CurrentPriceParaDBUtil.getInstance();
		QueryExecutor queryExecutor = new QueryExecutor();
		List<CurrentPriceParaDTO> currentPriceParaData = new ArrayList<CurrentPriceParaDTO>();

		try {
			String getCurrentPriceParaQuery = currentPriceParaDBUtil.getCurrentPriceDataQuery(filterData);
			CurrentPriceResultProcessor processor = new CurrentPriceResultProcessor();
			processor.setResult(currentPriceParaData);
			queryExecutor.execute(getCurrentPriceParaQuery, processor);
			currentPriceParaData = processor.getResult();
		} catch (Exception e) {
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
	public boolean updateCurrentPriceData(CurrentPricePara currentPriceParaReq, Logger logger) {
		CurrentPriceParaDBUtil currentPriceParaDBUtil = CurrentPriceParaDBUtil.getInstance();
		Integer status = 0;
		QueryExecutor queryExecutor = new QueryExecutor();
		try {
			/* generates update query for price range table */
			String updateCurrentPriceQuery = currentPriceParaDBUtil.generateUpdateCurrentPriceDataQuery(currentPriceParaReq);
			logger.debug("updateCurrentPriceQuery: " + updateCurrentPriceQuery);
			String table_name = ConfigUtil.getInstance().getTableName(RCCLConstants.CURRENT_PRICE_PARA);
			status = queryExecutor.executeUpdate(updateCurrentPriceQuery, null);

		} catch (Exception e) {
			// logger.log("Error occured while executing updatePriceRangeData: " + e);
			throw e;
		}
		if (status == 0) {
			return false;
		} else {
			return true;
		}
	}

}