package com.rccl.utils.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.RefundablePremium;
import com.rccl.utils.RCCLConstants;

/**
 * The Class RefundablePremiumDataHelper.
 */
public class RefundablePremiumDataHelper {
	
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(RefundablePremiumDataHelper.class);
	
	/**
	 * Generate filter condition.
	 * 
	 * @param request     the request
	 * @param queryBuffer the query buffer
	 * @return the final set condition
	 */
	public String generateSetterCondition(RefundablePremium request, StringBuffer queryBuffer) {
		String EQUALS = RCCLConstants.EQUALS;
		String COMMA = RCCLConstants.COMMA;
		String SINGLE_QUOTE = RCCLConstants.SINGLE_QUOTE;
		String finalQuery = "";
		try {
			if (request.getGap_type() != null) {
				queryBuffer.append(RCCLConstants.GAP_TYPE).append(EQUALS);
				queryBuffer.append(SINGLE_QUOTE).append(request.getGap_type()).append(SINGLE_QUOTE);
				queryBuffer.append(COMMA);
			}
			if (request.getCurrent_gap_pct() != null) {
				queryBuffer.append(RCCLConstants.CURRENT_GAP_PCT).append(EQUALS);
				queryBuffer.append(request.getCurrent_gap_pct());
				queryBuffer.append(COMMA);
			}
			if (request.getStandard_gap_pct() != null) {
				queryBuffer.append(RCCLConstants.STANDARD_GAP_PCT).append(EQUALS);
				queryBuffer.append(request.getStandard_gap_pct());
				queryBuffer.append(COMMA);
			}
			// removing last appended extra ,
			if (queryBuffer.toString().endsWith(",")) {
				finalQuery = queryBuffer.substring(0, queryBuffer.length() - 1);
			}
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
		return finalQuery;
	}

}
