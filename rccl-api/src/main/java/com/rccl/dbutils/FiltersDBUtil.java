package com.rccl.dbutils;

import com.rccl.model.FiltersData;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.CustomFun;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.helper.FilterDataHelper;

/**
 * 
 * @author narendra.chintala
 *
 */
public class FiltersDBUtil {

	public static FiltersDBUtil _instance = null;
	ConfigUtil configInst = ConfigUtil.getInstance();
	public static FiltersDBUtil getInstance() {
		if (_instance == null) {
			_instance = new FiltersDBUtil();
		}
		return _instance;
	}

	/**
	 * Generate filter query.
	 * @param filterData the filter data
	 * @param filter_column the filter column
	 * @return the string
	 */
	public String generateFilterQuery(FiltersData filterData, String filter_column) {
		StringBuffer queryBuffer = new StringBuffer();
		String filterQuery = new String(configInst.getFilterDataQuery());
		if (!CustomFun.isNullOrEmpty(filterData.getTable_name())) {

			filterQuery = filterQuery.replace(RCCLConstants.TABLE_NAME_Q, filterData.getTable_name());
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
}
