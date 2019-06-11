package com.rccl.lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.rccl.dto.FilterDataDTO;
import com.rccl.service.FilterDataService;

public class PriceRangeFiltersDataHandler implements RequestHandler<Object, FilterDataDTO> {

	@Override
	public FilterDataDTO handleRequest(Object input, Context context) {
		context.getLogger().log("Input: " + input);
		
		  FilterDataService dataService = new FilterDataService(); FilterDataDTO response =
		  dataService.getFilterData(null, null); 
		  return response;
		 
	}

}
