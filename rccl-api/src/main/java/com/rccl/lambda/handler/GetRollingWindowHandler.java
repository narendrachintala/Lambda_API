package com.rccl.lambda.handler;

import java.util.List;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.rccl.dto.RollingWindowDTO;
import com.rccl.service.RollingWindowService;
import com.rccl.testdata.FiltersData;

/**
 * The Class RollingWindowHandler.
 */
// Start of Lambda Function request
public class GetRollingWindowHandler implements RequestHandler<Map<String, List<String>>, List<RollingWindowDTO>> {
	
	/**
	 * executes on requesting for list of values for specific table name
	 * @param request contains chosen filters as key-value pair
	 * @param context lambda context object
	 * @return the list of column values based on provided tablename
	 */
	public List<RollingWindowDTO> handleRequest(Map<String, List<String>> request, Context context) {
		List<RollingWindowDTO> rollingWindowList = null;
		// verify input request is not null
		if (request != null) {
			RollingWindowService rollingWindowService = new RollingWindowService();
			rollingWindowList = rollingWindowService.getRollingWindowData(request);
		}
		System.out.println("result set size:" + rollingWindowList.size());
		//Gson gson = new GsonBuilder().serializeNulls().create();
		System.out.println(rollingWindowList.get(0).getCat_class());
		Gson gson = new Gson();
		System.out.println("final Result:" + gson.toJson(rollingWindowList));
		return rollingWindowList;
	}

	/**
	 * The main method.
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Gson gson = new Gson();
		// prepares sample input data for handler class
		System.out.println("Sample Input request:" + gson.toJson(FiltersData.getRequestData()));
		new GetRollingWindowHandler().handleRequest(FiltersData.getRequestData(), null);
	}
}
