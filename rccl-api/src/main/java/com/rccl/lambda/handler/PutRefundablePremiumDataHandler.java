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
import com.rccl.model.RefundablePremium;
import com.rccl.model.validator.RefundablePremiumDataValidator;
import com.rccl.service.RefundablePremiumService;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResponseUtil;

/**
 * The Class PutRefundablePremiumDataHandler.
 */
public class PutRefundablePremiumDataHandler
		implements RequestHandler<RefundablePremium, GatewayResponse<? extends Object>> {
	
	static {
		System.setProperty("log4j.configurationFile", "log4j2.xml");
	}

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(PutRefundablePremiumDataHandler.class);
	
	/**
	 * Handle request.
	 * @param request contains chosen filters as key-value pair
	 * @param context lambda context object
	 * @return true if update is successful
	 */
	public GatewayResponse<? extends Object> handleRequest(RefundablePremium request, Context context) {
		context.getLogger().log("Input request: " + request);
		boolean update = false;
		GatewayResponse<? extends Object> response = null;
		RefundablePremiumDataValidator rDataValidator = null;
		ConfigUtil configInst = ConfigUtil.getInstance();
		String jobName = configInst.getTableName(RCCLConstants.REFUNDABLE_PREMIUM);
		try {
			rDataValidator = new RefundablePremiumDataValidator();
			response = rDataValidator.validatePutRequest(request, jobName);
			if (response == null) {
				RefundablePremiumService refundablePremiumService = new RefundablePremiumService();
				update = refundablePremiumService.updateRefundablePremiumData(request);
				response = new GatewayResponse<Boolean>(update, ResponseUtil.getHeaders(), RCCLConstants.SC_OK);
			}
		} catch (Exception ex) {
			logger.error("Error occured while executing PutRefundablePremium: " + ex.getMessage());
			return ResponseUtil.getErrorMessage(ex, RCCLConstants.SC_BAD_REQUEST);

		}
		Gson gson = new Gson();
		String json = gson.toJson(response);
		
		System.out.println("Response:" + json);
		return response;
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]) {
		
		RefundablePremium refundablePremium = new RefundablePremium();
		refundablePremium.setGap_type("Standard");
		refundablePremium.setCurrent_gap_pct(10.0);
		refundablePremium.setStandard_gap_pct(20.0);
		
		ParameterFiltersData parameterFiltersData = new ParameterFiltersData();
		parameterFiltersData.setCat_class("O");
		parameterFiltersData.setMetaproduct("SHORT CARIBBEAN");
		parameterFiltersData.setOccupancy("quad");
		parameterFiltersData.setProduct_code("BAHAMA4");
		parameterFiltersData.setSail_month("3");
		parameterFiltersData.setShip_code("MJ");
		
		refundablePremium.setFiltersData(parameterFiltersData);
		
		Gson gson = new Gson();
		String json = gson.toJson(refundablePremium);
		
		System.out.println("Sample Input data:" + json);
		
		new PutRefundablePremiumDataHandler().handleRequest(refundablePremium, new Context() {

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
