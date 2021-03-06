package com.rccl.lambda.handler;

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
import com.rccl.model.ApiGatewayProxyRequest;
import com.rccl.model.GatewayResponse;
import com.rccl.model.PriceRange;
import com.rccl.model.validator.PriceRangeDataValidator;
import com.rccl.service.PriceRangeService;
import com.rccl.testdata.FiltersData;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResourceBundleUtility;
import com.rccl.utils.ResponseUtil;

/**
 * The Class PutPriceRangeDataHandler.
 *
 * @author narendra.chintala
 */
public class PutPriceRangeDataHandler implements RequestHandler<ApiGatewayProxyRequest, GatewayResponse> {
	
	/** The Constant logger. */
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(PutPriceRangeDataHandler.class);

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
	public static PutPriceRangeDataHandler _instance = null;

	/**
	 * Gets the single instance of PutPriceRangeDataHandler.
	 * 
	 * @return single instance of PutPriceRangeDataHandler
	 */
	public static PutPriceRangeDataHandler getInstance() {
		if (_instance == null) {
			_instance = new PutPriceRangeDataHandler();
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
	 * Post price range data based on applied filters and requested data
	 */
	public GatewayResponse handleRequest(ApiGatewayProxyRequest req, Context context) {

		/**
		 * Assigning the AWS Lambda Request ID to Static Constant, which can be referred
		 * through out session
		 */
		RCCLConstants.REQUEST_ID = context.getAwsRequestId();

		Boolean result = false;
		GatewayResponse response = null;
		ConfigUtil configInst = ConfigUtil.getInstance();
		String jobName = configInst.getTableName(RCCLConstants.PRICE_RANGE_PARA);
		try {
			
			PriceRange request = new Gson().fromJson(req.getBody(), PriceRange.class);
			logger.info("input: " + request.toString());
			//Validates input request
			PriceRangeDataValidator dataValidator = PriceRangeDataValidator.getInstance();
			response = dataValidator.validatePutRequest(request, jobName);
			if (response == null) { // response null denotes request is valid
				PriceRangeService priceRangeService = PriceRangeService.getInstance();
				result = priceRangeService.updatePriceRangeData(request);
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
			logger.error("Error occured while executing PutPriceRangeDataHandler: " + e);
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

		PriceRange priceRangeReq = new PriceRange();

		priceRangeReq.setL1_range_min(-0.2);
		priceRangeReq.setL1_range_max(0.2);

		priceRangeReq.setFiltersData(FiltersData.getParamRequestData());

		logger.info(new GsonBuilder().serializeNulls().create().toJson(new GatewayResponse(true,
				ResponseUtil.getHeaders(), RCCLConstants.SC_OK, RCCLConstants.REQUEST_ID)));
		System.exit(0);

		new PutPriceRangeDataHandler().handleRequest(null, new Context() {

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
