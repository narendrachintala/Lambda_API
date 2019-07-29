package com.rccl.lambda.handler;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.rccl.dto.PriceRangeDTO;
import com.rccl.model.ApiGatewayProxyRequest;
import com.rccl.model.GatewayResponse;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.validator.RequestDataValidator;
import com.rccl.service.PriceRangeService;
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
		implements RequestHandler<ApiGatewayProxyRequest, GatewayResponse> {

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
	 * @return the gateway response
	 * @see com.amazonaws.services.lambda.runtime.RequestHandler#handleRequest(java.lang.
	 *      Object, com.amazonaws.services.lambda.runtime.Context)
	 */
	public GatewayResponse handleRequest(final ApiGatewayProxyRequest req, final Context context) {
		// LambdaLogger logger = context.getLogger();
		ParameterFiltersData request = new Gson().fromJson(req.getBody(), ParameterFiltersData.class);
		logger.info("Input: " + request.toString());

		/**
		 * Assigning the AWS Lambda Request ID to Static Constant, which can be referred
		 * through out session
		 */
		RCCLConstants.REQUEST_ID = context.getAwsRequestId();

		List<PriceRangeDTO> priceRangeList = null;
		GatewayResponse response = null;

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
							RCCLConstants.REQUEST_ID);
				} else {
					response = new GatewayResponse(priceRangeList, ResponseUtil.getHeaders(),
							RCCLConstants.SC_OK, RCCLConstants.REQUEST_ID);
				}
			}

		} catch (Exception e) {
			logger.error("Error occured while executing GetPriceRangeDataHandler: " + e.getMessage());
			e.printStackTrace();
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
		}
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

		//new GetPriceRangeDataHandler().handleRequest(FiltersData.getRequestData(), null);
	}
}
