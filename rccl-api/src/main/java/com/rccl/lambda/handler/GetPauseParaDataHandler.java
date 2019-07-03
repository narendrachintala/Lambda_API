package com.rccl.lambda.handler;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.GsonBuilder;
import com.rccl.dto.PauseParaDTO;
import com.rccl.model.GatewayResponse;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.validator.RequestDataValidator;
import com.rccl.service.PauseParaDataService;
import com.rccl.testdata.FiltersData;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResponseUtil;

/**
 * The Class PauseParaDataHandler.
 */
public class GetPauseParaDataHandler
		implements RequestHandler<ParameterFiltersData, GatewayResponse<? extends Object>> {

	static {
		System.setProperty("log4j.configurationFile", "log4j2.xml");
	}

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(GetPauseParaDataHandler.class);

	/**
	 * executes on requesting for list of values for PausePara table name.
	 * 
	 * @param request contains chosen filters as key-value pair
	 * @param context lambda context object
	 * @return the list of column values based on provided PausePara table name.
	 */
	public GatewayResponse<? extends Object> handleRequest(ParameterFiltersData request, Context context) {
		logger.info("Input: " + request);
		List<PauseParaDTO> pauseParaList = null;
		GatewayResponse<? extends Object> response = null;
		RequestDataValidator pauseParaValidator = null;
		try {
			// Validate input request if any error occurred throw custom exception.
			pauseParaValidator = new RequestDataValidator();
			response = pauseParaValidator.validateGetRequest(request);
			if (response == null) { // response null denotes request is valid
				PauseParaDataService pauseParaService = new PauseParaDataService();
				pauseParaList = pauseParaService.getPauseParaData(request);
				response = new GatewayResponse<List<PauseParaDTO>>(pauseParaList, ResponseUtil.getHeaders(),
						RCCLConstants.SC_OK);
			}
		} catch (Exception e) {
			//logger.error("Error occured while executing GetPauseParaDataHandler: " + e.getMessage());
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST);
		}
		System.out.println(new GsonBuilder().serializeNulls().create().toJson(response));
		return response;
	}

	/**
	 * The main method.
	 * 
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		new GetPauseParaDataHandler().handleRequest(FiltersData.getRequestData(),
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
