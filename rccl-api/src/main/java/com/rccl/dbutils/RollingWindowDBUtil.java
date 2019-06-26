package com.rccl.dbutils;

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
	
	public static RollingWindowDBUtil _instance = null;

	ConfigUtil configInst = ConfigUtil.getInstance();

	public static RollingWindowDBUtil getInstance() {
		if (_instance == null) {
			_instance = new RollingWindowDBUtil();
		}
		return _instance;
	}
	
	/**
	 * Gets the rolling window query.
	 * @param request the filter data
	 * @return the rolling window query
	 */
	// Generate final Rolling Window parameter query
	public String getRollingWindowQuery(ParameterFiltersData request, Logger logger) {
		StringBuffer queryBuffer = new StringBuffer();
		String getRollingWindowQuery = new String(configInst.getRollingWindowData());
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
		return getRollingWindowQuery;
	}
	
	/**
	 * Update rolling window data query.
	 * @param request the request
	 * @return the string
	 */
	public String updateRollingWindowDataQuery(RollingWindow request, Logger logger) {
		StringBuffer queryBuffer = new StringBuffer();
		StringBuffer updateBuffer = new StringBuffer();
		String updateRollingWindowQuery = new String(configInst.updateRollingWindow());
		System.out.println("reading query from config:" + updateRollingWindowQuery);
		logger.debug("reading query from config:" + updateRollingWindowQuery);
		FilterDataHelper filterDataHelper = new FilterDataHelper();
		String finalWhereCondition = filterDataHelper.generateFilterCondition(request.getFiltersData(), queryBuffer);
		RollingWindowDataHelper rollingWindowDataHelper = new RollingWindowDataHelper();
		String finalUpdateCondition = rollingWindowDataHelper.generateSetterCondition(request, updateBuffer);
		if (finalWhereCondition.equals("")) {
			updateRollingWindowQuery = updateRollingWindowQuery.replace(RCCLConstants.WHERE_CONDITION_Q, "1=1");
		} else {
			updateRollingWindowQuery = updateRollingWindowQuery.replace(RCCLConstants.WHERE_CONDITION_Q, finalWhereCondition);
		}
		updateRollingWindowQuery = updateRollingWindowQuery.replace(RCCLConstants.SETTER_COLUMNS_Q, finalUpdateCondition);
		System.out.println("modified query:" + updateRollingWindowQuery);
		logger.debug("Final query for POST API rolling window:" + updateRollingWindowQuery);
		return updateRollingWindowQuery;
	}

}
