package com.rccl.dbutils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.CurrencyGapPara;
import com.rccl.model.ParameterFiltersData;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.helper.CurrencyGapDataHelper;
import com.rccl.utils.helper.FilterDataHelper;

/**
 * The Class CurrencyGapDBUtil.
 * 
 * @author chandrabhan.birla
 */
public class CurrencyGapDBUtil {

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(CurrencyGapDBUtil.class);

	// Creates instance
	public static CurrencyGapDBUtil _instance = null;

	// Read properties from configuration file
	ConfigUtil configInst = ConfigUtil.getInstance();

	/**
	 * Gets the single instance of CurrencyGapDBUtil.
	 *
	 * @return single instance of CurrencyGapDBUtil
	 */
	public static CurrencyGapDBUtil getInstance() {
		if (_instance == null) {
			_instance = new CurrencyGapDBUtil();
		}
		return _instance;
	}

	/**
	 * Gets the currency gap data query.
	 *
	 * @param filterDataReq the filter data req
	 * @return the currency gap data query
	 */
	public String getCurrencyGapDataQuery(ParameterFiltersData filterDataReq) {
		StringBuffer queryBuffer = new StringBuffer();
		String getCurrencyGapQuery = new String(configInst.getCurrencyGapData());
		try {
			logger.debug("Reading query from config:" + getCurrencyGapQuery);
			FilterDataHelper filterDataHelper = new FilterDataHelper();
			String whereCondition = filterDataHelper.generateFilterCondition(filterDataReq, queryBuffer);
			if (whereCondition.equals("")) {
				getCurrencyGapQuery = getCurrencyGapQuery.replace(RCCLConstants.WHERE_CONDITION_Q, "1=1");
			} else {
				getCurrencyGapQuery = getCurrencyGapQuery.replace(RCCLConstants.WHERE_CONDITION_Q, whereCondition);
			}
			logger.debug("Final query for GET API current price para :" + getCurrencyGapQuery);
		} catch (Exception e) {
			logger.error("Error occured in getCurrencyGapQuery: " + e);
			throw e;
		}
		return getCurrencyGapQuery;
	}

	/**
	 * Update currecy gap query.
	 *
	 * @param currencyGapParaReq the currency gap para req
	 * @return the string
	 */
	public String updateCurrecyGapQuery(CurrencyGapPara currencyGapParaReq) {
		StringBuffer queryBuffer = new StringBuffer();
		String updateCurrencyGapQuery = new String(configInst.updateCurrencyGapData());
		try {
			logger.debug("reading query from config:" + updateCurrencyGapQuery);
			FilterDataHelper filterDataHelper = new FilterDataHelper();
			String filterWhereCondition = filterDataHelper.generateFilterCondition(currencyGapParaReq.getFiltersData(),
					queryBuffer);
			CurrencyGapDataHelper currencyGapDataHelper = CurrencyGapDataHelper.getInstance();
			String setterCondition = currencyGapDataHelper.generateSetterCondition(currencyGapParaReq,
					new StringBuffer());
			if (setterCondition != "") {
				updateCurrencyGapQuery = updateCurrencyGapQuery.replace(RCCLConstants.SETTER_COLUMNS_Q,
						setterCondition);
			}
			if (filterWhereCondition.equals("")) {
				updateCurrencyGapQuery = updateCurrencyGapQuery.replace(RCCLConstants.WHERE_CONDITION_Q, "1=1");
			} else {
				updateCurrencyGapQuery = updateCurrencyGapQuery.replace(RCCLConstants.WHERE_CONDITION_Q,
						filterWhereCondition);
			}
			logger.debug("Final query for POST API currency gap para :" + updateCurrencyGapQuery);
		} catch (Exception e) {
			logger.error("Error occured in updateCurrencyGapQuery: " + e);
			throw e;
		}
		return updateCurrencyGapQuery;
	}

}
