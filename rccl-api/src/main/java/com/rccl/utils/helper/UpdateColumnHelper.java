package com.rccl.utils.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.utils.CustomFunctions;
import com.rccl.utils.RCCLConstants;

/**
 * The Class UpdateColumnHelper.
 *
 * @author chandrabhan.birla
 */
public class UpdateColumnHelper {
	/** The Constant logger. */
	static final Logger logger = LogManager.getLogger(CustomFunctions.class);

	/**
	 * Gets the list of Columns for which current date is to be set.
	 *
	 * @param queryBuffer the query buffer
	 * @return StringBuffer query with setter for clause for columns list
	 */
	public static StringBuffer updateGenericColumns(StringBuffer queryBuffer) {
		try {

			// update l1_insert_date with current time stamp
			queryBuffer.append(RCCLConstants.L1_INSERT_DATE).append(RCCLConstants.EQUALS);
			queryBuffer.append(RCCLConstants.SINGLE_QUOTE).append(CustomFunctions.getCurrentDate())
					.append(RCCLConstants.SINGLE_QUOTE).append(RCCLConstants.COMMA);

			// update user_id from lambda context. user_id will be set in the handler
			/*
			 * queryBuffer.append(RCCLConstants.USER_ID).append(RCCLConstants.EQUALS);
			 * queryBuffer.append(RCCLConstants.SINGLE_QUOTE).append(RCCLConstants.
			 * USER_NAME) .append(RCCLConstants.SINGLE_QUOTE).append(RCCLConstants.COMMA);
			 */

		} catch (Exception e) {
			logger.error(e);
			throw e;
		}

		return queryBuffer;

	}

}
