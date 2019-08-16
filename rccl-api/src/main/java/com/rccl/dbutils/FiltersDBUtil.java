package com.rccl.dbutils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.FiltersData;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.CustomFunctions;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.helper.FilterDataHelper;

/**
 * The Class FiltersDBUtil.
 *
 * @author narendra.chintala
 */
public class FiltersDBUtil {

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(FiltersDBUtil.class);

	/** The instance. */
	public static FiltersDBUtil _instance = null;

	/** The config inst. */
	ConfigUtil configInst = ConfigUtil.getInstance();

	/**
	 * Gets the single instance of FiltersDBUtil.
	 *
	 * @return single instance of FiltersDBUtil
	 */
	public static FiltersDBUtil getInstance() {
		if (_instance == null) {
			_instance = new FiltersDBUtil();
		}
		return _instance;
	}

	/**
	 * Generate filter query.
	 * 
	 * @param filterData    the filter data
	 * @param filter_column the filter column
	 * @return the string
	 */
	public String generateFilterQuery(FiltersData filterData, String filter_column) {

		String filterQuery = null;
		try {
			StringBuffer queryBuffer = new StringBuffer();
			filterQuery = new String(configInst.getFilterDataQuery());
			if (!CustomFunctions.isNullOrEmpty(filterData.getTable_name())) {

				filterQuery = filterQuery.replace(RCCLConstants.TABLE_NAME_Q, filterData.getTable_name());

				if (filter_column.equals(RCCLConstants.SAIL_DATE_F)) {
					filterQuery = filterQuery.replaceAll(RCCLConstants.FILTER_COLUMN_Q,
							"TO_CHAR(" + filter_column + ",'dd-MON-yy')");
				} else {
					filterQuery = filterQuery.replaceAll(RCCLConstants.FILTER_COLUMN_Q, filter_column);
				}
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
		} catch (Exception e) {
			logger.error("Error occured whil executing generateFilterQuery", e);
			throw e;
		}
		return filterQuery;
	}
}
