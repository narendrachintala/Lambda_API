package com.rccl.lambda.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.rccl.dto.FilterDataDTO;
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
public class FiltersDataHandler implements RequestHandler<FiltersData, GatewayResponse<? extends Object>> {

	static {
		System.setProperty("log4j.configurationFile", "log4j2.xml");
	}

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(FiltersDataHandler.class);

	/**
	 * executes on requesting for list of meta_products for specific table name
	 * 
	 * @param request contains chosen filters as key-value pair
	 * @param context lambda context object
	 * @return returns list of meta_product column values based on provided table
	 *         name
	 */
	@Override
	public GatewayResponse<? extends Object> handleRequest(FiltersData request, Context context) {
		logger.info("input: " + request);

		/**
		 * Assigning the AWS Lambda Request ID to Static Constant, which can be referred
		 * through out session
		 */
		RCCLConstants.REQUEST_ID = context.getAwsRequestId();

		FilterDataService dataService = null;
		FilterDataDTO dataDTO = null;
		GatewayResponse<? extends Object> response = null;
		FilterDataValidator dataValidator = new FilterDataValidator();
		try {
			response = dataValidator.validateGetRequest(request);
			if (response == null) {
				dataService = new FilterDataService();
				dataDTO = dataService.getFilterData(request, RCCLConstants.METAPRODUCT_F);
				response = new GatewayResponse<FilterDataDTO>(dataDTO, ResponseUtil.getHeaders(), RCCLConstants.SC_OK,
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
	public GatewayResponse<? extends Object> getProductCodes(FiltersData request, Context context) {
		logger.info("input: " + request);

		FilterDataService dataService = null;
		FilterDataDTO dataDTO = null;
		GatewayResponse<? extends Object> response = null;
		FilterDataValidator dataValidator = new FilterDataValidator();
		try {
			response = dataValidator.validateGetRequest(request);
			if (response == null) {
				dataService = new FilterDataService();
				dataDTO = dataService.getFilterData(request, RCCLConstants.PRODUCT_CODE_F);
				response = new GatewayResponse<FilterDataDTO>(dataDTO, ResponseUtil.getHeaders(), RCCLConstants.SC_OK,
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
	public GatewayResponse<? extends Object> getShipCodes(FiltersData request, Context context) {
		logger.info("input: " + request);
		FilterDataService dataService = null;
		FilterDataDTO dataDTO = null;
		GatewayResponse<? extends Object> response = null;
		FilterDataValidator dataValidator = new FilterDataValidator();
		try {
			response = dataValidator.validateGetRequest(request);
			if (response == null) {
				dataService = new FilterDataService();
				dataDTO = dataService.getFilterData(request, RCCLConstants.SHIP_CODE_F);
				response = new GatewayResponse<FilterDataDTO>(dataDTO, ResponseUtil.getHeaders(), RCCLConstants.SC_OK,
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
	public GatewayResponse<? extends Object> getSailMonths(FiltersData request, Context context) {
		logger.info("input: " + request);
		FilterDataService dataService = null;
		FilterDataDTO dataDTO = null;
		GatewayResponse<? extends Object> response = null;
		FilterDataValidator dataValidator = new FilterDataValidator();
		try {
			response = dataValidator.validateGetRequest(request);
			if (response == null) {
				dataService = new FilterDataService();
				dataDTO = dataService.getFilterData(request, RCCLConstants.SAIL_MONTH_F);
				response = new GatewayResponse<FilterDataDTO>(dataDTO, ResponseUtil.getHeaders(), RCCLConstants.SC_OK,
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

	public GatewayResponse<? extends Object> getCatClasses(FiltersData request, Context context) {
		logger.info("input: " + request);
		FilterDataService dataService = null;
		FilterDataDTO dataDTO = null;
		GatewayResponse<? extends Object> response = null;
		FilterDataValidator dataValidator = new FilterDataValidator();
		try {
			response = dataValidator.validateGetRequest(request);
			if (response == null) {
				dataService = new FilterDataService();
				dataDTO = dataService.getFilterData(request, RCCLConstants.CAT_CLASS_F);
				response = new GatewayResponse<FilterDataDTO>(dataDTO, ResponseUtil.getHeaders(), RCCLConstants.SC_OK,
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
	public GatewayResponse<? extends Object> getCategories(FiltersData request, Context context) {
		logger.info("input: " + request);
		FilterDataService dataService = null;
		FilterDataDTO dataDTO = null;
		GatewayResponse<? extends Object> response = null;
		FilterDataValidator dataValidator = new FilterDataValidator();
		try {
			response = dataValidator.validateGetRequest(request);
			if (response == null) {
				dataService = new FilterDataService();
				dataDTO = dataService.getFilterData(request, RCCLConstants.CATEGORY_F);
				response = new GatewayResponse<FilterDataDTO>(dataDTO, ResponseUtil.getHeaders(), RCCLConstants.SC_OK,
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
	public GatewayResponse<? extends Object> getOccupancy(FiltersData request, Context context) {
		logger.info("input: " + request);
		FilterDataService dataService = null;
		FilterDataDTO dataDTO = null;
		GatewayResponse<? extends Object> response = null;
		FilterDataValidator dataValidator = new FilterDataValidator();
		try {
			response = dataValidator.validateGetRequest(request);
			if (response == null) {
				dataService = new FilterDataService();
				dataDTO = dataService.getFilterData(request, RCCLConstants.OCCUPANCY_F);
				response = new GatewayResponse<FilterDataDTO>(dataDTO, ResponseUtil.getHeaders(), RCCLConstants.SC_OK,
						RCCLConstants.REQUEST_ID);
			}
		} catch (Exception e) {
			logger.error("Error occurred while invoking rev_pre_getOccupancies API: " + e.getMessage());
			return ResponseUtil.getErrorMessage(e, RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
		}
		return response;
	}

}
