package com.rccl.lambda.handler;

import java.util.List;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.rccl.dto.PriceRangeDTO;
import com.rccl.service.PriceRangeService;
import com.rccl.testdata.FiltersData;

public class PriceRangeDataHandler implements RequestHandler<Map<String, List<String>>, List<PriceRangeDTO>> {

	/**
	 * Get price range data based on applied filters
	 */
	public List<PriceRangeDTO> handleRequest(Map<String, List<String>> request, Context context) {
		List<PriceRangeDTO> priceRangeList = null;
		if (request != null) {
			// context.getLogger().log("Input: " + requestMap);
			PriceRangeService priceRangeService = new PriceRangeService();
			priceRangeList = priceRangeService.getPriceRangeData(request);
		}

		return priceRangeList;

	}

	public static void main(String[] args) {

		new PriceRangeDataHandler().handleRequest(FiltersData.getRequestData(), null);
	}

}
