package com.rccl.model.validator;

import com.rccl.model.RollingWindow;
import com.rccl.utils.CustomFunctions;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.ResourceBundleUtility;
import com.rccl.utils.helper.RCCLException;

public class RollingWindowDataValidator {
	
	public static RollingWindowDataValidator _instance = null;

	ResourceBundleUtility rBundleUtility = ResourceBundleUtility.getInstance();

	public static RollingWindowDataValidator getInstance() {
		if (_instance == null) {
			_instance = new RollingWindowDataValidator();
		}
		return _instance;
	}
	
	public void validatePutRequest(RollingWindow request) {
		if (request == null) {
			throw new RCCLException(rBundleUtility.getValue(RCCLConstants.ERROR_JSON), null);
		}
		if (request.getFiltersData() == null) {
			throw new RCCLException(rBundleUtility.getValue(RCCLConstants.ERROR_FILTERS_DATA), null);
		}
		if (CustomFunctions.isNullOrEmpty(request.getFiltersData().getMetaproduct())) {
			throw new RCCLException(rBundleUtility.getValue(RCCLConstants.ERROR_METAPRODUCT), null);
		}
		if (request.getFut_demand_window() == null && request.getFut_forecast() == null
				&& request.getPrev_demand_window() == null && request.getPrev_forecast() == null
				&& request.getPrice_window() == null && request.getWts() == null) {
			throw new RCCLException(rBundleUtility.getValue(RCCLConstants.ERROR_UPDATE_FIELDS), null);
		}
	}

}
