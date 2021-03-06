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
import com.rccl.dbutils.RevoreoConnect;
import com.rccl.model.ApiGatewayProxyRequest;
import com.rccl.model.BookedPosition;
import com.rccl.model.GatewayResponse;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.validator.BookPositionDataValidator;
import com.rccl.service.BookedPositionParaService;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResourceBundleUtility;
import com.rccl.utils.ResponseUtil;

/**
 * The Class PutBookedPositionParaHandler.
 */
public class PutBookedPositionParaHandler implements RequestHandler<ApiGatewayProxyRequest, GatewayResponse> {
	
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(PutRefundablePremiumDataHandler.class);

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
	public static PutBookedPositionParaHandler _instance = null;

	/**
	 * Gets the single instance of PutBookedPositionParaHandler.
	 * 
	 * @return single instance of PutBookedPositionParaHandler
	 */
	public static PutBookedPositionParaHandler getInstance() {
		if (_instance == null) {
			_instance = new PutBookedPositionParaHandler();
		}
		return _instance;
	}


	/**
	 * Handle request.
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

		boolean update = false;
		GatewayResponse response = null;
		ConfigUtil configInst = ConfigUtil.getInstance();
		String jobName = configInst.getTableName(RCCLConstants.BOOKED_POSITION_PARA);
		try {
			
			BookedPosition request = new Gson().fromJson(req.getBody(), BookedPosition.class);
			logger.info("Input request: " + request);
			//Validate input Request
			BookPositionDataValidator rDataValidator = BookPositionDataValidator.getInstance();
			response = rDataValidator.validatePutRequest(request, jobName);
			if (response == null) {
				BookedPositionParaService bookedPositionParaService = BookedPositionParaService.getInstance();
				update = bookedPositionParaService.updateBookedPositionData(request);
				if (update == true) {
					response = ResponseUtil.getCustErrorMessage(
							rBundleUtility.getValue(RCCLConstants.ERROR_UPDATE_RECORDS_SUCCESS), RCCLConstants.SC_OK,
							RCCLConstants.REQUEST_ID);
				} else {
					response = ResponseUtil.getCustErrorMessage(
							rBundleUtility.getValue(RCCLConstants.ERROR_UPDATE_RECORDS_FAILURE), RCCLConstants.SC_OK,
							RCCLConstants.REQUEST_ID);
				}
			}
		} catch (Exception ex) {
			logger.error("Error occured while executing PutBookedPositionParaHandler: " + ex.getMessage());
			return ResponseUtil.getErrorMessage(ex, RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);

		}
		Gson gson = new Gson();
		String json = gson.toJson(response);

		logger.info("Response:" + json);
		return response;
	}
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]) {
		BookedPosition bookedposition= new BookedPosition();
		bookedposition.setBooked_position(1.0);
		
		ParameterFiltersData parameterFiltersData = new ParameterFiltersData();
		parameterFiltersData.setMetaproduct("SHORT CARIBBEAN");
		parameterFiltersData.setProduct_code("PRTCNVR3");
		parameterFiltersData.setSail_month(8);
		parameterFiltersData.setShip_code("MA");
		
		bookedposition.setFiltersData(parameterFiltersData);
		
		Gson gson = new Gson();
		String json = gson.toJson(bookedposition);

		logger.info("Sample Input data:" + json);
		
		new PutBookedPositionParaHandler().handleRequest(null, 
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
		});
	}
}
