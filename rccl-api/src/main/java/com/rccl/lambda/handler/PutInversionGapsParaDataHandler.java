package com.rccl.lambda.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.rccl.model.GatewayResponse;
import com.rccl.model.InversionGapPara;
import com.rccl.model.PriceRange;
import com.rccl.model.validator.PriceRangeDataValidator;
import com.rccl.service.PriceRangeService;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResourceBundleUtility;
import com.rccl.utils.ResponseUtil;

public class PutInversionGapsParaDataHandler implements RequestHandler<InversionGapPara, GatewayResponse<? extends Object>> {{

	static {
		System.setProperty("log4j.configurationFile", "log4j2.xml");
	}
	/** The Constant logger. */
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(PutPriceRangeDataHandler.class);
	
	// Read error messages from property file
	private static ResourceBundleUtility rBundleUtility = ResourceBundleUtility.getInstance();
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.amazonaws.services.lambda.runtime.RequestHandler#handleRequest(java.lang.
	 * Object, com.amazonaws.services.lambda.runtime.Context)
	 */
	@Override
	/**
	 * Post price range data based on applied filters and requested data
	 */
	public GatewayResponse<? extends Object> handleRequest(InversionGapPara request, Context context) {
		logger.info("input: " + request.toString());
		Boolean result = false;
		PriceRangeDataValidator dataValidator = null;
		GatewayResponse<? extends Object> response = null;
		ConfigUtil configInst = ConfigUtil.getInstance();
		String jobName = configInst.getTableName(RCCLConstants.PRICE_RANGE_PARA);
		try {
			dataValidator = PriceRangeDataValidator.getInstance();
			response = dataValidator.validatePutRequest(request, jobName);
			if (response == null) { // response null denotes request is valid
				PriceRangeService priceRangeService = new PriceRangeService();
				result = priceRangeService.updatePriceRangeData(request);
				if (result == true) {
					response = ResponseUtil.getCustErrorMessage(
							rBundleUtility.getValue(RCCLConstants.ERROR_UPDATE_RECORDS_SUCCESS), RCCLConstants.SC_OK);
				} else {
					response = ResponseUtil.getCustErrorMessage(
							rBundleUtility.getValue(RCCLConstants.ERROR_UPDATE_RECORDS_FAILURE), RCCLConstants.SC_OK);
				}
			}
		} catch (Exception e) {
			logger.error("Error occured while executing PutPriceRangeDataHandler: " + e);
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST);
		}
		return response;
	}

}
