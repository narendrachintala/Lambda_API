package com.rccl.lambda.handler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.rccl.dbutils.RevoreoConnect;
import com.rccl.model.ApiGatewayProxyRequest;
import com.rccl.model.CurrencyGapPara;
import com.rccl.model.GatewayResponse;
import com.rccl.model.validator.CurrencyGapDataValidator;
import com.rccl.service.CurrencyGapParaService;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResourceBundleUtility;
import com.rccl.utils.ResponseUtil;

/**
 * The Class PutCurrencyGapDataHandler.
 *
 * @author chandrabhan.birla
 */

public class PutCurrencyGapDataHandler implements RequestHandler<ApiGatewayProxyRequest, GatewayResponse> {
	
	/** The Constant logger. */
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(PutCurrencyGapDataHandler.class);

	static {
		System.setProperty("log4j.configurationFile", "log4j2.xml");
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(new Runnable() {
			public void run() {
				logger.info("executing run method to establish connection.");
				RevoreoConnect.getInstance().getConnection();
			}
		});
		executorService.shutdown();
	}

	// Read error messages from property file
	private static ResourceBundleUtility rBundleUtility = ResourceBundleUtility.getInstance();

	/** The instance. */
	// creating instance of class
	public static PutCurrencyGapDataHandler _instance = null;

	/**
	 * Gets the single instance of PutCurrencyGapDataHandler.
	 * 
	 * @return single instance of PutCurrencyGapDataHandler
	 */
	public static PutCurrencyGapDataHandler getInstance() {
		if (_instance == null) {
			_instance = new PutCurrencyGapDataHandler();
		}
		return _instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.amazonaws.services.lambda.runtime.RequestHandler#handleRequest(java.lang.
	 * Object, com.amazonaws.services.lambda.runtime.Context)
	 */
	@Override
	/**
	 * Post currency gap parameter data based on applied filters and requested data
	 * Handle request.
	 * 
	 * @param request contains chosen filters as key-value pair
	 * @param context lambda context object
	 * @return true if update is successful
	 */
	public GatewayResponse handleRequest(ApiGatewayProxyRequest req, Context context) {

		/**
		 * Assigning the AWS Lambda Request ID to Static Constant, which can be referred
		 * through out session
		 */
		RCCLConstants.REQUEST_ID = context.getAwsRequestId();

		Boolean result = false;
		ConfigUtil configInst = ConfigUtil.getInstance();
		String jobName = configInst.getTableName(RCCLConstants.CURRENCY_GAP_PARA);
		GatewayResponse response = null;
		try {
			
			CurrencyGapPara request = new Gson().fromJson(req.getBody(), CurrencyGapPara.class);
			logger.info("input: " + request.toString());
			//Validates input Request
			CurrencyGapDataValidator dataValidator = CurrencyGapDataValidator.getInstance();
			response = dataValidator.validatePutRequest(request, jobName);
			if (response == null) { // response null denotes request is valid
				CurrencyGapParaService currentPriceService = CurrencyGapParaService.getInstance();
				result = currentPriceService.updateCurrencyGapParaData(request);
				if (result == true) {
					response = ResponseUtil.getCustErrorMessage(
							rBundleUtility.getValue(RCCLConstants.ERROR_UPDATE_RECORDS_SUCCESS), RCCLConstants.SC_OK,
							RCCLConstants.REQUEST_ID);
				} else {
					response = ResponseUtil.getCustErrorMessage(
							rBundleUtility.getValue(RCCLConstants.ERROR_UPDATE_RECORDS_FAILURE), RCCLConstants.SC_OK,
							RCCLConstants.REQUEST_ID);
				}
			}
		} catch (Exception e) {
			logger.error("Error occured while executing PutCurrencyGapDataHandler: " + e);
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
		}
		return response;
	}
}
