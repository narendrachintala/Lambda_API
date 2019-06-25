package com.rccl.lambda.handler;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.RollingWindow;
import com.rccl.model.validator.RollingWindowDataValidator;
import com.rccl.service.RollingWindowService;
import com.rccl.utils.helper.RCCLException;

/**
 * The Class PostRollingWindowDataHandler.
 */
public class PutRollingWindowDataHandler implements RequestHandler<RollingWindow, Boolean> {
	/**
	 * Handle request.
	 * @param request contains chosen filters as key-value pair
	 * @param context lambda context object
	 * @return true if update is successful
	 */
	public Boolean handleRequest(RollingWindow request, Context context) {
		context.getLogger().log("Input: " + request);
		LambdaLogger logger = context.getLogger();
		boolean update = false;
		try {
			RollingWindowDataValidator rDataValidator = new RollingWindowDataValidator();
			rDataValidator.validatePutRequest(request);
			RollingWindowService rollingWindowService = new RollingWindowService();
			update = rollingWindowService.updateRollingWindowData(request, logger);
		} catch (Exception ex) {
			logger.log("Error occured while executing GetRollingWindowHandler: " + ex.getMessage());
			throw new RCCLException("Error occured while executing GetRollingWindowHandler", ex);
		}
		System.out.println("value of update():" + update);
		return update;
	}
	
	/**
	 * The main method.
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		RollingWindow roWindow = new RollingWindow();
		// values to be updated
		roWindow.setPrev_forecast(9);
		roWindow.setFut_forecast(6);
		roWindow.setPrice_window(3);
		roWindow.setWts(59);
		
		// filter criteria
		ParameterFiltersData parameterFiltersData = new ParameterFiltersData();
		parameterFiltersData.setCat_class("N");
		parameterFiltersData.setMetaproduct("CANADA");
		parameterFiltersData.setOccupancy("double");
		parameterFiltersData.setProduct_code("CANADA");
		parameterFiltersData.setSail_month("6");
		parameterFiltersData.setShip_code("OA");
		
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
