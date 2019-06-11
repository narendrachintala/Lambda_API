package com.rccl.utils.helper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.amazonaws.util.CollectionUtils;
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

	public String generateFilterCondition(Map<String, List<String>> filterData, StringBuffer queryBuffer) {

		String IN = " in (";
		String AND = ") and ";

		if (filterData != null && !filterData.isEmpty()) {
			
			if (!CollectionUtils.isNullOrEmpty(filterData.get(RCCLConstants.METAPRODUCT_F))) {

				queryBuffer.append(RCCLConstants.METAPRODUCT_F).append(IN);
				queryBuffer.append(join(filterData.get(RCCLConstants.METAPRODUCT_F)));
				queryBuffer.append(AND);

			}
			if (!CollectionUtils.isNullOrEmpty(filterData.get(RCCLConstants.PRODUCT_CODE_F))) {

				queryBuffer.append(RCCLConstants.PRODUCT_CODE_F).append(IN);
				queryBuffer.append(join(filterData.get(RCCLConstants.PRODUCT_CODE_F)));
				queryBuffer.append(AND);

			}
			if (!CollectionUtils.isNullOrEmpty(filterData.get(RCCLConstants.SHIP_CODE_F))) {

				queryBuffer.append(RCCLConstants.SHIP_CODE_F).append(IN);
				queryBuffer.append(join(filterData.get(RCCLConstants.SHIP_CODE_F)));
				queryBuffer.append(AND);

			}
			if (!CollectionUtils.isNullOrEmpty(filterData.get(RCCLConstants.SAIL_MONTH_F))) {

				queryBuffer.append(RCCLConstants.SAIL_MONTH_F).append(IN);
				queryBuffer.append(join(filterData.get(RCCLConstants.SAIL_MONTH_F)));
				queryBuffer.append(AND);

			}
			if (!CollectionUtils.isNullOrEmpty(filterData.get(RCCLConstants.SAIL_DATE_F))) {

				queryBuffer.append(RCCLConstants.SAIL_DATE_F).append(IN);
				queryBuffer.append(join(filterData.get(RCCLConstants.SAIL_DATE_F)));
				queryBuffer.append(AND);

			}
			if (!CollectionUtils.isNullOrEmpty(filterData.get(RCCLConstants.CAT_CLASS_F))) {

				queryBuffer.append(RCCLConstants.CAT_CLASS_F).append(IN);
				queryBuffer.append(join(filterData.get(RCCLConstants.CAT_CLASS_F)));
				queryBuffer.append(AND);

			}
			if (!CollectionUtils.isNullOrEmpty(filterData.get(RCCLConstants.OCCUPANCY_F))) {

				queryBuffer.append(RCCLConstants.OCCUPANCY_F).append(IN);
				queryBuffer.append(join(filterData.get(RCCLConstants.OCCUPANCY_F)));
				queryBuffer.append(AND);

			}

		}
		// removing last appended extra AND
		queryBuffer.replace(queryBuffer.lastIndexOf(AND) + 1, queryBuffer.length(), "");

		return queryBuffer.toString();

	}

	private String join(List<String> namesList) {
		return String.join(",", namesList.stream().map(name -> ("'" + name + "'")).collect(Collectors.toList()));
	}
}
