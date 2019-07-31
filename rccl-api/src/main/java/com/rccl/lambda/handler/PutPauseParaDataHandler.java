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
import com.rccl.model.GatewayResponse;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.PausePara;
import com.rccl.model.validator.PauseParaDataValidator;
import com.rccl.service.PauseParaDataService;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResourceBundleUtility;
import com.rccl.utils.ResponseUtil;

/**
 * The Class PutPauseParaDataHandler.
 */
public class PutPauseParaDataHandler implements RequestHandler<ApiGatewayProxyRequest, GatewayResponse> {

	static {
		System.setProperty("log4j.configurationFile", "log4j2.xml");
	}

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(PutPauseParaDataHandler.class);
	
	// Read error messages from property file
	private static ResourceBundleUtility rBundleUtility = ResourceBundleUtility.getInstance();
	
	/** The instance. */
	// creating instance of class
	public static PutPauseParaDataHandler _instance = null;

	/**
	 * Gets the single instance of PutPauseParaDataHandler.
	 * 
	 * @return single instance of PutPauseParaDataHandler
	 */
	public static PutPauseParaDataHandler getInstance() {
		if (_instance == null) {
			_instance = new PutPauseParaDataHandler();
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
		String jobName = configInst.getTableName(RCCLConstants.PAUSE_PARA);
		try {
			
			PausePara request = new Gson().fromJson(req.getBody(), PausePara.class);
			context.getLogger().log("Input request: " + request);
			//Validates input Request
			PauseParaDataValidator rDataValidator = PauseParaDataValidator.getInstance();
			response = rDataValidator.validatePutRequest(request, jobName);
			if (response == null) {
				PauseParaDataService PauseParaService = PauseParaDataService.getInstance();
				update = PauseParaService.updatePauseParaData(request);
				if (update == true) {
					response = ResponseUtil.getCustErrorMessage(
							rBundleUtility.getValue(RCCLConstants.ERROR_UPDATE_RECORDS_SUCCESS), RCCLConstants.SC_OK,RCCLConstants.REQUEST_ID);
				} else {
					response = ResponseUtil.getCustErrorMessage(
							rBundleUtility.getValue(RCCLConstants.ERROR_UPDATE_RECORDS_FAILURE), RCCLConstants.SC_OK,RCCLConstants.REQUEST_ID);
				}
			}
		} catch (Exception ex) {
			 logger.error("Error occured while executing PauseParaDataHandler: " + ex.getMessage());
			 return ResponseUtil.getErrorMessage(ex, RCCLConstants.SC_BAD_REQUEST,RCCLConstants.REQUEST_ID);
		}
		System.out.println("value of update():" + update);
		Gson gson = new Gson();
		String json = gson.toJson(response);
		System.out.println("response ="+json);
		return response;
	}

	public static void main(String[] args) {

		PausePara pausePara = new PausePara();
		// values to be updated
		pausePara.setL1_pause(11);
		pausePara.setresume_push_wts(2);
		pausePara.setstop_push_wts(51);

		// filter criteria
		ParameterFiltersData parameterFiltersData = new ParameterFiltersData();
		parameterFiltersData.setCat_class("D");
		parameterFiltersData.setMetaproduct("OASIS");
		parameterFiltersData.setOccupancy("quad");
		parameterFiltersData.setProduct_code("7N CARIBBEAN");
		parameterFiltersData.setSail_month("12");
		parameterFiltersData.setShip_code("AL");
		parameterFiltersData.setCategory("A1");

		pausePara.setFiltersData(parameterFiltersData);
		Gson gson = new Gson();
		String json = gson.toJson(pausePara);

		System.out.println("Sample Input data:" + json);

		new PutPauseParaDataHandler().handleRequest(null
				,new Context() {
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
