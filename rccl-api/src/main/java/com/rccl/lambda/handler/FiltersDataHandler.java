package com.rccl.lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.rccl.dto.FilterDataDTO;
import com.rccl.model.FiltersData;
import com.rccl.service.FilterDataService;
import com.rccl.utils.RCCLConstants;

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
		}

		return response;
	}

	
}
