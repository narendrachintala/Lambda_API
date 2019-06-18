
package com.rccl.testdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.rccl.utils.RCCLConstants;

/**
 * 
 * @author narendra.chintala
 *
 */
public class FiltersData {

	public static Map<String, List<String>> getRequestData() {

		Map<String, List<String>> requestData = new HashMap<String, List<String>>();
		List<String> metaproducts = new ArrayList<String>();

		metaproducts.add("OASIS");
		requestData.put(RCCLConstants.METAPRODUCT_F, metaproducts);

		List<String> product_codes = new ArrayList<String>();
		product_codes.add("7N CARIBBEAN");
		requestData.put(RCCLConstants.PRODUCT_CODE_F, product_codes);

		List<String> ship_codes = new ArrayList<String>();
		ship_codes.add("HM");
		requestData.put(RCCLConstants.SHIP_CODE_F, ship_codes);

		List<String> sail_Date = new ArrayList<String>();
		sail_Date.add("27-OCT-19");
		requestData.put(RCCLConstants.SAIL_DATE_F, sail_Date);

		List<String> sail_months = new ArrayList<String>();
		sail_months.add("10");
		requestData.put(RCCLConstants.SAIL_MONTH_F, sail_months);

		List<String> cat_class = new ArrayList<String>();
		cat_class.add("N");
		requestData.put(RCCLConstants.CAT_CLASS_F, cat_class);

		List<String> occupancy = new ArrayList<String>();
		occupancy.add("quad");
		requestData.put(RCCLConstants.OCCUPANCY_F, occupancy);

		Gson gson = new Gson();
		System.out.println(gson.toJson(requestData));
		/*
		 * List<String> table = new ArrayList<String>(); table.add("rolling_window");
		 * requestData.put(RCCLConstants.TABLE_NAME, table);
		 */

		return requestData;

	}

}
