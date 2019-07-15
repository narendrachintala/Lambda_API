package com.rccl.lambda.handler;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.GsonBuilder;
import com.rccl.dto.PriceRangeDTO;
import com.rccl.model.GatewayResponse;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.validator.RequestDataValidator;
import com.rccl.service.PriceRangeService;
import com.rccl.testdata.FiltersData;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResourceBundleUtility;
import com.rccl.utils.ResponseUtil;

/**
 * @author narendra.chintala
 *
 */

/**
 * The Class GetPriceRangeDataHandler.
 */

public class GetPriceRangeDataHandler
		implements RequestHandler<ParameterFiltersData, GatewayResponse<? extends Object>> {

	static {
		System.setProperty("log4j.configurationFile", "log4j2.xml");
	}

	/** The Constant logger. */
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(GetPriceRangeDataHandler.class);

	// Read error messages from property file
	private static ResourceBundleUtility rBundleUtility = ResourceBundleUtility.getInstance();

	/**
	 * This method will be invoked from AWS Lambda function to fetch price range
	 * parameter data based on provided filter criteria.
	 *
	 * @param request the request
	 * @param context the context
	 * @return the gateway response<? extends object>
	 * @see com.amazonaws.services.lambda.runtime.RequestHandler#handleRequest(java.lang.
	 *      Object, com.amazonaws.services.lambda.runtime.Context)
	 */
	public GatewayResponse<? extends Object> handleRequest(ParameterFiltersData request, Context context) {
		// LambdaLogger logger = context.getLogger();
		logger.info("Input: " + request.toString());

		List<PriceRangeDTO> priceRangeList = null;
		GatewayResponse<? extends Object> response = null;

		try {
			// validating request data
			RequestDataValidator priceRangeValidator = new RequestDataValidator();
			response = priceRangeValidator.validateGetRequest(request);
			if (response == null) { // response null denotes request is valid

				PriceRangeService priceRangeService = new PriceRangeService();
				priceRangeList = priceRangeService.getPriceRangeData(request);
				if (priceRangeList != null && priceRangeList.size() == 0) {
					response = ResponseUtil.getCustErrorMessage(
							rBundleUtility.getValue(RCCLConstants.ERROR_NO_RECORDS_FOUND), RCCLConstants.SC_OK,
							context.getAwsRequestId());
				} else {
					response = new GatewayResponse<List<PriceRangeDTO>>(priceRangeList, ResponseUtil.getHeaders(),
							RCCLConstants.SC_OK, context.getAwsRequestId());
				}
			}

		} catch (Exception e) {
			logger.error("Error occured while executing GetPriceRangeDataHandler: " + e.getMessage());
			e.printStackTrace();
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST, context.getAwsRequestId());
		}
		System.out.println(new GsonBuilder().serializeNulls().create().toJson(response));
		return response;

	}

	/**
	 * The main method will be used for testing with sample data.
	 * 
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		/*
		 * ParameterFiltersData data = new ParameterFiltersData();
		 * data.setMetaproduct("OASIS"); System.out.println(new
		 * GsonBuilder().serializeNulls().create().toJson(data)); System.exit(0);
		 */

		new GetPriceRangeDataHandler().handleRequest(FiltersData.getRequestData(), null);
	}
}
