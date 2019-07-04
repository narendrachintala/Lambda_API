package com.rccl.dbutils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.ParameterFiltersData;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.helper.FilterDataHelper;

/**
 * The Class RefundablePremiumDBUtil.
 */
public class RefundablePremiumDBUtil {

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(RefundablePremiumDBUtil.class);

	// Creates instance
	public static RefundablePremiumDBUtil _instance = null;

	// Read properties from configuration file
	ConfigUtil configInst = ConfigUtil.getInstance();

	/**
	 * Gets the single instance of RefundablePremiumDBUtil.
	 * @return single instance of RefundablePremiumDBUtil
	 */
	public static RefundablePremiumDBUtil getInstance() {
		if (_instance == null) {
			_instance = new RefundablePremiumDBUtil();
		}
		return _instance;
	}

	/**
	 * Gets the refundable premium query.
	 * @param request the request
	 * @return the refundable premium query
	 */
	public String getRefundablePremiumQuery(ParameterFiltersData request) {
		StringBuffer queryBuffer = new StringBuffer();
		String getRefundablePremiumQuery = new String(configInst.getRefundablePremiumData());
		try {
			System.out.println("reading query from config:" + getRefundablePremiumQuery);
			logger.debug("reading query from config:" + getRefundablePremiumQuery);
			FilterDataHelper filterDataHelper = new FilterDataHelper();
			String whereCondition = filterDataHelper.generateFilterCondition(request, queryBuffer);
			if (whereCondition.equals("")) {
				getRefundablePremiumQuery = getRefundablePremiumQuery.replace(RCCLConstants.WHERE_CONDITION_Q, "1=1");
			} else {
				getRefundablePremiumQuery = getRefundablePremiumQuery.replace(RCCLConstants.WHERE_CONDITION_Q, whereCondition);
			}
			System.out.println("Final query for GET API refundable premium:" + getRefundablePremiumQuery);
			logger.debug("Final query for GET API refundable premium:" + getRefundablePremiumQuery);
		} catch (Exception e) {
			logger.error("Error occured in getRefundablePremiumQuery: " + e);
			throw e;
		}

		return getRefundablePremiumQuery;
	}

}
