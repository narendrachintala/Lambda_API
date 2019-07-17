package com.rccl.dbutils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.ParameterFiltersData;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.helper.FilterDataHelper;

/**
 * The Class BookedPositionDBUtils.
 */
public class BookedPositionDBUtils {
	
	/** The Constant logger. */
	// Initialize the Log4j logger.
		static final Logger logger = LogManager.getLogger(BookedPositionDBUtils.class);

		/** The instance. */
		// Creates instance
		public static BookedPositionDBUtils _instance = null;

		/** The config inst. */
		// Read properties from configuration file
		ConfigUtil configInst = ConfigUtil.getInstance();

		/**
		 * Gets the single instance of BookedPositionDBUtils.
		 * 
		 * @return single instance of BookedPositionDBUtils
		 */
		public static BookedPositionDBUtils getInstance() {
			if (_instance == null) {
				_instance = new BookedPositionDBUtils();
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
				System.out.println("reading query from config:" + getBookedPositionQuery);
				logger.debug("reading query from config:" + getBookedPositionQuery);
				FilterDataHelper filterDataHelper = new FilterDataHelper();
				String whereCondition = filterDataHelper.generateFilterCondition(request, queryBuffer);
				if (whereCondition.equals("")) {
					getBookedPositionQuery = getBookedPositionQuery.replace(RCCLConstants.WHERE_CONDITION_Q, "1=1");
				} else {
					getBookedPositionQuery = getBookedPositionQuery.replace(RCCLConstants.WHERE_CONDITION_Q, whereCondition);
				}
				logger.debug("Final query for GET API rolling window:" + getBookedPositionQuery);
			} catch (Exception e) {
				logger.error("Error occured in getBookedPositionQuery: " + e);
				throw e;
			}

			return getBookedPositionQuery;
		}

}
