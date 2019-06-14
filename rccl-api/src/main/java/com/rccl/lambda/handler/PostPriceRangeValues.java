package com.rccl.lambda.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.rccl.dto.PriceRangeReq;
import com.rccl.model.PriceRangeDTO;
import com.rccl.utils.RCCLConstants;

/**
 * 
 * @author narendra.chintala
 *
 */
public class PostPriceRangeValues implements RequestHandler<PriceRangeReq, List<PriceRangeDTO>> {

	@Override
	/**
	 * Post price range data based on applied filters and requested data
	 */
	public List<PriceRangeDTO> handleRequest(PriceRangeReq request, Context context) {
		Gson gson = new Gson();
		context.getLogger().log("Input: " + gson.toJson(request));
		System.out.println("PostPriceHandleRequest");
		List<PriceRangeDTO> postPrice= new ArrayList<PriceRangeDTO>();

		return postPrice;

	}

	public static void main(String[] args) {

		Map<String, Object> price_range_values = new HashMap<String, Object>();

		price_range_values.put(RCCLConstants.PRICE_RANGE_MIN, -0.2);
		price_range_values.put(RCCLConstants.PRICE_RANGE_MAX, 0.2);

		Map<String, List<String>> filteredData = new HashMap<String, List<String>>();

		List<String> filteredMetaProducts = new ArrayList<String>();
		filteredMetaProducts.add("OASIS");
		/*
		 * filteredMetaProducts.add("7N CARIBBIAN");
		 * filteredMetaProducts.add("SHORT CARIBBIAN");
		 * filteredMetaProducts.add("7N CARIBBIAN"); filteredMetaProducts.add("CANADA");
		 */

		filteredData.put(RCCLConstants.METAPRODUCT_F, filteredMetaProducts);

		List<String> filteredProductCode = new ArrayList<String>();
		filteredProductCode.add("CARIBEST");
		/* filteredProductCode.add("CARIBWST"); */

		filteredData.put(RCCLConstants.PRODUCT_CODE_F, filteredProductCode);

		List<String> filteredShipCode = new ArrayList<String>();
		filteredShipCode.add("SY");
		/* filteredShipCode.add("AL"); */

		filteredData.put(RCCLConstants.SHIP_CODE_F, filteredShipCode);

		List<String> filteredSailMonth = new ArrayList<String>();
		filteredSailMonth.add("1");
		/* filteredSailMonth.add("2"); */

		filteredData.put(RCCLConstants.SAIL_MONTH_F, filteredSailMonth);

		List<String> filteredSailDate = new ArrayList<String>();
		filteredSailDate.add("2019/10/10");

		filteredData.put(RCCLConstants.SAIL_DATE_F, filteredSailDate);

		List<String> filteredCatClass = new ArrayList<String>();
		filteredCatClass.add("O");
		/* filteredCatClass.add("D"); */

		filteredData.put(RCCLConstants.CAT_CLASS_F, filteredCatClass);

		List<String> filteredOccupancy = new ArrayList<String>();
		filteredOccupancy.add("double");
		/* filteredOccupancy.add("quad"); */

		filteredData.put(RCCLConstants.OCCUPANCY_F, filteredOccupancy);

		price_range_values.put(RCCLConstants.FILTER_DATA, filteredData);

		Gson gson = new Gson();
		String json = gson.toJson(price_range_values);
		System.out.println("json: " + json);
	}
}
