package com.rccl.utils.helper;

import com.rccl.model.PriceRange;
import com.rccl.utils.RCCLConstants;

/**
 * The Class PriceRangeDataHelper.
 */
public class PriceRangeDataHelper {

	/**
	 * Generate setter condition.
	 *
	 * @param priceRangeReq the price range req
	 * @param queryBuffer the query buffer
	 * @return the string
	 */
	public String generateSetterCondition(PriceRange priceRangeReq, StringBuffer queryBuffer) {

		String EQUALS = RCCLConstants.EQUALS;
		String COMMA = RCCLConstants.COMMA;
		String SINGLE_QUOTE = RCCLConstants.SINGLE_QUOTE;

		if (priceRangeReq.getL1_range_max() != null) {

			queryBuffer.append(RCCLConstants.L1_RANGE_MAX).append(EQUALS);
			queryBuffer.append(SINGLE_QUOTE).append(priceRangeReq.getL1_range_max()).append(SINGLE_QUOTE);
			queryBuffer.append(COMMA);

		}
		if (priceRangeReq.getL1_range_min() != null) {

			queryBuffer.append(RCCLConstants.L1_RANGE_MIN).append(EQUALS);
			queryBuffer.append(SINGLE_QUOTE).append(priceRangeReq.getL1_range_min()).append(SINGLE_QUOTE);
			queryBuffer.append(COMMA);

		}
		if (priceRangeReq.getL2_range_max() != null) {

			queryBuffer.append(RCCLConstants.L2_RANGE_MAX).append(EQUALS);
			queryBuffer.append(SINGLE_QUOTE).append(priceRangeReq.getL2_range_max()).append(SINGLE_QUOTE);
			queryBuffer.append(COMMA);

		}
		if (priceRangeReq.getL2_range_min() != null) {

			queryBuffer.append(RCCLConstants.L2_RANGE_MIN).append(EQUALS);
			queryBuffer.append(SINGLE_QUOTE).append(priceRangeReq.getL2_range_min()).append(SINGLE_QUOTE);
			queryBuffer.append(COMMA);

		}
		// removing last appended extra COMMA
		queryBuffer.replace(queryBuffer.lastIndexOf(COMMA), queryBuffer.length(), "");

		System.out.println("queryBuffer.toString(): " + queryBuffer.toString());

		return queryBuffer.toString();

	}

}
