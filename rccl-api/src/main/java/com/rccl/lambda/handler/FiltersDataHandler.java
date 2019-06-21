package com.rccl.lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.rccl.dto.FilterDataDTO;
import com.rccl.model.FiltersData;
import com.rccl.service.FilterDataService;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.helper.RCCLException;

/**
 * @author narendra.chintala
 * 
 *         GetFilterDataHandler contains all filters related functions to pull
 *         data from all parameter tables based on dynamically provided table
 *         name
 */
public class FiltersDataHandler implements RequestHandler<FiltersData, FilterDataDTO> {

	/**
	 * executes on requesting for list of meta_products for specific table name
	 * 
	 * @param request contains chosen filters as key-value pair
	 * @param context lambda context object
	 * @return returns list of meta_product column values based on provided table
	 *         name
	 */
	@Override
	public FilterDataDTO handleRequest(FiltersData request, Context context) {
		context.getLogger().log("input: " + request);
		FilterDataService dataService = null;
		FilterDataDTO response = null;
		try {
			dataService = new FilterDataService();
			response = dataService.getFilterData(request, RCCLConstants.METAPRODUCT_F);
		} catch (Exception e) {
			context.getLogger().log("Error occurred while invoking rev_pre_getMetaProducts API: " + e.getMessage());
			throw new RCCLException("Error occurred while invoking rev_pre_getMetaProducts API: ", e.getCause());
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
	public FilterDataDTO getProductCodes(FiltersData request, Context context) {
		context.getLogger().log("input: " + request);

		FilterDataService dataService = null;
		FilterDataDTO response = null;
		try {
			dataService = new FilterDataService();
			response = dataService.getFilterData(request, RCCLConstants.PRODUCT_CODE_F);
		} catch (Exception e) {
			context.getLogger().log("Error occurred while invoking rev_pre_getProductCodes API: " + e.getMessage());
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
	public FilterDataDTO getShipCodes(FiltersData request, Context context) {
		FilterDataService dataService = null;
		FilterDataDTO response = null;
		try {
			dataService = new FilterDataService();
			response = dataService.getFilterData(request, RCCLConstants.SHIP_CODE_F);
		} catch (Exception e) {
			context.getLogger().log("Error occurred while invoking rev_pre_getShipCodes API: " + e.getMessage());
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
	public FilterDataDTO getSailMonths(FiltersData request, Context context) {
		FilterDataService dataService = null;
		FilterDataDTO response = null;
		try {
			dataService = new FilterDataService();
			response = dataService.getFilterData(request, RCCLConstants.SAIL_MONTH_F);
		} catch (Exception e) {
			context.getLogger().log("Error occurred while invoking rev_pre_getSailMonths API: " + e.getMessage());
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

	public FilterDataDTO getCatClasses(FiltersData request, Context context) {
		FilterDataService dataService = null;
		FilterDataDTO response = null;
		try {
			dataService = new FilterDataService();
			response = dataService.getFilterData(request, RCCLConstants.CAT_CLASS_F);
		} catch (Exception e) {
			context.getLogger().log("Error occurred while invoking rev_pre_getCatClasses API: " + e.getMessage());
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
	public FilterDataDTO getCategories(FiltersData request, Context context) {
		FilterDataService dataService = null;
		FilterDataDTO response = null;
		try {
			dataService = new FilterDataService();
			response = dataService.getFilterData(request, RCCLConstants.CATEGORY_F);
		} catch (Exception e) {
			context.getLogger().log("Error occurred while invoking rev_pre_getCategory API: " + e.getMessage());
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
	public FilterDataDTO getOccupancy(FiltersData request, Context context) {
		FilterDataService dataService = null;
		FilterDataDTO response = null;
		try {
			dataService = new FilterDataService();
			response = dataService.getFilterData(request, RCCLConstants.OCCUPANCY_F);
		} catch (Exception e) {
			context.getLogger().log("Error occurred while invoking rev_pre_getOccupancies API: " + e.getMessage());
		}
		return response;
	}

}
