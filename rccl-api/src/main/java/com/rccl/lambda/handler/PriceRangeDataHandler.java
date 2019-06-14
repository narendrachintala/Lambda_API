package com.rccl.lambda.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.rccl.model.PriceRangeDTO;
import com.rccl.testdata.FiltersData;

public class PriceRangeDataHandler implements RequestHandler<Map<String, List<String>>, List<PriceRangeDTO>> {

	/**
	 * Get price range data based on applied filters
	 */
	public List<PriceRangeDTO> handleRequest(Map<String, List<String>> request, Context context) {
		/*
		 * Map<String, List<String>> requestMap = null; if (req != null) { requestMap =
		 * (Map<String, List<String>>) req; } else { return null; }
		 * //context.getLogger().log("Input: " + requestMap); PriceRangeService
		 * priceRangeService = new PriceRangeService(); List<PriceRangeDTO>
		 * priceRangeList = priceRangeService.getPriceRangeData(requestMap); Gson json =
		 * new Gson(); System.out.println(json.toJson(priceRangeList));
		 */
		System.out.println("getPriceRangeRequest");
		
		List<PriceRangeDTO> postPrice= new ArrayList<PriceRangeDTO>();

		return postPrice;

	}

	public static void main(String[] args) {
		FiltersData data = new FiltersData();
		
		new PriceRangeDataHandler().handleRequest(data.getRequestData(), null);
	}

}
