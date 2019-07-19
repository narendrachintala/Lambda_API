
package com.rccl.testdata;

/**
 * 
 * @author narendra.chintala
 *
 */
public class FiltersData {

	public static com.rccl.model.FiltersData getRequestData() {

		com.rccl.model.FiltersData filterData = new com.rccl.model.FiltersData();
		filterData.setMetaproduct("OASIS");
		filterData.setProduct_code("7N CARIBBEAN");
		filterData.setShip_code("HM");
//		filterData.setSail_date("27-OCT-19");
		filterData.setSail_month("11");
		filterData.setCat_class("N");
//		filterData.setOccupancy("quad");
//		filterData.setTable_name("rolling_window");

		return filterData;

	}
	
	public static com.rccl.model.ParameterFiltersData getParamRequestData() {

		com.rccl.model.ParameterFiltersData filterData = new com.rccl.model.ParameterFiltersData();
		filterData.setMetaproduct("7N CARIBBEAN");
		filterData.setProduct_code("CARIBGLF");
		filterData.setShip_code("LB");
//		filterData.setSail_date("27-OCT-19");
		filterData.setSail_month("3");
		filterData.setCat_class("I");
//		filterData.setOccupancy("quad");
//		filterData.setTable_name("rolling_window");

		return filterData;

	}

}
