package com.rccl.utils.helper;


import com.rccl.dto.PauseParaReq;
import com.rccl.dto.PriceRangeReq;
import com.rccl.utils.RCCLConstants;

public class PauseParaDataHelper {
	public String generateFilterCondition(PauseParaReq pauseParaReq, StringBuffer queryBuffer) {
		
		String IN = " in (";
		String AND = ") and ";

		if (pauseParaReq.getL1_insert_date() != null) {

			queryBuffer.append(RCCLConstants.L1_INSERT_DATE).append(IN);
			queryBuffer.append("/'").append(pauseParaReq.getL1_range_max()).append("/'");
			queryBuffer.append(AND);

		}
	}

}
