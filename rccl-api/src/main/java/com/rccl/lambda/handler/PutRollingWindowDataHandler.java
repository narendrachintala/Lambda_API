package com.rccl.lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.RollingWindow;
import com.rccl.service.RollingWindowService;

/**
 * The Class PostRollingWindowDataHandler.
 */
public class PutRollingWindowDataHandler implements RequestHandler<RollingWindow, Boolean> {
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
		// values to be updated
		roWindow.setPrev_forecast(9);
		roWindow.setFut_forecast(6);
		roWindow.setPrice_window(3);
		roWindow.setWts(59);
		
		// filter criteria
		ParameterFiltersData parameterFiltersData = new ParameterFiltersData();
		parameterFiltersData.setCat_class("N");
		parameterFiltersData.setMetaproduct("CANADA");
		parameterFiltersData.setOccupancy("double");
		parameterFiltersData.setProduct_code("CANADA");
		parameterFiltersData.setSail_month(6);
		parameterFiltersData.setShip_code("OA");
		
		roWindow.setFiltersData(parameterFiltersData);
		Gson gson = new Gson();
		String json = gson.toJson(roWindow);
		
		System.out.println("Sample Input data:" + json);
		
		new PutRollingWindowDataHandler().handleRequest(roWindow, null);
	}
}
