package com.rccl.lambda.handler;

import java.util.List;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.rccl.dto.PriceRangeDTO;
import com.rccl.service.PriceRangeService;
import com.rccl.testdata.FiltersData;

/**
 * @author narendra.chintala
 *
 */
public class PriceRangeDataHandler implements RequestHandler<Map<String, List<String>>, List<PriceRangeDTO>> {

	/*
	 * This method will be invoked from AWS Lambda function to fetch price range
	 * parameter data based on provided filter criteria
	 * 
	 * @see
	 * com.amazonaws.services.lambda.runtime.RequestHandler#handleRequest(java.lang.
	 * Object, com.amazonaws.services.lambda.runtime.Context)
	 * 
	 */
	public List<PriceRangeDTO> handleRequest(Map<String, List<String>> request, Context context) {
		context.getLogger().log("Input: " + request);
		List<PriceRangeDTO> priceRangeList = null;
		if (request != null) {
			PriceRangeService priceRangeService = new PriceRangeService();
			priceRangeList = priceRangeService.getPriceRangeData(request);
		} else {
			System.out.println();
		}

		return priceRangeList;

	}

	/**
	 * The main method will be used for testing with sample data.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		new PriceRangeDataHandler().handleRequest(FiltersData.getRequestData(), null);
	}

}
