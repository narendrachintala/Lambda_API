package com.rccl.lambda.handler;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.rccl.dto.PriceRangeDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.validator.RequestDataValidator;
import com.rccl.service.PriceRangeService;

/**
 * @author narendra.chintala
 *
 */
public class GetPriceRangeDataHandler implements RequestHandler<ParameterFiltersData, List<PriceRangeDTO>> {

	/*
	 * This method will be invoked from AWS Lambda function to fetch price range
	 * parameter data based on provided filter criteria
	 *
	 * @see
	 * com.amazonaws.services.lambda.runtime.RequestHandler#handleRequest(java.lang.
	 * Object, com.amazonaws.services.lambda.runtime.Context)
	 * 
	 */
	public List<PriceRangeDTO> handleRequest(ParameterFiltersData request, Context context) {
		context.getLogger().log("Input: " + request);

		// validating request data
		RequestDataValidator priceRangeValidator = new RequestDataValidator();
		priceRangeValidator.validateGetRequest(request);

		List<PriceRangeDTO> priceRangeList = null;
		if (request != null) {
			PriceRangeService priceRangeService = new PriceRangeService();
			priceRangeList = priceRangeService.getPriceRangeData(request);
		} else {
			System.out.println();
		}
		System.out.println(priceRangeList.size());

		return priceRangeList;

	}

	/**
	 * The main method will be used for testing with sample data.
	 * 
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		new GetPriceRangeDataHandler().handleRequest(null, null);
	}
}
