package com.rccl.dbutils;

import com.rccl.model.ParameterFiltersData;
import com.rccl.model.PriceRange;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.helper.FilterDataHelper;
import com.rccl.utils.helper.PriceRangeDataHelper;

/**
 * 
 * @author narendra.chintala
 *
 */
public class PriceRangeDBUtil {

	public static PriceRangeDBUtil _instance = null;
	ConfigUtil configInst = ConfigUtil.getInstance();

	/**
	 * 
	 * @return PriceRangeDBUtil instance for utilizing class methods
	 */
	public static PriceRangeDBUtil getInstance() {
		if (_instance == null) {
			_instance = new PriceRangeDBUtil();
		}
		return _instance;
	}

	/**
	 * Gets the price range data query.
	 * 
	 * @param filterData the filter data
	 * @return the price range data query
	 */
	public String getPriceRangeDataQuery(ParameterFiltersData filterData) {
		StringBuffer queryBuffer = new StringBuffer();
		String getPriceRangeQuery = new String(configInst.getPriceRangeData());
		FilterDataHelper filterDataHelper = new FilterDataHelper();
		String whereCondition = filterDataHelper.generateFilterCondition(filterData, queryBuffer);
		if (whereCondition.equals("")) {
			getPriceRangeQuery = getPriceRangeQuery.replace(RCCLConstants.WHERE_CONDITION_Q, "1=1");
		} else {
			getPriceRangeQuery = getPriceRangeQuery.replace(RCCLConstants.WHERE_CONDITION_Q, whereCondition);
		}
		return getPriceRangeQuery;
	}

	/**
	 * Update price range data query.
	 * 
	 * @param priceRangeReq the price range req
	 * @return the string
	 */
	public String generateUpdatePriceRangeDataQuery(PriceRange priceRangeReq) {
		StringBuffer queryBuffer = new StringBuffer();
		String getPriceRangeQuery = new String(configInst.updatePriceRangeData());
		FilterDataHelper filterDataHelper = new FilterDataHelper();

		String filterWhereCondition = filterDataHelper.generateFilterCondition(priceRangeReq.getFilterData(),
				queryBuffer);

		PriceRangeDataHelper priceRangeDataHelper = new PriceRangeDataHelper();
		// queryBuffer.append(" and ");
		String setterCondition = priceRangeDataHelper.generateSetterCondition(priceRangeReq, new StringBuffer());

		if (setterCondition != "") {
			getPriceRangeQuery = getPriceRangeQuery.replace(RCCLConstants.SETTER_COLUMNS_Q, setterCondition);
		}

		if (filterWhereCondition.equals("")) {
			getPriceRangeQuery = getPriceRangeQuery.replace(RCCLConstants.WHERE_CONDITION_Q, "1=1");
		} else {
			getPriceRangeQuery = getPriceRangeQuery.replace(RCCLConstants.WHERE_CONDITION_Q, filterWhereCondition);
		}
		return getPriceRangeQuery;
	}
}
