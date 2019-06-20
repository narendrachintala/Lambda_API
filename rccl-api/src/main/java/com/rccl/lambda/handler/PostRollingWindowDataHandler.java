package com.rccl.lambda.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.rccl.model.RollingWindow;
import com.rccl.service.RollingWindowService;
import com.rccl.utils.RCCLConstants;

/**
 * The Class PostRollingWindowDataHandler.
 */
public class PostRollingWindowDataHandler implements RequestHandler<RollingWindow, Boolean> {
	/**
	 * Handle request.
	 * @param request contains chosen filters as key-value pair
	 * @param context lambda context object
	 * @return true if update is successful
	 */
	public Boolean handleRequest(RollingWindow request, Context context) {
		boolean update = false;
		// verify input request is not null
		if (request != null) {
			RollingWindowService rollingWindowService = new RollingWindowService();
			update = rollingWindowService.updateRollingWindowData(request);
		}
		System.out.println("value of update():" + update);
		return update;
	}
	
	/**
	 * The main method.
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		RollingWindow roWindow = new RollingWindow();
		// values to be update
		roWindow.setPrev_forecast(9);
		roWindow.setFut_forecast(6);
		roWindow.setPrice_window(3);
		roWindow.setWts(59);
		// input data
		Map<String, List<String>> filteredData = new HashMap<String, List<String>>();

		List<String> filteredMetaProducts = new ArrayList<String>();
		filteredMetaProducts.add("CANADA");
		filteredData.put(RCCLConstants.METAPRODUCT_F, filteredMetaProducts);
		
		List<String> filteredProductCode = new ArrayList<String>();
		filteredProductCode.add("CANADA");
		filteredData.put(RCCLConstants.PRODUCT_CODE_F, filteredProductCode);
		
		List<String> filteredShipCode = new ArrayList<String>();
		filteredShipCode.add("OA");
		filteredData.put(RCCLConstants.SHIP_CODE_F, filteredShipCode);
		
		List<String> filteredSailMonth = new ArrayList<String>();
		filteredSailMonth.add("6");
		filteredData.put(RCCLConstants.SAIL_MONTH_F, filteredSailMonth);
		
		List<String> filteredCatClass = new ArrayList<String>();
		filteredCatClass.add("N");
		filteredData.put(RCCLConstants.CAT_CLASS_F, filteredCatClass);
		
		List<String> filteredOccupancy = new ArrayList<String>();
		filteredOccupancy.add("double");
		filteredData.put(RCCLConstants.OCCUPANCY_F, filteredOccupancy);

		roWindow.setFilters(filteredData);
		Gson gson = new Gson();
		String json = gson.toJson(roWindow);
		
		System.out.println("Sample Input data:" + json);
		
		new PostRollingWindowDataHandler().handleRequest(roWindow, null);
	}
}
