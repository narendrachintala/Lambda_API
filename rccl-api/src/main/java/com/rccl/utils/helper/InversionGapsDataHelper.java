package com.rccl.utils.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.InversionGapPara;
import com.rccl.utils.RCCLConstants;

/**
 * The Class InversionGapsDataHelper.
 */
public class InversionGapsDataHelper {
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(RollingWindowDataHelper.class);

	// creating instance of class
	public static InversionGapsDataHelper _instance = null;

	/**
	 * Gets the single instance of InversionGapsDataHelper.
	 * 
	 * @return single instance of InversionGapsDataHelper
	 */
	public static InversionGapsDataHelper getInstance() {
		if (_instance == null) {
			_instance = new InversionGapsDataHelper();
		}
		return _instance;
	}

	/**
	 * Generate Update condition.
	 * 
	 * @param request     the request
	 * @param queryBuffer the query buffer
	 * @return the final set condition
	 */
	public String generateSetterCondition(InversionGapPara request, StringBuffer queryBuffer) {
		String EQUALS = RCCLConstants.EQUALS;
		String COMMA = RCCLConstants.COMMA;
		try {
			if (request.getGap1() != null) {
				queryBuffer.append(RCCLConstants.GAP_1).append(EQUALS);
				queryBuffer.append(request.getGap1());
				queryBuffer.append(COMMA);
			}
			if (request.getGap2() != null) {
				queryBuffer.append(RCCLConstants.GAP_2).append(EQUALS);
				queryBuffer.append(request.getGap2());
				queryBuffer.append(COMMA);
			}
			if (request.getGap3() != null) {
				queryBuffer.append(RCCLConstants.GAP_3).append(EQUALS);
				queryBuffer.append(request.getGap3());
				queryBuffer.append(COMMA);
			}
			if (request.getGap4() != null) {
				queryBuffer.append(RCCLConstants.GAP_4).append(EQUALS);
				queryBuffer.append(request.getGap4());
				queryBuffer.append(COMMA);
			}
			if (request.getGap5() != null) {
				queryBuffer.append(RCCLConstants.GAP_5).append(EQUALS);
				queryBuffer.append(request.getGap5());
				queryBuffer.append(COMMA);
			}
			if (request.getGap6() != null) {
				queryBuffer.append(RCCLConstants.GAP_6).append(EQUALS);
				queryBuffer.append(request.getGap6());
				queryBuffer.append(COMMA);
			}
			if (request.getOrder_1() != null) {
				queryBuffer.append(RCCLConstants.ORDER_1).append(EQUALS);
				queryBuffer.append(RCCLConstants.SINGLE_QUOTE);
				queryBuffer.append(request.getOrder_1());
				queryBuffer.append(RCCLConstants.SINGLE_QUOTE);
				queryBuffer.append(COMMA);
			}
			if (request.getOrder_2() != null) {
				queryBuffer.append(RCCLConstants.ORDER_2).append(EQUALS);
				queryBuffer.append(RCCLConstants.SINGLE_QUOTE);
				queryBuffer.append(request.getOrder_2());
				queryBuffer.append(RCCLConstants.SINGLE_QUOTE);
				queryBuffer.append(COMMA);
			}
			if (request.getOrder_3() != null) {
				queryBuffer.append(RCCLConstants.ORDER_3).append(EQUALS);
				queryBuffer.append(RCCLConstants.SINGLE_QUOTE);
				queryBuffer.append(request.getOrder_3());
				queryBuffer.append(RCCLConstants.SINGLE_QUOTE);
				queryBuffer.append(COMMA);
			}
			if (request.getOrder_4() != null) {
				queryBuffer.append(RCCLConstants.ORDER_4).append(EQUALS);
				queryBuffer.append(RCCLConstants.SINGLE_QUOTE);
				queryBuffer.append(request.getOrder_4());
				queryBuffer.append(RCCLConstants.SINGLE_QUOTE);
				queryBuffer.append(COMMA);
			}
			if (request.getOrder_5() != null) {
				queryBuffer.append(RCCLConstants.ORDER_5).append(EQUALS);
				queryBuffer.append(RCCLConstants.SINGLE_QUOTE);
				queryBuffer.append(request.getOrder_5());
				queryBuffer.append(RCCLConstants.SINGLE_QUOTE);
				queryBuffer.append(COMMA);
			}
			if (request.getOrder_6() != null) {
				queryBuffer.append(RCCLConstants.ORDER_6).append(EQUALS);
				queryBuffer.append(RCCLConstants.SINGLE_QUOTE);
				queryBuffer.append(request.getOrder_6());
				queryBuffer.append(RCCLConstants.SINGLE_QUOTE);
				queryBuffer.append(COMMA);
			}
			if (request.getFiltersData().getUser_id() != null) {
				queryBuffer.append(RCCLConstants.USER_ID).append(EQUALS);
				queryBuffer.append(request.getFiltersData().getUser_id());
				queryBuffer.append(COMMA);
			}

			queryBuffer = UpdateColumnHelper.updateGenericColumns(queryBuffer);
			// removing last appended extra COMMA
			queryBuffer.replace(queryBuffer.lastIndexOf(COMMA), queryBuffer.length(), "");
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		return queryBuffer.toString();
	}
}
