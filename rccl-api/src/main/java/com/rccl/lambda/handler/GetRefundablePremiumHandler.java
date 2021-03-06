package com.rccl.lambda.handler;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rccl.dbutils.RevoreoConnect;
import com.rccl.dto.RefundablePremiumDTO;
import com.rccl.model.ApiGatewayProxyRequest;
import com.rccl.model.GatewayResponse;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.validator.RequestDataValidator;
import com.rccl.service.RefundablePremiumService;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResourceBundleUtility;
import com.rccl.utils.ResponseUtil;

/**
 * The Class GetRefundablePremiumHandler.
 */
public class GetRefundablePremiumHandler
		implements RequestHandler<ApiGatewayProxyRequest, GatewayResponse> {
	
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(GetRefundablePremiumHandler.class);

	static {
		System.setProperty("log4j.configurationFile", "log4j2.xml");
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(new Runnable() {
			public void run() {
				logger.info("executing run method to establish connection.");
				RevoreoConnect.getInstance().getConnection();
			}
		});
		executorService.shutdown();
	}

	// Read error messages from property file
	private static ResourceBundleUtility rBundleUtility = ResourceBundleUtility.getInstance();
	
	/** The instance. */
	// creating instance of class
	public static GetRefundablePremiumHandler _instance = null;

	/**
	 * Gets the single instance of GetRefundablePremiumHandler.
	 * 
	 * @return single instance of GetRefundablePremiumHandler
	 */
	public static GetRefundablePremiumHandler getInstance() {
		if (_instance == null) {
			_instance = new GetRefundablePremiumHandler();
		}
		return _instance;
	}

	/**
	 * This method will be invoked from AWS Lambda function to fetch refundable
	 * premium parameter data based on provided filter criteria
	 *
	 * @see com.amazonaws.services.lambda.runtime.RequestHandler#handleRequest(java.lang.
	 *      Object, com.amazonaws.services.lambda.runtime.Context)
	 * 
	 */
	public GatewayResponse handleRequest(ApiGatewayProxyRequest req, Context context) {

		/**
		 * Assigning the AWS Lambda Request ID to Static Constant, which can be referred
		 * through out session
		 */
		RCCLConstants.REQUEST_ID = context.getAwsRequestId();

		GatewayResponse response = null;
		List<RefundablePremiumDTO> refundablePremiumList = null;
		try {
			
			ParameterFiltersData request = new Gson().fromJson(req.getBody(), ParameterFiltersData.class);
			logger.info("Input request: " + request);
			// Validate input request
			RequestDataValidator requestDataValidator = RequestDataValidator.getInstance();
			response = requestDataValidator.validateGetRequest(request);
			if (response == null) { // response null denotes request is valid
				RefundablePremiumService refundablePremiumService = RefundablePremiumService.getInstance();
				refundablePremiumList = refundablePremiumService.getRefundablePremiumData(request);
				if (refundablePremiumList != null && refundablePremiumList.size() == 0) {
					response = ResponseUtil.getCustErrorMessage(
							rBundleUtility.getValue(RCCLConstants.ERROR_NO_RECORDS_FOUND), RCCLConstants.SC_OK,
							RCCLConstants.REQUEST_ID);
				} else {
					response = new GatewayResponse(refundablePremiumList,
							ResponseUtil.getHeaders(), RCCLConstants.SC_OK, RCCLConstants.REQUEST_ID);
				}
			}
		} catch (Exception ex) {
			logger.error("Error occured while executing GetRefunfdablePremiumHandler: " + ex.getMessage());
			return ResponseUtil.getErrorMessage(ex, RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
		}
		logger.info(new GsonBuilder().serializeNulls().create().toJson(response));
		return response;
	}

	public static void main(String args[]) {
		// prepares sample input data for handler class
		ParameterFiltersData parameterFiltersData = new ParameterFiltersData();
		parameterFiltersData.setCat_class("");
		parameterFiltersData.setMetaproduct("SHORT CARIBBEAN");
		parameterFiltersData.setOccupancy("");
		parameterFiltersData.setProduct_code("CARIB5");
		parameterFiltersData.setSail_month(3);
		parameterFiltersData.setShip_code("");

		new GetRefundablePremiumHandler().handleRequest(null, new Context() {

			@Override
			public String getAwsRequestId() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getLogGroupName() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getLogStreamName() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getFunctionName() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getFunctionVersion() {
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
			public ClientContext getClientContext() {
				// TODO Auto-generated method stub
				return null;
			}

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

		});
	}

}
