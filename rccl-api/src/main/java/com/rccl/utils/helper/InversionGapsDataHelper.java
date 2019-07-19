package com.rccl.utils.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.InversionGapPara;
import com.rccl.utils.RCCLConstants;

public class InversionGapsDataHelper {
	// Initialize the Log4j logger.
		static final Logger logger = LogManager.getLogger(RollingWindowDataHelper.class);
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
			String finalQuery = "";
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
				// removing last appended extra ,
				if (queryBuffer.toString().endsWith(",")) {
					finalQuery = queryBuffer.substring(0, queryBuffer.length() - 1);
				}
				
				queryBuffer = UpdateColumnHelper.updateGenericColumns(queryBuffer);
				// removing last appended extra ,
				queryBuffer.replace(queryBuffer.lastIndexOf(COMMA), queryBuffer.length(), "");
			} catch (Exception e) {
				logger.error(e);
				throw e;
			}
			return queryBuffer.toString();
		}
	}

