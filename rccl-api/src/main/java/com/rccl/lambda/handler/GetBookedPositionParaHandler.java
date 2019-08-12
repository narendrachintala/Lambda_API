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
import com.rccl.dto.BookedPositionDTO;
import com.rccl.model.ApiGatewayProxyRequest;
import com.rccl.model.GatewayResponse;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.validator.RequestDataValidator;
import com.rccl.service.BookedPositionParaService;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResourceBundleUtility;
import com.rccl.utils.ResponseUtil;

/**
 * The Class GetBookedPositionPara.
 */

public class GetBookedPositionParaHandler implements RequestHandler<ApiGatewayProxyRequest, GatewayResponse> {

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(GetRollingWindowHandler.class);
		
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
	public static GetBookedPositionParaHandler _instance = null;

	/**
	 * Gets the single instance of GetBookedPositionParaHandler.
	 * 
	 * @return single instance of GetBookedPositionParaHandler
	 */
	public static GetBookedPositionParaHandler getInstance() {
		if (_instance == null) {
			_instance = new GetBookedPositionParaHandler();
		}
		return _instance;
	}

	/**
	 * executes on requesting for list of values for specific table name.
	 *
	 * @param request contains chosen filters as key-value pair
	 * @param context lambda context object
	 * @return the list of column values based on provided tablename
	 */
	public GatewayResponse handleRequest(ApiGatewayProxyRequest req, Context context) {
		
		logger.info("Handler started");
		RCCLConstants.REQUEST_ID = context.getAwsRequestId();
		GatewayResponse response = null;
		List<BookedPositionDTO> bookedPositionlist = null;
		RequestDataValidator requestDataValidator = RequestDataValidator.getInstance();
		try {
			
			ParameterFiltersData request = new Gson().fromJson(req.getBody(), ParameterFiltersData.class);
			logger.info("Input request: " + request);
			// Validate input request
			response = requestDataValidator.validateGetRequest(request);
			if (response == null) { // response null denotes request is valid
				BookedPositionParaService bookedPositionParaService = BookedPositionParaService.getInstance();
				bookedPositionlist = bookedPositionParaService.getBookedPositionData(request);
				if (bookedPositionlist != null && bookedPositionlist.size() == 0) {
					response = ResponseUtil.getCustErrorMessage(
							rBundleUtility.getValue(RCCLConstants.ERROR_NO_RECORDS_FOUND), RCCLConstants.SC_OK,
							RCCLConstants.REQUEST_ID);
				} else {
					response = new GatewayResponse(bookedPositionlist,
							ResponseUtil.getHeaders(), RCCLConstants.SC_OK, RCCLConstants.REQUEST_ID);
				}

			}
		} catch (Exception ex) {
			logger.error("Error occured while executing GetBookedPositionPara: " + ex.getMessage());
			response = ResponseUtil.getErrorMessage(ex, RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
		}
		logger.info(new GsonBuilder().serializeNulls().create().toJson(response));
		return response;
	}

	/**
	 * The main method.
	 * 
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// prepares sample input data for handler class

		ParameterFiltersData parameterFiltersData = new ParameterFiltersData();
		parameterFiltersData.setMetaproduct("SHORT CARIBBEAN");
		parameterFiltersData.setProduct_code("PRTCNVR3");
		parameterFiltersData.setSail_month(8);
		parameterFiltersData.setShip_code("MA");

		new GetBookedPositionParaHandler().handleRequest(null, new Context() {

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
