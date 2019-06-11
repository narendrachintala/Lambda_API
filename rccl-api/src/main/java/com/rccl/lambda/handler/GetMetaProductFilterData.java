package com.rccl.lambda.handler;

import java.util.List;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.rccl.dto.FilterDataDTO;
import com.rccl.service.FilterDataService;
import com.rccl.testdata.FiltersData;
import com.rccl.utils.RCCLConstants;

/**
 * 
 * @author narendra.chintala
 *
 */
public class GetMetaProductFilterData implements RequestHandler<Map<String, List<String>>, FilterDataDTO> {

	@Override
	public FilterDataDTO handleRequest(Map<String, List<String>> requestMap, Context context) {
		Gson gson = new Gson();
		System.out.println(gson.toJson(requestMap));

		FilterDataService dataService = new FilterDataService();
		FilterDataDTO response = //new FilterDataDTO();
				dataService.getFilterData(FiltersData.getRequestData(), RCCLConstants.METAPRODUCT_F);
		/*
		 * List<String> filters = new ArrayList<String>(); filters.add("HM");
		 * filters.add("AL"); filters.add("SY"); filters.add("OA");
		 * response.setFilterData(filters);
		 */
		
		
		return response;

	}

	public static void main(String[] args) {
		new GetMetaProductFilterData().handleRequest(null, null);
	}

}
