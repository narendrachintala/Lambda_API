package com.rccl.utils.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.BookedPosition;
import com.rccl.utils.RCCLConstants;

/**
 * The Class BookedPositionDataHelper.
 */
public class BookedPositionDataHelper {
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(BookedPositionDataHelper.class);
	
	/** The instance. */
	// creating instance of class
	public static BookedPositionDataHelper _instance = null;

	/**
	 * Gets the single instance of BookedPositionDataHelper.
	 * 
	 * @return single instance of BookedPositionDataHelper
	 */
	public static BookedPositionDataHelper getInstance() {
		if (_instance == null) {
			_instance = new BookedPositionDataHelper();
		}
		return _instance;
	}


	/**
	 * Generate filter condition.
	 * @param request     the request
	 * @param queryBuffer the query buffer
	 * @return the final set condition
	 */
	public String generateSetterCondition(BookedPosition request, StringBuffer queryBuffer) {
		String EQUALS = RCCLConstants.EQUALS;
		String COMMA = RCCLConstants.COMMA;
		String SINGLE_QUOTE = RCCLConstants.SINGLE_QUOTE;
		try {
			if (request.getBooked_position() != null) {
				queryBuffer.append(RCCLConstants.BOOKED_POSITION).append(EQUALS);
				queryBuffer.append(SINGLE_QUOTE).append(request.getBooked_position()).append(SINGLE_QUOTE);
				queryBuffer.append(COMMA);
			}
			if (request.getUser_id() != null) {
				queryBuffer.append(RCCLConstants.USER_ID).append(EQUALS);
				queryBuffer.append(SINGLE_QUOTE).append(request.getUser_id()).append(SINGLE_QUOTE);
				queryBuffer.append(COMMA);
			}
			queryBuffer = UpdateColumnHelper.updateGenericColumns(queryBuffer);
			// removing last appended extra ,
			queryBuffer.replace(queryBuffer.lastIndexOf(COMMA), queryBuffer.length(), "");
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		logger.info("QueryBuffer " + queryBuffer.toString());
		return queryBuffer.toString();
	}
}
