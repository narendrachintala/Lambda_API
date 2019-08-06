package com.rccl.dbutils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.BookedPosition;
import com.rccl.model.ParameterFiltersData;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.helper.BookedPositionDataHelper;
import com.rccl.utils.helper.FilterDataHelper;

/**
 * The Class BookedPositionDBUtil.
 */
public class BookedPositionDBUtil {

	/** The Constant logger. */
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(BookedPositionDBUtil.class);

	/** The instance. */
	// Creates instance
	public static BookedPositionDBUtil _instance = null;

	/** The config inst. */
	// Read properties from configuration file
	ConfigUtil configInst = ConfigUtil.getInstance();

	/**
	 * Gets the single instance of BookedPositionDBUtil.
	 * 
	 * @return single instance of BookedPositionDBUtil
	 */
	public static BookedPositionDBUtil getInstance() {
		if (_instance == null) {
			_instance = new BookedPositionDBUtil();
		}
		return _instance;
	}

	/**
	 * Gets the BookedPosition query.
	 *
	 * @param request the request
	 * @return the final query for get API
	 */
	// Generate final Rolling Window parameter query for GET API
	public String getBookedPositionQuery(ParameterFiltersData request) {
		StringBuffer queryBuffer = new StringBuffer();
		String getBookedPositionQuery = new String(configInst.getBookedPositionPara());
		try {
			logger.debug("reading query from config:" + getBookedPositionQuery);
			FilterDataHelper filterDataHelper = new FilterDataHelper();
			String whereCondition = filterDataHelper.generateFilterCondition(request, queryBuffer);
			if (whereCondition.equals("")) {
				getBookedPositionQuery = getBookedPositionQuery.replace(RCCLConstants.WHERE_CONDITION_Q, "1=1");
			} else {
				getBookedPositionQuery = getBookedPositionQuery.replace(RCCLConstants.WHERE_CONDITION_Q,
						whereCondition);
			}
			logger.debug("Final query for GET API Booked Position:" + getBookedPositionQuery);
		} catch (Exception e) {
			logger.error("Error occured in getBookedPositionQuery: " + e);
			throw e;
		}

		return getBookedPositionQuery;
	}

	// Generate final BookedPosition query for POST API
	public String updateBookedPositionDataQuery(BookedPosition request) {
		StringBuffer queryBuffer = new StringBuffer();
		StringBuffer updateBuffer = new StringBuffer();
		String updateBookedPositionQuery = null;
		try {
			updateBookedPositionQuery = new String(configInst.updateBookedPositionPara());
			logger.debug("reading query from config:" + updateBookedPositionQuery);
			FilterDataHelper filterDataHelper = new FilterDataHelper();
			String finalWhereCondition = filterDataHelper.generateFilterCondition(request.getFiltersData(),
					queryBuffer);
			BookedPositionDataHelper BookedPositionDataHelper = new BookedPositionDataHelper();
			String finalUpdateCondition = BookedPositionDataHelper.generateSetterCondition(request, updateBuffer);
			if (finalWhereCondition.equals("")) {
				updateBookedPositionQuery = updateBookedPositionQuery.replace(RCCLConstants.WHERE_CONDITION_Q, "1=1");
			} else {
				updateBookedPositionQuery = updateBookedPositionQuery.replace(RCCLConstants.WHERE_CONDITION_Q,
						finalWhereCondition);
			}
			updateBookedPositionQuery = updateBookedPositionQuery.replace(RCCLConstants.SETTER_COLUMNS_Q,
					finalUpdateCondition);
			logger.debug("Final query for POST API Booked Position:" + updateBookedPositionQuery);

		} catch (Exception e) {
			logger.error("Error occured in updateBookedPositionQuery: " + e);
			throw e;
		}
		return updateBookedPositionQuery;
	}

}
