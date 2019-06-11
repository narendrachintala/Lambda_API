package com.rccl.lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.rccl.service.FilterDataService;

public class PriceRangeFiltersDataHandler implements RequestHandler<Object, String> {

	@Override
	public String handleRequest(Object input, Context context) {
		context.getLogger().log("Input: " + input);
		
		  FilterDataService dataService = new FilterDataService(); String response =
		  dataService.getFiltersData(); 
		  return response;
		 
		/*
		 * String response =
		 * "{OASIS:{7N CARIBBEAN:{AL:{1:{2020-01-05 00:00:00:{B:quad, double,D:quad,I:quad, double}}}}}}"
		 * ; return response;
		 */

	}

}
