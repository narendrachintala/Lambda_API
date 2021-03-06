package com.rccl.lambda.handler;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.rccl.dbutils.RevoreoConnect;
import com.rccl.dto.PriceRangeDTO;
import com.rccl.model.ApiGatewayProxyRequest;
import com.rccl.model.GatewayResponse;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.validator.RequestDataValidator;
import com.rccl.service.PriceRangeService;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResourceBundleUtility;
import com.rccl.utils.ResponseUtil;

/**
 * @author narendra.chintala
 *
 */

/**
 * The Class GetPriceRangeDataHandler.
 */
public class GetPriceRangeDataHandler implements RequestHandler<ApiGatewayProxyRequest, GatewayResponse> {

	/** The Constant logger. */
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(GetPriceRangeDataHandler.class);

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
	public static GetPriceRangeDataHandler _instance = null;

	/**
	 * Gets the single instance of GetPriceRangeDataHandler.
	 * 
	 * @return single instance of GetPriceRangeDataHandler
	 */
	public static GetPriceRangeDataHandler getInstance() {
		if (_instance == null) {
			_instance = new GetPriceRangeDataHandler();
		}
		return _instance;
	}

	/**
	 * This method will be invoked from AWS Lambda function to fetch price range
	 * parameter data based on provided filter criteria.
	 *
	 * @param request the request
	 * @param context the context
	 * @return the gateway response
	 * @see com.amazonaws.services.lambda.runtime.RequestHandler#handleRequest(java.lang.
	 *      Object, com.amazonaws.services.lambda.runtime.Context)
	 */
	public GatewayResponse handleRequest(final ApiGatewayProxyRequest req, final Context context) {

		/**
		 * Assigning the AWS Lambda Request ID to Static Constant, which can be referred
		 * through out session
		 */
		RCCLConstants.REQUEST_ID = context.getAwsRequestId();

		List<PriceRangeDTO> priceRangeList = null;
		GatewayResponse response = null;

		try {

			ParameterFiltersData request = new Gson().fromJson(req.getBody(), ParameterFiltersData.class);
			logger.info("Input: " + request.toString());
			// validating request data
			RequestDataValidator priceRangeValidator = RequestDataValidator.getInstance();
			response = priceRangeValidator.validateGetRequest(request);
			if (response == null) { // response null denotes request is valid

				PriceRangeService priceRangeService = PriceRangeService.getInstance();
				priceRangeList = priceRangeService.getPriceRangeData(request);
				if (priceRangeList != null && priceRangeList.size() == 0) {
					response = ResponseUtil.getCustErrorMessage(
							rBundleUtility.getValue(RCCLConstants.ERROR_NO_RECORDS_FOUND), RCCLConstants.SC_OK,
							RCCLConstants.REQUEST_ID);
				} else {
					response = new GatewayResponse(priceRangeList, ResponseUtil.getHeaders(), RCCLConstants.SC_OK,
							RCCLConstants.REQUEST_ID);
				}
			}

		} catch (Exception e) {
			logger.error("Error occured while executing GetPriceRangeDataHandler: " + e.getMessage());
			e.printStackTrace();
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
		}
		return response;
	}
}
