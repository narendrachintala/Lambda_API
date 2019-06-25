package com.rccl.lambda.handler;

import java.util.List;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.rccl.dto.PauseParaDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.validator.RequestDataValidator;
import com.rccl.service.PauseParaDataService;
import com.rccl.testdata.FiltersData;
import com.rccl.utils.helper.RCCLException;

/**
 * 
 * The Class PauseParaFiltersDataHandler.
 * 
 * Here PauseParaFiltersDataHandler implements RequestHandler where we will raise request
 */
public class PauseParaFiltersDataHandler implements RequestHandler<ParameterFiltersData, List<PauseParaDTO>> {
	

	/*
	 *  (non-Javadoc)
	 * @see com.amazonaws.services.lambda.runtime.RequestHandler#handleRequest(java.lang.Object, com.amazonaws.services.lambda.runtime.Context)
	 * 
	 */
	public List<PauseParaDTO> handleRequest(ParameterFiltersData request, Context context) {
		context.getLogger().log("Input: " + request);
		List<PauseParaDTO> pauseParaList = null;
		LambdaLogger logger = context.getLogger();
		
		try {
			RequestDataValidator pauseParaValidator = new RequestDataValidator();
			pauseParaValidator.validateGetRequest(request);
		
		
		PauseParaDataService pauseParaService = new PauseParaDataService();
		pauseParaList = pauseParaService.getPauseParaData(request,logger);
		} catch (Exception e) {
			logger.log("Error occured while executing GetPriceRangeDataHandler: " + e.getMessage());
			throw new RCCLException("Error occured while executing GetPriceRangeDataHandler", e);
		}

		Gson gson = new Gson();
		System.out.println(gson.toJson(pauseParaList));

		return pauseParaList;

	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * 
	 * generating sample data and sending it as request to PauseParaFiltersDataHandler.
	 * 
	 * 
	 */
	public static void main(String[] args) {
		
		new PauseParaFiltersDataHandler().handleRequest(FiltersData.getRequestData(), new Context() {
			
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
