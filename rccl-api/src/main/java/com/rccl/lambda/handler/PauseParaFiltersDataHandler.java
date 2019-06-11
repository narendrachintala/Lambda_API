package com.rccl.lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.rccl.service.FilterDataService;

public class PauseParaFiltersDataHandler implements RequestHandler<Object,String> {

	@Override
	public String handleRequest(Object input, Context context) {
		context.getLogger().log("Input: " + input);
		FilterDataService dataService = new FilterDataService();
		String response = dataService.getFiltersData();
		return response;
	}

}
