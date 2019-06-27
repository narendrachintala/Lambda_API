package com.rccl.utils.helper;

import com.rccl.model.ParameterFiltersData;
import com.rccl.utils.CustomFunctions;
import com.rccl.utils.RCCLConstants;

/**
 * The Class FilterDataHelper.
 * @author narendra.chintala
 */
public class FilterDataHelper {

	/**
	 * Generate filter condition.
	 * @param 'filterData' contains chosen filters
	 * @param 'queryBuffer' is required to append the generated query
	 * @return returns the final string which is a end query
	 */
	public String generateFilterCondition(ParameterFiltersData filterData, StringBuffer queryBuffer) {
		String IN = RCCLConstants.IN;
		String AND = RCCLConstants.AND;
		try {
			if (filterData != null) {
				if (!CustomFunctions.isNullOrEmpty(filterData.getMetaproduct())) {
					queryBuffer.append(RCCLConstants.METAPRODUCT_F).append(IN);
					queryBuffer.append(join(filterData.getMetaproduct()));
					queryBuffer.append(AND);
				}
				if (!CustomFunctions.isNullOrEmpty(filterData.getProduct_code())) {
					queryBuffer.append(RCCLConstants.PRODUCT_CODE_F).append(IN);
					queryBuffer.append(join(filterData.getProduct_code()));
					queryBuffer.append(AND);
				}
				if (!CustomFunctions.isNullOrEmpty(filterData.getShip_code())) {
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
				if (!CustomFunctions.isNullOrEmpty(filterData.getCat_class())) {
					queryBuffer.append(RCCLConstants.CAT_CLASS_F).append(IN);
					queryBuffer.append(join(filterData.getCat_class()));
					queryBuffer.append(AND);
				}
				if (!CustomFunctions.isNullOrEmpty(filterData.getCategory())) {
					queryBuffer.append(RCCLConstants.CATEGORY_F).append(IN);
					queryBuffer.append(join(filterData.getCategory()));
					queryBuffer.append(AND);
				}
				if (!CustomFunctions.isNullOrEmpty(filterData.getOccupancy())) {
					queryBuffer.append(RCCLConstants.OCCUPANCY_F).append(IN);
					queryBuffer.append(join(filterData.getOccupancy()));
					queryBuffer.append(AND);
				}
			}
			// removing last appended extra AND
			queryBuffer.replace(queryBuffer.lastIndexOf(AND) + 1, queryBuffer.length(), "");
		} catch (Exception e) {
			throw new RCCLException("Error occured while executing generateFilterCondition", e);
		}
		return queryBuffer.toString();
	}

	/**
	 * Join.
	 * @param 'str'
	 * @return the string
	 */
	private String join(String str) {
		return new StringBuilder().append('\'').append(str).append('\'').toString();
	}
}
