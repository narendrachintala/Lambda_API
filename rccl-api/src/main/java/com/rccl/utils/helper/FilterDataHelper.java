package com.rccl.utils.helper;

import com.rccl.model.FiltersData;
import com.rccl.model.ParameterFiltersData;
import com.rccl.utils.CustomFun;
import com.rccl.utils.RCCLConstants;

/**
 * 
 * @author narendra.chintala
 *
 */
public class FilterDataHelper {
	/*
	 * public static FilterDataHelper _instance;
	 * 
	 * public static FilterDataHelper getInstance() { if (_instance == null) {
	 * _instance = new FilterDataHelper(); } return _instance; }
	 */

	public String generateFilterCondition(ParameterFiltersData filterData, StringBuffer queryBuffer) {

		String IN = " in (";
		String AND = ") and ";

		if (filterData != null) {
			
			if (!CustomFun.isNullOrEmpty(filterData.getMetaproduct())) {

				queryBuffer.append(RCCLConstants.METAPRODUCT_F).append(IN);
				queryBuffer.append(join(filterData.getMetaproduct()));
				queryBuffer.append(AND);

			}
			if (!CustomFun.isNullOrEmpty(filterData.getProduct_code())) {

				queryBuffer.append(RCCLConstants.PRODUCT_CODE_F).append(IN);
				queryBuffer.append(join(filterData.getProduct_code()));
				queryBuffer.append(AND);

			}
			if (!CustomFun.isNullOrEmpty(filterData.getShip_code())) {

				queryBuffer.append(RCCLConstants.SHIP_CODE_F).append(IN);
				queryBuffer.append(join(filterData.getShip_code()));
				queryBuffer.append(AND);

			}
			if (filterData.getSail_month() != null) {

				queryBuffer.append(RCCLConstants.SAIL_MONTH_F).append(IN);
				queryBuffer.append(filterData.getSail_month());
				queryBuffer.append(AND);

			}
			if (filterData.getSail_date() != null) {

				queryBuffer.append(RCCLConstants.SAIL_DATE_F).append(IN);
				queryBuffer.append(join(filterData.getSail_date().toString()));
				queryBuffer.append(AND);

			}
			if (!CustomFun.isNullOrEmpty(filterData.getCat_class())) {

				queryBuffer.append(RCCLConstants.CAT_CLASS_F).append(IN);
				queryBuffer.append(join(filterData.getCat_class()));
				queryBuffer.append(AND);

			}
			if (!CustomFun.isNullOrEmpty(filterData.getOccupancy())) {

				queryBuffer.append(RCCLConstants.OCCUPANCY_F).append(IN);
				queryBuffer.append(join(filterData.getOccupancy()));
				queryBuffer.append(AND);

			}

		}
		// removing last appended extra AND
		queryBuffer.replace(queryBuffer.lastIndexOf(AND) + 1, queryBuffer.length(), "");

		return queryBuffer.toString();

	}

	private String join(String str) {
		return String.join(",", str);
	}
}
