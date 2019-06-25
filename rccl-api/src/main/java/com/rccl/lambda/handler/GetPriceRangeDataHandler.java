package com.rccl.lambda.handler;

import java.util.List;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.GsonBuilder;
import com.rccl.dto.PriceRangeDTO;
import com.rccl.model.GatewayResponse;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.validator.RequestDataValidator;
import com.rccl.service.PriceRangeService;
import com.rccl.testdata.FiltersData;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResponseUtil;
import com.rccl.utils.helper.RCCLException;

/**
 * @author narendra.chintala
 *
 */
public class GetPriceRangeDataHandler
		implements RequestHandler<ParameterFiltersData, GatewayResponse<? extends Object>> {
	/*
	 * This method will be invoked from AWS Lambda function to fetch price range
	 * parameter data based on provided filter criteria
	 *
	 * @see
	 * com.amazonaws.services.lambda.runtime.RequestHandler#handleRequest(java.lang.
	 * Object, com.amazonaws.services.lambda.runtime.Context)
	 * 
	 */
	public GatewayResponse<? extends Object> handleRequest(ParameterFiltersData request, Context context) {

		context.getLogger().log("Input: " + request.toString());
		List<PriceRangeDTO> priceRangeList = null;
		GatewayResponse<? extends Object> response = null;
		ResponseUtil respUtil = ResponseUtil.getInstance();

		LambdaLogger logger = context.getLogger();
		try {
			// validating request data
			RequestDataValidator priceRangeValidator = new RequestDataValidator();
			response = priceRangeValidator.validateGetRequest(request);
			if (response == null) { // response null denotes validation executed with no errors
				
				PriceRangeService priceRangeService = new PriceRangeService();
				priceRangeList = priceRangeService.getPriceRangeData(request, logger);

				response = new GatewayResponse<List<PriceRangeDTO>>(priceRangeList, respUtil.getHeaders(),
						RCCLConstants.SC_OK);
			}

		} catch (Exception e) {
			logger.log("Error occured while executing GetPriceRangeDataHandler: " + e.getMessage());
			throw new RCCLException("Error occured while executing GetPriceRangeDataHandler", e);
		}
		return response;

	}

	/**
	 * The main method will be used for testing with sample data.
	 * 
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		ParameterFiltersData data = new ParameterFiltersData();
		data.setMetaproduct("OASIS");
		System.out.println(new GsonBuilder().serializeNulls().create().toJson(data));
		System.exit(0);

		new GetPriceRangeDataHandler().handleRequest(FiltersData.getRequestData(), new Context() {

			@Override
			public int getRemainingTimeInMillis() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int getMemoryLimitInMB() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public LambdaLogger getLogger() {
				// TODO Auto-generated method stub
				return new LambdaLogger() {

					@Override
					public void log(String string) {
						// TODO Auto-generated method stub

					}
				};
			}

			@Override
			public String getLogStreamName() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getLogGroupName() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getInvokedFunctionArn() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public CognitoIdentity getIdentity() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getFunctionVersion() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getFunctionName() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public ClientContext getClientContext() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getAwsRequestId() {
				// TODO Auto-generated method stub
				return null;
			}
		});
	}
}
