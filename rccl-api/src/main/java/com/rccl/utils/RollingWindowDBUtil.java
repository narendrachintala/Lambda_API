package com.rccl.utils;

import java.util.List;
import java.util.Map;

import com.rccl.model.ParameterFiltersData;
import com.rccl.model.RollingWindow;
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
	public String getRollingWindowQuery(ParameterFiltersData request) {
		StringBuffer queryBuffer = new StringBuffer();
		String getRollingWindowQuery = new String(configInst.getRollingWindowData());
		System.out.println("reading query from config:" + getRollingWindowQuery);
		FilterDataHelper filterDataHelper = new FilterDataHelper();
		String whereCondition = filterDataHelper.generateFilterCondition(request, queryBuffer);
		if (whereCondition.equals("")) {
			getRollingWindowQuery = getRollingWindowQuery.replace(RCCLConstants.WHERE_CONDITION_Q, "1=1");
		} else {
			getRollingWindowQuery = getRollingWindowQuery.replace(RCCLConstants.WHERE_CONDITION_Q, whereCondition);
		}
		return getRollingWindowQuery;
	}
	
	/**
	 * Update rolling window data query.
	 * @param request the request
	 * @return the string
	 */
	public String updateRollingWindowDataQuery(RollingWindow request) {
		StringBuffer queryBuffer = new StringBuffer();
		StringBuffer queryBuffer1 = new StringBuffer();
		String getRollingWindowQuery = new String(configInst.updateRollingWindow());
		System.out.println("reading query from config:" + getRollingWindowQuery);
		FilterDataHelper filterDataHelper = new FilterDataHelper();
		//String finalWhereCondition = filterDataHelper.generateFilterCondition(request.getFilters(), queryBuffer);
		String finalWhereCondition = "";
		RollingWindowDataHelper rollingWindowDataHelper = new RollingWindowDataHelper();
		String finalUpdateCondition = rollingWindowDataHelper.generateFilterCondition(request, queryBuffer1);
		if (finalWhereCondition.equals("")) {
			getRollingWindowQuery = getRollingWindowQuery.replace(RCCLConstants.WHERE_CONDITION_Q, "1=1");
		} else {
			getRollingWindowQuery = getRollingWindowQuery.replace(RCCLConstants.WHERE_CONDITION_Q, finalWhereCondition);
		}
		getRollingWindowQuery = getRollingWindowQuery.replace(RCCLConstants.SETTER_COLUMNS_Q, finalUpdateCondition);
		System.out.println("modified query:" + getRollingWindowQuery);
		return getRollingWindowQuery;
	}

}
