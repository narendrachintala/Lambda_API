package com.rccl.utils;

import java.util.List;
import java.util.Map;

import com.amazonaws.util.CollectionUtils;
import com.rccl.model.PriceRange;
import com.rccl.utils.helper.FilterDataHelper;
import com.rccl.utils.helper.PriceRangeDataHelper;

/**
 * 
 * @author narendra.chintala
 *
 */
public class DBUtils {

	public static DBUtils _instance = null;

	ConfigUtil configInst = ConfigUtil.getInstance();

	public static DBUtils getInstance() {
		if (_instance == null) {
			_instance = new DBUtils();
		}
		return _instance;
	}

	public String generateFilterQuery(Map<String, List<String>> filterData, String filter_column) {

		StringBuffer queryBuffer = new StringBuffer();
		String filterQuery = new String(configInst.getFilterDataQuery());

		if (!CollectionUtils.isNullOrEmpty(filterData.get(RCCLConstants.TABLE_NAME))) {

			filterQuery = filterQuery.replace(RCCLConstants.TABLE_NAME_Q,
					filterData.get(RCCLConstants.TABLE_NAME).get(0));
			filterQuery = filterQuery.replaceAll(RCCLConstants.FILTER_COLUMN_Q, filter_column);

		}
		filterQuery = filterQuery.replace(RCCLConstants.FILTER_COLUMN_Q, filter_column);
		if (filter_column.equals(RCCLConstants.METAPRODUCT_F)) {
			filterQuery = filterQuery.replace(RCCLConstants.WHERE_CONDITION_Q, "1=1");
		} else {
			FilterDataHelper filterDataHelper = new FilterDataHelper();
			String whereCondition = filterDataHelper.generateFilterCondition(filterData, queryBuffer);
			if (whereCondition.equals("")) {
				filterQuery = filterQuery.replace(RCCLConstants.WHERE_CONDITION_Q, "1=1");
			} else {
				filterQuery = filterQuery.replace(RCCLConstants.WHERE_CONDITION_Q, whereCondition);
			}
		}
		// generate where condition and append to filter query
		// queryBuffer.append(filterQuery).append(generateFilterCondition(filterData,
		// queryBuffer));

		return filterQuery;
	}

	public String getPriceRangeDataQuery(Map<String, List<String>> filterData) {
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

	public String updatePriceRangeDataQuery(PriceRange priceRangeReq) {
		StringBuffer queryBuffer = new StringBuffer();
		String getPriceRangeQuery = new String(configInst.updatePriceRangeData());

		FilterDataHelper filterDataHelper = new FilterDataHelper();
		filterDataHelper.generateFilterCondition(priceRangeReq.getFilters(),
				queryBuffer);

		PriceRangeDataHelper priceRangeDataHelper = new PriceRangeDataHelper();
		queryBuffer.append(" and ");
		String finalWhereCondition = priceRangeDataHelper.generateFilterCondition(priceRangeReq, queryBuffer);

		if (finalWhereCondition.equals("")) {
			getPriceRangeQuery = getPriceRangeQuery.replace(RCCLConstants.WHERE_CONDITION_Q, "1=1");
		} else {
			getPriceRangeQuery = getPriceRangeQuery.replace(RCCLConstants.WHERE_CONDITION_Q, finalWhereCondition);
		}
		return getPriceRangeQuery;
	}

}
