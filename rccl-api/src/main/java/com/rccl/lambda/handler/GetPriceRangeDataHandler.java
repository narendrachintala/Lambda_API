package com.rccl.lambda.handler;

import java.util.List;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.rccl.dto.PriceRangeDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.validator.RequestDataValidator;
import com.rccl.service.PriceRangeService;
import com.rccl.testdata.FiltersData;
import com.rccl.utils.helper.RCCLException;

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
		List<PriceRangeDTO> priceRangeList = null;
		LambdaLogger logger = context.getLogger();
		
		try {
			// validating request data
			RequestDataValidator priceRangeValidator = new RequestDataValidator();
			priceRangeValidator.validateGetRequest(request);

			PriceRangeService priceRangeService = new PriceRangeService();
			priceRangeList = priceRangeService.getPriceRangeData(request, logger);
		} catch (Exception e) {
			logger.log("Error occured while executing GetPriceRangeDataHandler: " + e.getMessage());
			throw new RCCLException("Error occured while executing GetPriceRangeDataHandler", e);
		}
		System.out.println(new Gson().toJson(priceRangeList));
		return priceRangeList;

	}

	/**
	 * The main method will be used for testing with sample data.
	 * 
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		new GetPriceRangeDataHandler().handleRequest(FiltersData.getRequestData(), null);
	}
}
