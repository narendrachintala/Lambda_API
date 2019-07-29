package com.rccl.repo;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.dbutils.CurrencyGapDBUtil;
import com.rccl.dbutils.QueryExecutor;
import com.rccl.dto.CurrencyGapParaDTO;
import com.rccl.model.CurrencyGapPara;
import com.rccl.model.ParameterFiltersData;
import com.rccl.processor.CurrencyGapResultProcessor;

/**
 * The Class CurrencyGapParaRepo.
 * 
 * @author chandrabhan.birla
 *
 */
public class CurrencyGapParaRepo {

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(CurrencyGapParaRepo.class);
	
	/** The instance. */
	// creating instance of class
	public static CurrencyGapParaRepo _instance = null;

	/**
	 * Gets the single instance of CurrencyGapParaRepo.
	 * 
	 * @return single instance of CurrencyGapParaRepo
	 */
	public static CurrencyGapParaRepo getInstance() {
		if (_instance == null) {
			_instance = new CurrencyGapParaRepo();
		}
		return _instance;
	}

	/**
	 * Gets the currency gap data.
	 *
	 * @param filterDataReq the filter data req
	 * @return the currency gap data
	 */
	public List<CurrencyGapParaDTO> getCurrencyGapData(ParameterFiltersData filterDataReq) {
		List<CurrencyGapParaDTO> currecyGapData = new ArrayList<CurrencyGapParaDTO>();
		CurrencyGapDBUtil currencyGapdbUtil = CurrencyGapDBUtil.getInstance();
		QueryExecutor queryExecutor = QueryExecutor.getInstance();
		try {
			String getCurrencyGapQuery = currencyGapdbUtil.getCurrencyGapDataQuery(filterDataReq);
			CurrencyGapResultProcessor processor = new CurrencyGapResultProcessor();
			processor.setResult(currecyGapData);
			logger.debug("Query to GET currency gap data : " + getCurrencyGapQuery);
			queryExecutor.execute(getCurrencyGapQuery, processor);
			currecyGapData = processor.getResult();
		} catch (Exception e) {
			logger.error("Error occured in getCurrencyGapData: " + e);
			throw e;
		}
		return currecyGapData;
	}

	/**
	 * Update currency gap data.
	 *
	 * @param currencyGapParaReq the currency gap para req
	 * @return true, if successful
	 */
	public boolean updateCurrencyGapData(CurrencyGapPara currencyGapParaReq) {
		CurrencyGapDBUtil currencyGapDBUtil = CurrencyGapDBUtil.getInstance();
		Integer status = 0;
		QueryExecutor queryExecutor = QueryExecutor.getInstance();
		try {
			/* generates update query for CurrencyGapPara table */
			String updateCurrencyGapQuery = currencyGapDBUtil.updateCurrecyGapQuery(currencyGapParaReq);
			logger.debug("updateCurrencyGapQuery: " + updateCurrencyGapQuery);
			status = queryExecutor.executeUpdate(updateCurrencyGapQuery, null);

		} catch (Exception e) {
			logger.error("Error occured while executing updateCurrencyGapData : " + e);
			throw e;
		}
		if (status == 0) {
			return false;
		} else {
			return true;
		}
	}
}
