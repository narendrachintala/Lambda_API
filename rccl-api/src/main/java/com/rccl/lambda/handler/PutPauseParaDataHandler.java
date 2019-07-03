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
import com.rccl.model.PausePara;
import com.rccl.model.validator.PauseParaDataValidator;
import com.rccl.service.PauseParaDataService;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResponseUtil;

/**
 * The Class PutPauseParaDataHandler.
 */
public class PutPauseParaDataHandler implements RequestHandler<PausePara, GatewayResponse<? extends Object>> {

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
	public GatewayResponse<? extends Object> handleRequest(PausePara request, Context context) {
		context.getLogger().log("Input request: " + request);
		boolean update = false;
		GatewayResponse<? extends Object> response = null;
		PauseParaDataValidator rDataValidator = null;
		ConfigUtil configInst = ConfigUtil.getInstance();
		String jobName = configInst.getTableName(RCCLConstants.PAUSE_PARA);
		try {
			rDataValidator = new PauseParaDataValidator();
			response = rDataValidator.validatePutRequest(request,jobName);
			if (response == null) { 
			PauseParaDataService PauseParaService = new PauseParaDataService();
			update = PauseParaService.updatePauseParaData(request);
			response = new GatewayResponse<Boolean>(update, ResponseUtil.getHeaders(),
					RCCLConstants.SC_OK);
			}
		} catch (Exception ex) {
			 logger.error("Error occured while executing PauseParaDataHandler: " + ex.getMessage());
			 return ResponseUtil.getErrorMessage(ex, RCCLConstants.SC_BAD_REQUEST);
		}
		System.out.println("value of update():" + update);
		return response;
	}

	public static void main(String[] args) {

		PausePara pausePara = new PausePara();
		// values to be updated
		pausePara.setL1_pause(0);

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

		new PutPauseParaDataHandler().handleRequest(pausePara,new Context() {
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
