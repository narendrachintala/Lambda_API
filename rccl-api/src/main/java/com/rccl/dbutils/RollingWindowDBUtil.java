package com.rccl.dbutils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.ParameterFiltersData;
import com.rccl.model.RollingWindow;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.helper.FilterDataHelper;
import com.rccl.utils.helper.RollingWindowDataHelper;

/**
 * The Class RollingWindowDBUtil.
 */
public class RollingWindowDBUtil {

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(RollingWindowDBUtil.class);

	// Creates instance
	public static RollingWindowDBUtil _instance = null;

	// Read properties from configuration file
	ConfigUtil configInst = ConfigUtil.getInstance();

	/**
	 * Gets the single instance of RollingWindowDBUtil.
	 * 
	 * @return single instance of RollingWindowDBUtil
	 */
	public static RollingWindowDBUtil getInstance() {
		if (_instance == null) {
			_instance = new RollingWindowDBUtil();
		}
		return _instance;
	}

	/**
	 * Gets the rolling window query.
	 * 
	 * @param request the request
	 * @param logger  the logger
	 * @return the final query for get API
	 */
	// Generate final Rolling Window parameter query for GET API
	public String getRollingWindowQuery(ParameterFiltersData request) {
		StringBuffer queryBuffer = new StringBuffer();
		String getRollingWindowQuery = new String(configInst.getRollingWindowData());
		try {
			System.out.println("reading query from config:" + getRollingWindowQuery);
			logger.debug("reading query from config:" + getRollingWindowQuery);
			FilterDataHelper filterDataHelper = new FilterDataHelper();
			String whereCondition = filterDataHelper.generateFilterCondition(request, queryBuffer);
			if (whereCondition.equals("")) {
				getRollingWindowQuery = getRollingWindowQuery.replace(RCCLConstants.WHERE_CONDITION_Q, "1=1");
			} else {
				getRollingWindowQuery = getRollingWindowQuery.replace(RCCLConstants.WHERE_CONDITION_Q, whereCondition);
			}
			logger.debug("Final query for GET API rolling window:" + getRollingWindowQuery);
		} catch (Exception e) {
			logger.error("Error occured in getRollingWindowQuery: " + e);
			throw e;
		}

		return getRollingWindowQuery;
	}

	/**
	 * Update rolling window data query.
	 * 
	 * @param request the request
	 * @param logger  the logger
	 * @return the final query for update API
	 */
	// Generate final Rolling Window parameter query for POST API
	public String updateRollingWindowDataQuery(RollingWindow request) {
		StringBuffer queryBuffer = new StringBuffer();
		StringBuffer updateBuffer = new StringBuffer();
		String updateRollingWindowQuery = null;
		try {
			updateRollingWindowQuery = new String(configInst.updateRollingWindow());
			logger.debug("reading query from config:" + updateRollingWindowQuery);
			FilterDataHelper filterDataHelper = new FilterDataHelper();
			String finalWhereCondition = filterDataHelper.generateFilterCondition(request.getFiltersData(),
					queryBuffer);
			RollingWindowDataHelper rollingWindowDataHelper = new RollingWindowDataHelper();
			String finalUpdateCondition = rollingWindowDataHelper.generateSetterCondition(request, updateBuffer);
			if (finalWhereCondition.equals("")) {
				updateRollingWindowQuery = updateRollingWindowQuery.replace(RCCLConstants.WHERE_CONDITION_Q, "1=1");
			} else {
				updateRollingWindowQuery = updateRollingWindowQuery.replace(RCCLConstants.WHERE_CONDITION_Q,
						finalWhereCondition);
			}
			updateRollingWindowQuery = updateRollingWindowQuery.replace(RCCLConstants.SETTER_COLUMNS_Q,
					finalUpdateCondition);
			logger.debug("Final query for POST API rolling window:" + updateRollingWindowQuery);

		} catch (Exception e) {
			logger.error("Error occured in updateRollingWindowDataQuery: " + e);
			throw e;
		}
		return updateRollingWindowQuery;
	}
}
