package com.rccl.lambda.handler;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rccl.dbutils.RevoreoConnect;
import com.rccl.dto.CurrentPriceParaDTO;
import com.rccl.model.ApiGatewayProxyRequest;
import com.rccl.model.GatewayResponse;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.validator.RequestDataValidator;
import com.rccl.service.CurrentPriceParaService;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResourceBundleUtility;
import com.rccl.utils.ResponseUtil;

/**
 * @author chandrabhan.birla
 *
 */
public class GetCurrentPriceDataHandler
		implements RequestHandler<ApiGatewayProxyRequest, GatewayResponse> {

	static {
		System.setProperty("log4j.configurationFile", "log4j2.xml");
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(new Runnable() {
			public void run() {
				System.out.println("executing run method to establish connection.");
				RevoreoConnect.getInstance().getConnection();
			}
		});
		executorService.shutdown();
	}

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(GetCurrentPriceDataHandler.class);

	// Read error messages from property file
	private static ResourceBundleUtility rBundleUtility = ResourceBundleUtility.getInstance();
	
	/** The instance. */
	// creating instance of class
	public static GetCurrentPriceDataHandler _instance = null;

	/**
	 * Gets the single instance of GetCurrentPriceDataHandler.
	 * 
	 * @return single instance of GetCurrentPriceDataHandler
	 */
	public static GetCurrentPriceDataHandler getInstance() {
		if (_instance == null) {
			_instance = new GetCurrentPriceDataHandler();
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
	public GatewayResponse handleRequest(ApiGatewayProxyRequest req, Context context) {

		/**
		 * Assigning the AWS Lambda Request ID to Static Constant, which can be referred
		 * through out session
		 */
		RCCLConstants.REQUEST_ID = context.getAwsRequestId();

		List<CurrentPriceParaDTO> currentPriceParaList = null;
		GatewayResponse response = null;

		try {
			
			ParameterFiltersData request = new Gson().fromJson(req.getBody(), ParameterFiltersData.class);
			logger.info("Input: " + request.toString());
			// validating request data
			RequestDataValidator currentPriceValidator = RequestDataValidator.getInstance();
			response = currentPriceValidator.validateGetRequest(request);
			if (response == null) { // response null denotes request is valid

				CurrentPriceParaService currrentPriceService = CurrentPriceParaService.getInstance();
				currentPriceParaList = currrentPriceService.getCurrentPriceParaData(request);
				if (currentPriceParaList != null && currentPriceParaList.size() == 0) {
					response = ResponseUtil.getCustErrorMessage(
							rBundleUtility.getValue(RCCLConstants.ERROR_NO_RECORDS_FOUND), RCCLConstants.SC_OK,
							RCCLConstants.REQUEST_ID);
				} else {
					response = new GatewayResponse(currentPriceParaList,
							ResponseUtil.getHeaders(), RCCLConstants.SC_OK, RCCLConstants.REQUEST_ID);
				}
			}

		} catch (Exception e) {
			logger.error("Error occured while executing GetCurrentPriceDataHandler: " + e.getMessage());
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
		}
		// System.out.println(new
		// GsonBuilder().serializeNulls().create().toJson(response));
		return response;

	}

	/**
	 * The main method will be used for testing with sample data.
	 * 
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		/*
		 * ParameterFiltersData data = new ParameterFiltersData();
		 * data.setMetaproduct("OASIS"); System.out.println(new
		 * GsonBuilder().serializeNulls().create().toJson(data)); System.exit(0);
		 */

		ParameterFiltersData currentPricedata = new ParameterFiltersData();
		currentPricedata.setMetaproduct("OASIS");
		currentPricedata.setProduct_code("7N CARIBBEAN");
		currentPricedata.setCat_class("B");
		// currentPricedata.setCategory("TEST");
		currentPricedata.setOccupancy("quad");
		currentPricedata.setSail_date("23-NOV-19 12.00.00.000000000 AM");
		currentPricedata.setSail_month("11");

		GatewayResponse rcode = new GetCurrentPriceDataHandler().handleRequest(null,
				null);
		System.out.println(new GsonBuilder().serializeNulls().create().toJson(rcode));
		System.out.println(rcode.getStatusCode());
		System.out.println(rcode.getBody());
	}
}
