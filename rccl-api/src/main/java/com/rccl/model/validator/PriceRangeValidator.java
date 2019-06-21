package com.rccl.model.validator;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.PriceRange;
import com.rccl.utils.CustomFunctions;
import com.rccl.utils.helper.RCCLException;

public class PriceRangeValidator {

	public void validateGetRequest(ParameterFiltersData requestData) {
		List<String> validations = new ArrayList<String>();
		Gson gson = new Gson();
		try {
			if (CustomFunctions.isNullOrEmpty(requestData.getMetaproduct())) {
				validations.add("Please provide metaproduct");
			}

			if (!validations.isEmpty()) {
				throw new RCCLException(gson.toJson(validations), null);
			}

		} catch (Exception e) {
			throw new RCCLException("Error occured while validating Price range GET Request data: ", e);
		}
	}

	public void validatePutRequest(PriceRange requestData) {
	}

}
