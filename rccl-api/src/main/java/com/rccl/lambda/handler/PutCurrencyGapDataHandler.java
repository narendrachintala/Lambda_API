package com.rccl.lambda.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.rccl.model.ApiGatewayProxyRequest;
import com.rccl.model.CurrencyGapPara;
import com.rccl.model.GatewayResponse;
import com.rccl.model.validator.CurrencyGapDataValidator;
import com.rccl.service.CurrencyGapParaService;
import com.rccl.testdata.FiltersData;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResourceBundleUtility;
import com.rccl.utils.ResponseUtil;

/**
 * The Class PutCurrencyGapDataHandler.
 *
 * @author chandrabhan.birla
 */

public class PutCurrencyGapDataHandler implements RequestHandler<ApiGatewayProxyRequest, GatewayResponse> {

	static {
		System.setProperty("log4j.configurationFile", "log4j2.xml");
	}

	/** The Constant logger. */
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(PutCurrencyGapDataHandler.class);

	// Read error messages from property file
	private static ResourceBundleUtility rBundleUtility = ResourceBundleUtility.getInstance();

	/** The instance. */
	// creating instance of class
	public static PutCurrencyGapDataHandler _instance = null;

	/**
	 * Gets the single instance of PutCurrencyGapDataHandler.
	 * 
	 * @return single instance of PutCurrencyGapDataHandler
	 */
	public static PutCurrencyGapDataHandler getInstance() {
		if (_instance == null) {
			_instance = new PutCurrencyGapDataHandler();
		}
		return _instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.amazonaws.services.lambda.runtime.RequestHandler#handleRequest(java.lang.
	 * Object, com.amazonaws.services.lambda.runtime.Context)
	 */
	@Override
	/**
	 * Post currency gap parameter data based on applied filters and requested data
	 * Handle request.
	 * 
	 * @param request contains chosen filters as key-value pair
	 * @param context lambda context object
	 * @return true if update is successful
	 */
	public GatewayResponse handleRequest(ApiGatewayProxyRequest req, Context context) {

		/**
		 * Assigning the AWS Lambda Request ID to Static Constant, which can be referred
		 * through out session
		 */
		RCCLConstants.REQUEST_ID = context.getAwsRequestId();

		Boolean result = false;
		ConfigUtil configInst = ConfigUtil.getInstance();
		String jobName = configInst.getTableName(RCCLConstants.CURRENCY_GAP_PARA);
		GatewayResponse response = null;
		try {
			
			CurrencyGapPara request = new Gson().fromJson(req.getBody(), CurrencyGapPara.class);
			logger.info("input: " + request.toString());
			//Validates input Request
			CurrencyGapDataValidator dataValidator = CurrencyGapDataValidator.getInstance();
			response = dataValidator.validatePutRequest(request, jobName);
			if (response == null) { // response null denotes request is valid
				CurrencyGapParaService currentPriceService = CurrencyGapParaService.getInstance();
				result = currentPriceService.updateCurrencyGapParaData(request);
				if (result == true) {
					response = ResponseUtil.getCustErrorMessage(
							rBundleUtility.getValue(RCCLConstants.ERROR_UPDATE_RECORDS_SUCCESS), RCCLConstants.SC_OK,
							RCCLConstants.REQUEST_ID);
				} else {
					response = ResponseUtil.getCustErrorMessage(
							rBundleUtility.getValue(RCCLConstants.ERROR_UPDATE_RECORDS_FAILURE), RCCLConstants.SC_OK,
							RCCLConstants.REQUEST_ID);
				}
			}
		} catch (Exception e) {
			logger.error("Error occured while executing PutCurrencyGapDataHandler: " + e);
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
		}
		return response;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		CurrencyGapPara currentPriceReq = new CurrencyGapPara();

		currentPriceReq.setFiltersData(FiltersData.getParamRequestData());
		currentPriceReq.setCurrency3("USD");
		currentPriceReq.setGap3(0.1);
		ResponseUtil.getInstance();
		// System.out.println(new GsonBuilder().serializeNulls().create()
		// .toJson(new GatewayResponse<Boolean>(true, ResponseUtil.getHeaders(),
		// RCCLConstants.SC_OK)));
		// System.exit(0);

		new PutCurrencyGapDataHandler().handleRequest(null, new Context() {

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
