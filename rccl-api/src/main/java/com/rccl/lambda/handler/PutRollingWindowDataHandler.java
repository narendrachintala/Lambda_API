package com.rccl.lambda.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.rccl.model.GatewayResponse;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.RollingWindow;
import com.rccl.model.validator.RollingWindowDataValidator;
import com.rccl.service.RollingWindowService;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResponseUtil;

/**
 * The Class PostRollingWindowDataHandler.
 */
public class PutRollingWindowDataHandler implements RequestHandler<RollingWindow, GatewayResponse<? extends Object>> {

	static {
		System.setProperty("log4j.configurationFile", "log4j2.xml");
	}

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(PutPauseParaDataHandler.class);

	/**
	 * Handle request.
	 * @param request contains chosen filters as key-value pair
	 * @param context lambda context object
	 * @return true if update is successful
	 */
	public GatewayResponse<? extends Object> handleRequest(RollingWindow request, Context context) {
		context.getLogger().log("Input request: " + request);
		boolean update = false;
		GatewayResponse<? extends Object> response = null;
		RollingWindowDataValidator rDataValidator = null;
		ConfigUtil configInst = ConfigUtil.getInstance();
		String jobName = configInst.getTableName(RCCLConstants.REFUNDABLE_PREMIUM);
		try {
			rDataValidator = new RollingWindowDataValidator();
			response = rDataValidator.validatePutRequest(request, jobName);
			if (response == null) {
				RollingWindowService rollingWindowService = new RollingWindowService();
				update = rollingWindowService.updateRollingWindowData(request);
				response = new GatewayResponse<Boolean>(update, ResponseUtil.getHeaders(), RCCLConstants.SC_OK);
			}
		} catch (Exception ex) {
			logger.error("Error occured while executing GetRollingWindowHandler: " + ex.getMessage());
			return ResponseUtil.getErrorMessage(ex, RCCLConstants.SC_BAD_REQUEST);

		}
		System.out.println("value of update():" + update);
		Gson gson = new Gson();
		String json = gson.toJson(response);
		System.out.println(json);
		return response;
	}
	
	/**
	 * The main method.
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		RollingWindow roWindow = new RollingWindow();
		// values to be updated
		roWindow.setPrev_forecast(9);
		roWindow.setFut_forecast(7);
		roWindow.setPrice_window(2);
		roWindow.setWts(59);
		
		// filter criteria
		ParameterFiltersData parameterFiltersData = new ParameterFiltersData();
		parameterFiltersData.setCat_class("O");
		parameterFiltersData.setMetaproduct("SHORT CARIBBEAN");
		parameterFiltersData.setOccupancy("quad");
		parameterFiltersData.setProduct_code("BAHAMA4");
		parameterFiltersData.setSail_month("3");
		parameterFiltersData.setShip_code("MJ");
		
		roWindow.setFiltersData(parameterFiltersData);
		Gson gson = new Gson();
		String json = gson.toJson(roWindow);
		
		System.out.println("Sample Input data:" + json);
		
		new PutRollingWindowDataHandler().handleRequest(roWindow, new Context() {
			
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
