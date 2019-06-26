package com.rccl.lambda.handler;


import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.PausePara;
import com.rccl.model.RollingWindow;
import com.rccl.model.validator.RollingWindowDataValidator;
import com.rccl.service.RollingWindowService;
import com.rccl.utils.helper.RCCLException;

public class PutPauseParaDataHandler implements RequestHandler<PausePara, Boolean>{
	
	/**
	 * Handle request.
	 * @param request contains chosen filters as key-value pair
	 * @param context lambda context object
	 * @return true if update is successful
	 */
	public Boolean handleRequest(PausePara request, Context context) {
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
