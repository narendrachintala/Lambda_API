package com.rccl.utils.helper;

import com.rccl.dto.PriceRangeReq;
import com.rccl.utils.RCCLConstants;

public class PriceRangeDataHelper {

	public String generateFilterCondition(PriceRangeReq priceRangeReq, StringBuffer queryBuffer) {

		String IN = " in (";
		String AND = ") and ";

		if (priceRangeReq.getL1_range_max() != null) {

			queryBuffer.append(RCCLConstants.L1_RANGE_MAX).append(IN);
			queryBuffer.append("/'").append(priceRangeReq.getL1_range_max()).append("/'");
			queryBuffer.append(AND);

		}
		if (priceRangeReq.getL1_range_min() != null) {

			queryBuffer.append(RCCLConstants.L1_RANGE_MIN).append(IN);
			queryBuffer.append("/'").append(priceRangeReq.getL1_range_min()).append("/'");
			queryBuffer.append(AND);

		}
		if (priceRangeReq.getL2_range_max() != null) {

			queryBuffer.append(RCCLConstants.L2_RANGE_MAX).append(IN);
			queryBuffer.append("/'").append(priceRangeReq.getL2_range_max()).append("/'");
			queryBuffer.append(AND);

		}
		if (priceRangeReq.getL2_range_min() != null) {

			queryBuffer.append(RCCLConstants.L2_RANGE_MIN).append(IN);
			queryBuffer.append("/'").append(priceRangeReq.getL2_range_min()).append("/'");
			queryBuffer.append(AND);

		}
		// removing last appended extra AND
		queryBuffer.replace(queryBuffer.lastIndexOf(AND) + 1, queryBuffer.length(), "");

		return queryBuffer.toString();

	}

}
