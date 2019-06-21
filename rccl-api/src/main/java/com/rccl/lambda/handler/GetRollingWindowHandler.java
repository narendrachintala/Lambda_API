package com.rccl.lambda.handler;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.rccl.dto.RollingWindowDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.validator.RequestDataValidator;
import com.rccl.service.RollingWindowService;
import com.rccl.utils.helper.RCCLException;

/**
 * The Class RollingWindowHandler.
 */
// Start of Lambda Function request
public class GetRollingWindowHandler implements RequestHandler<ParameterFiltersData, List<RollingWindowDTO>> {
	
	/**
	 * executes on requesting for list of values for specific table name
	 * @param request contains chosen filters as key-value pair
	 * @param context lambda context object
	 * @return the list of column values based on provided tablename
	 */
	public List<RollingWindowDTO> handleRequest(ParameterFiltersData request, Context context) {
		List<RollingWindowDTO> rollingWindowList = null;
		RequestDataValidator requestDataValidator = new RequestDataValidator();
		try {
			requestDataValidator.validateGetRequest(request);
			// verify input request is not null
			if (request != null) {
				RollingWindowService rollingWindowService = new RollingWindowService();
				rollingWindowList = rollingWindowService.getRollingWindowData(request);
			}
			System.out.println("result set size:" + rollingWindowList.size());
			System.out.println(rollingWindowList.get(0).getCat_class());
			Gson gson = new Gson();
			System.out.println("final Result:" + gson.toJson(rollingWindowList));
		}
		catch (Exception ex) {
			throw new RCCLException("Error occured while executing GetPriceRangeDataHandler", ex);
		}
		return rollingWindowList;
	}

	/**
	 * The main method.
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// prepares sample input data for handler class
		ParameterFiltersData parameterFiltersData = new ParameterFiltersData();
		parameterFiltersData.setCat_class("N");
		parameterFiltersData.setCategory("double");
		parameterFiltersData.setMetaproduct("");
		parameterFiltersData.setOccupancy("quad");
		parameterFiltersData.setProduct_code("7N CARIBBEAN");
		parameterFiltersData.setSail_month("10");
		parameterFiltersData.setShip_code("HM");
		new GetRollingWindowHandler().handleRequest(parameterFiltersData, null);
	}
}
