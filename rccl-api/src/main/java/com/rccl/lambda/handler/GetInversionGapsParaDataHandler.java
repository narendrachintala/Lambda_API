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
import com.rccl.dto.InversionGapsParaDTO;
import com.rccl.model.ApiGatewayProxyRequest;
import com.rccl.model.GatewayResponse;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.validator.RequestDataValidator;
import com.rccl.service.InversionGapParaService;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResourceBundleUtility;
import com.rccl.utils.ResponseUtil;

/**
 * The Class GetPriceRangeDataHandler.
 */
public class GetInversionGapsParaDataHandler
		implements RequestHandler<ApiGatewayProxyRequest, GatewayResponse> {
	
	/** The Constant logger. */
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(GetInversionGapsParaDataHandler.class);

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
	public static GetInversionGapsParaDataHandler _instance = null;

	/**
	 * Gets the single instance of GetInversionGapsParaDataHandler.
	 * 
	 * @return single instance of GetInversionGapsParaDataHandler
	 */
	public static GetInversionGapsParaDataHandler getInstance() {
		if (_instance == null) {
			_instance = new GetInversionGapsParaDataHandler();
		}
		return _instance;
	}

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
	public GatewayResponse handleRequest(ApiGatewayProxyRequest req, Context context) {
		
		/**
		 * Assigning the AWS Lambda Request ID to Static Constant, which can be referred
		 * through out session
		 */
		RCCLConstants.REQUEST_ID = context.getAwsRequestId();

		List<InversionGapsParaDTO> inversionGapsParaList = null;
		GatewayResponse response = null;
		try {
			
			ParameterFiltersData request = new Gson().fromJson(req.getBody(), ParameterFiltersData.class);
			logger.info("Input: " + request.toString());
			// validating request data
			RequestDataValidator invergapValidator = RequestDataValidator.getInstance();
			response = invergapValidator.validateGetRequest(request);
			if (response == null) { // response null denotes request is valid
				InversionGapParaService inversionGapParaService = InversionGapParaService.getInstance();
				inversionGapsParaList = inversionGapParaService.getinversionGapParaData(request);
				if (inversionGapsParaList != null && inversionGapsParaList.size() == 0) {
					response = ResponseUtil.getCustErrorMessage(
							rBundleUtility.getValue(RCCLConstants.ERROR_NO_RECORDS_FOUND), RCCLConstants.SC_OK,
							RCCLConstants.REQUEST_ID);
				} else {
					response = new GatewayResponse(inversionGapsParaList,
							ResponseUtil.getHeaders(), RCCLConstants.SC_OK, RCCLConstants.REQUEST_ID);
				}
			}
		} catch (Exception e) {
			logger.error("Error occured while executing GetInversionGapsParaDataHandler: " + e.getMessage());
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
		}
		logger.info(new GsonBuilder().serializeNulls().create().toJson(response));
		return response;
	}

	/**
	 * The main method will be used for testing with sample data.
	 * 
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		ParameterFiltersData parameterFiltersData = new ParameterFiltersData();
		parameterFiltersData.setMetaproduct("EUROPE");
		parameterFiltersData.setProduct_code("EURMED7");
		parameterFiltersData.setShip_code("AL");
		parameterFiltersData.setSail_month(5);
		parameterFiltersData.setOccupancy("double");
		
		new GetInversionGapsParaDataHandler().handleRequest(null,
				new Context() {
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
		})
		;
	}
}
