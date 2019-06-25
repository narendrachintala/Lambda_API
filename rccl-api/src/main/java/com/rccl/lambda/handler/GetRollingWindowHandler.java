package com.rccl.lambda.handler;

import java.util.List;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.rccl.dto.RollingWindowDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.validator.RequestDataValidator;
import com.rccl.service.RollingWindowService;
import com.rccl.utils.helper.RCCLException;

/**
 * The Class RollingWindowHandler.
 */
// Start of Lambda Function request
public class GetRollingWindowHandler implements RequestHandler<ParameterFiltersData, List<RollingWindowDTO>> {
	
	/**
	 * executes on requesting for list of values for specific table name
	 * @param request contains chosen filters as key-value pair
	 * @param context lambda context object
	 * @return the list of column values based on provided tablename
	 */
	public List<RollingWindowDTO> handleRequest(ParameterFiltersData request, Context context) {
		context.getLogger().log("Input: " + request);
		LambdaLogger logger = context.getLogger();
		
		List<RollingWindowDTO> rollingWindowList = null;
		try {
			RequestDataValidator requestDataValidator = new RequestDataValidator();
			requestDataValidator.validateGetRequest(request);
			RollingWindowService rollingWindowService = new RollingWindowService();
			rollingWindowList = rollingWindowService.getRollingWindowData(request, logger);
		}
		catch (Exception ex) {
			logger.log("Error occured while executing GetRollingWindowHandler: " + ex.getMessage());
			throw new RCCLException("Error occured while executing GetRollingWindowHandler", ex);
		}
		System.out.println("result set size:" + rollingWindowList.size());
		Gson gson = new Gson();
		System.out.println("final Result:" + gson.toJson(rollingWindowList));
		return rollingWindowList;
	}

	/**
	 * The main method.
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// prepares sample input data for handler class
		ParameterFiltersData parameterFiltersData = new ParameterFiltersData();
		parameterFiltersData.setCat_class("N");
		parameterFiltersData.setCategory("double");
		parameterFiltersData.setMetaproduct("OASIS");
		parameterFiltersData.setOccupancy("quad");
		parameterFiltersData.setProduct_code("7N CARIBBEAN");
		parameterFiltersData.setSail_month("10");
		parameterFiltersData.setShip_code("HM");
		new GetRollingWindowHandler().handleRequest(parameterFiltersData, new Context() {
			
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
