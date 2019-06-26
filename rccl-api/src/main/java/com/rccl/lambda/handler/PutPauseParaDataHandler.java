package com.rccl.lambda.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.rccl.model.PausePara;
import com.rccl.model.validator.RollingWindowDataValidator;
import com.rccl.service.RollingWindowService;
import com.rccl.utils.helper.RCCLException;

public class PutPauseParaDataHandler implements RequestHandler<PausePara, Boolean> {
	
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
	public Boolean handleRequest(PausePara request, Context context) {
		context.getLogger().log("Input: " + request);
		boolean update = false;
		try {
			RollingWindowDataValidator rDataValidator = new RollingWindowDataValidator();
			//rDataValidator.validatePutRequest(request);
			RollingWindowService rollingWindowService = new RollingWindowService();
			//update = rollingWindowService.updateRollingWindowData(request, logger);
		} catch (Exception ex) {
			logger.error("Error occured while executing GetRollingWindowHandler: " + ex.getMessage());
			throw new RCCLException("Error occured while executing GetRollingWindowHandler", ex);
		}
		System.out.println("value of update():" + update);
		return update;

	
}
}
