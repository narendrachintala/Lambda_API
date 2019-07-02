package com.rccl.dbutils;


import com.rccl.model.CurrentPricePara;
import com.rccl.model.ParameterFiltersData;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.helper.CurrentPriceDataHelper;
import com.rccl.utils.helper.FilterDataHelper;

/**
 * 
 * @author chandrabhan.birla
 *
 */
public class CurrentPriceParaDBUtil {
	public static CurrentPriceParaDBUtil _instance = null;
	ConfigUtil configInst = ConfigUtil.getInstance();

	/**
	 * 
	 * @return CurrentPriceParaDBUtil instance for utilizing class methods
	 */
	public static CurrentPriceParaDBUtil getInstance() {
		if (_instance == null) {
			_instance = new CurrentPriceParaDBUtil();
		}
		return _instance;
	}

	/**
	 * Gets the CurrentPricePara data query.
	 * 
	 * @param filterData the filter data
	 * @return the price range data query
	 */
	public String getCurrentPriceDataQuery(ParameterFiltersData filterData) {
		StringBuffer queryBuffer = new StringBuffer();
		String getCurrentPriceQuery = new String(configInst.getCurrentPriceData());
		FilterDataHelper filterDataHelper = new FilterDataHelper();
		String whereCondition = filterDataHelper.generateFilterCondition(filterData, queryBuffer);
		if (whereCondition.equals("")) {
			getCurrentPriceQuery = getCurrentPriceQuery.replace(RCCLConstants.WHERE_CONDITION_Q, "1=1");
		} else {
			getCurrentPriceQuery = getCurrentPriceQuery.replace(RCCLConstants.WHERE_CONDITION_Q, whereCondition);
		}
		return getCurrentPriceQuery;
	}

	/**
	 * Update CurrentPricePara data query.
	 * 
	 * @param currentPriceReq the CurrentPricePara req
	 * @return the string
	 */
	public String generateUpdateCurrentPriceDataQuery(CurrentPricePara currentPriceReq) {
		StringBuffer queryBuffer = new StringBuffer();
		String getCurrentPriceQuery = new String(configInst.updateCurrentPriceData());
		FilterDataHelper filterDataHelper = new FilterDataHelper();

		String filterWhereCondition = filterDataHelper.generateFilterCondition(currentPriceReq.getFiltersData(),
				queryBuffer);

		CurrentPriceDataHelper currentPriceDataHelper = new CurrentPriceDataHelper();
		// queryBuffer.append(" and ");
		String setterCondition = currentPriceDataHelper.generateSetterCondition(currentPriceReq, new StringBuffer());

		if (setterCondition != "") {
			getCurrentPriceQuery = getCurrentPriceQuery.replace(RCCLConstants.SETTER_COLUMNS_Q, setterCondition);
		}

		if (filterWhereCondition.equals("")) {
			getCurrentPriceQuery = getCurrentPriceQuery.replace(RCCLConstants.WHERE_CONDITION_Q, "1=1");
		} else {
			getCurrentPriceQuery = getCurrentPriceQuery.replace(RCCLConstants.WHERE_CONDITION_Q, filterWhereCondition);
		}
		return getCurrentPriceQuery;
	}
}
