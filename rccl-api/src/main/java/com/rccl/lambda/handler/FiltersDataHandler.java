package com.rccl.lambda.handler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.rccl.dbutils.RevoreoConnect;
import com.rccl.dto.FilterDataDTO;
import com.rccl.model.ApiGatewayProxyRequest;
import com.rccl.model.FiltersData;
import com.rccl.model.GatewayResponse;
import com.rccl.model.validator.FilterDataValidator;
import com.rccl.service.FilterDataService;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResponseUtil;

/**
 * @author narendra.chintala
 * 
 *         GetFilterDataHandler contains all filters related functions to pull
 *         data from all parameter tables based on dynamically provided table
 *         name
 */
public class FiltersDataHandler implements RequestHandler<ApiGatewayProxyRequest, GatewayResponse> {

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
	static final Logger logger = LogManager.getLogger(FiltersDataHandler.class);

	/** The instance. */
	// creating instance of class
	public static FiltersDataHandler _instance = null;

	/**
	 * Gets the single instance of FiltersDataHandler.
	 * 
	 * @return single instance of FiltersDataHandler
	 */
	public static FiltersDataHandler getInstance() {
		if (_instance == null) {
			_instance = new FiltersDataHandler();
		}
		return _instance;
	}

	/**
	 * executes on requesting for list of meta_products for specific table name
	 * 
	 * @param request contains chosen filters as key-value pair
	 * @param context lambda context object
	 * @return returns list of meta_product column values based on provided table
	 *         name
	 */
	@Override
	public GatewayResponse handleRequest(ApiGatewayProxyRequest req, Context context) {

		/**
		 * Assigning the AWS Lambda Request ID to Static Constant, which can be referred
		 * through out session
		 */
		RCCLConstants.REQUEST_ID = context.getAwsRequestId();

		FilterDataDTO dataDTO = null;
		GatewayResponse response = null;
		FilterDataValidator dataValidator = FilterDataValidator.getInstance();
		try {

			FiltersData request = new Gson().fromJson(req.getBody(), FiltersData.class);
			logger.info("input: " + request);
			response = dataValidator.validateGetRequest(request);
			if (response == null) {
				FilterDataService dataService = FilterDataService.getInstance();
				dataDTO = dataService.getFilterData(request, RCCLConstants.METAPRODUCT_F);
				response = new GatewayResponse(dataDTO, ResponseUtil.getHeaders(), RCCLConstants.SC_OK,
						RCCLConstants.REQUEST_ID);
			}
		} catch (Exception e) {
			logger.error("Error occurred while invoking rev_pre_getMetaProducts API: " + e.getCause());
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
		}

		return response;
	}

	/**
	 * executes on requesting list of product_codes for feeding filter drop-down in
	 * UI with provided table name
	 * 
	 * @param request contains chosen filters as key-value pair
	 * @param context lambda context object
	 * @return returns list of product_code column values based on provided table
	 *         name
	 */
	public GatewayResponse getProductCodes(ApiGatewayProxyRequest req, Context context) {

		FiltersData request = new Gson().fromJson(req.getBody(), FiltersData.class);
		logger.info("input: " + request);

		FilterDataDTO dataDTO = null;
		GatewayResponse response = null;
		FilterDataValidator dataValidator = FilterDataValidator.getInstance();
		try {
			response = dataValidator.validateGetRequest(request);
			if (response == null) {
				FilterDataService dataService = FilterDataService.getInstance();
				dataDTO = dataService.getFilterData(request, RCCLConstants.PRODUCT_CODE_F);
				response = new GatewayResponse(dataDTO, ResponseUtil.getHeaders(), RCCLConstants.SC_OK,
						RCCLConstants.REQUEST_ID);
			}
		} catch (Exception e) {
			logger.error("Error occurred while invoking rev_pre_getProductCodes API: " + e.getCause());
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
		}

		return response;
	}

	/**
	 * executes on requesting list of ship_codes for feeding filter drop-down in UI
	 * with provided table name
	 * 
	 * @param request contains chosen filters as key-value pair
	 * @param context lambda context object
	 * @return returns list of ship_code column values based on provided table name
	 */
	public GatewayResponse getShipCodes(ApiGatewayProxyRequest req, Context context) {

		FiltersData request = new Gson().fromJson(req.getBody(), FiltersData.class);
		logger.info("input: " + request);
		FilterDataDTO dataDTO = null;
		GatewayResponse response = null;
		FilterDataValidator dataValidator = FilterDataValidator.getInstance();
		try {
			response = dataValidator.validateGetRequest(request);
			if (response == null) {
				FilterDataService dataService = FilterDataService.getInstance();
				dataDTO = dataService.getFilterData(request, RCCLConstants.SHIP_CODE_F);
				response = new GatewayResponse(dataDTO, ResponseUtil.getHeaders(), RCCLConstants.SC_OK,
						RCCLConstants.REQUEST_ID);
			}
		} catch (Exception e) {
			logger.error("Error occurred while invoking rev_pre_getShipCodes API: " + e.getMessage());
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
		}
		return response;
	}

	/**
	 * executes on requesting list of sail_months for feeding filter drop-down in UI
	 * with provided table name
	 * 
	 * @param request contains chosen filters as key-value pair
	 * @param context lambda context object
	 * @return returns list of sail_month column values based on provided table name
	 */
	public GatewayResponse getSailMonths(ApiGatewayProxyRequest req, Context context) {

		FiltersData request = new Gson().fromJson(req.getBody(), FiltersData.class);
		logger.info("input: " + request);
		FilterDataDTO dataDTO = null;
		GatewayResponse response = null;
		FilterDataValidator dataValidator = FilterDataValidator.getInstance();
		try {
			response = dataValidator.validateGetRequest(request);
			if (response == null) {
				FilterDataService dataService = FilterDataService.getInstance();
				dataDTO = dataService.getFilterData(request, RCCLConstants.SAIL_MONTH_F);
				response = new GatewayResponse(dataDTO, ResponseUtil.getHeaders(), RCCLConstants.SC_OK,
						RCCLConstants.REQUEST_ID);
			}
		} catch (Exception e) {
			logger.error("Error occurred while invoking rev_pre_getSailMonths API: " + e.getMessage());
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
		}
		return response;
	}

	/**
	 * executes on requesting list of cat_classes for feeding filter drop-down in UI
	 * with provided table name
	 * 
	 * @param request contains chosen filters as key-value pair
	 * @param context lambda context object
	 * @return returns list of cat_classe column values based on provided table name
	 */

	public GatewayResponse getCatClasses(ApiGatewayProxyRequest req, Context context) {

		FiltersData request = new Gson().fromJson(req.getBody(), FiltersData.class);
		logger.info("input: " + request);
		FilterDataDTO dataDTO = null;
		GatewayResponse response = null;
		FilterDataValidator dataValidator = FilterDataValidator.getInstance();
		try {
			response = dataValidator.validateGetRequest(request);
			if (response == null) {
				FilterDataService dataService = FilterDataService.getInstance();
				dataDTO = dataService.getFilterData(request, RCCLConstants.CAT_CLASS_F);
				response = new GatewayResponse(dataDTO, ResponseUtil.getHeaders(), RCCLConstants.SC_OK,
						RCCLConstants.REQUEST_ID);
			}
		} catch (Exception e) {
			logger.error("Error occurred while invoking rev_pre_getCatClasses API: " + e.getMessage());
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
		}
		return response;
	}

	/**
	 * executes on requesting list of categories for feeding filter drop-down in UI
	 * with provided table name
	 * 
	 * @param request contains chosen filters as key-value pair
	 * @param context lambda context object
	 * @return returns list of category column values based on provided table name
	 */
	public GatewayResponse getCategories(ApiGatewayProxyRequest req, Context context) {

		FiltersData request = new Gson().fromJson(req.getBody(), FiltersData.class);
		logger.info("input: " + request);
		FilterDataDTO dataDTO = null;
		GatewayResponse response = null;
		FilterDataValidator dataValidator = FilterDataValidator.getInstance();
		try {
			response = dataValidator.validateGetRequest(request);
			if (response == null) {
				FilterDataService dataService = FilterDataService.getInstance();
				dataDTO = dataService.getFilterData(request, RCCLConstants.CATEGORY_F);
				response = new GatewayResponse(dataDTO, ResponseUtil.getHeaders(), RCCLConstants.SC_OK,
						RCCLConstants.REQUEST_ID);
			}
		} catch (Exception e) {
			logger.error("Error occurred while invoking rev_pre_getCategory API: " + e.getMessage());
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
		}
		return response;
	}

	/**
	 * executes on requesting list of occupancies for feeding filter drop-down in UI
	 * with provided table name
	 * 
	 * @param request contains chosen filters as key-value pair
	 * @param context lambda context object
	 * @return returns list of occupancy column values based on provided table name
	 */
	public GatewayResponse getOccupancy(ApiGatewayProxyRequest req, Context context) {

		FiltersData request = new Gson().fromJson(req.getBody(), FiltersData.class);
		logger.info("input: " + request);
		FilterDataDTO dataDTO = null;
		GatewayResponse response = null;
		FilterDataValidator dataValidator = FilterDataValidator.getInstance();
		try {
			response = dataValidator.validateGetRequest(request);
			if (response == null) {
				FilterDataService dataService = FilterDataService.getInstance();
				dataDTO = dataService.getFilterData(request, RCCLConstants.OCCUPANCY_F);
				response = new GatewayResponse(dataDTO, ResponseUtil.getHeaders(), RCCLConstants.SC_OK,
						RCCLConstants.REQUEST_ID);
			}
		} catch (Exception e) {
			logger.error("Error occurred while invoking rev_pre_getOccupancies API: " + e.getMessage());
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
		}
		return response;
	}

}
