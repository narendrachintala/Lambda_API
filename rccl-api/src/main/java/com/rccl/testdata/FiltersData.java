
package com.rccl.testdata;

/**
 * 
 * @author narendra.chintala
 *
 */
public class FiltersData {

	public static com.rccl.model.FiltersData getRequestData() {

		com.rccl.model.FiltersData filterData = new com.rccl.model.FiltersData();
		filterData.setMetaproduct("SHORT CARIBBEAN");
		filterData.setProduct_code("PRTCNVR4");
		filterData.setShip_code("MA");
//		filterData.setSail_date("27-OCT-19");
		filterData.setSail_month("5");
		//filterData.setCat_class("N");
//		filterData.setOccupancy("quad");
//		filterData.setTable_name("rolling_window");

		return filterData;

	}
	
	public static com.rccl.model.ParameterFiltersData getParamRequestData() {

		com.rccl.model.ParameterFiltersData filterData = new com.rccl.model.ParameterFiltersData();
		filterData.setMetaproduct("SHORT CARIBBEAN");
		filterData.setProduct_code("PRTCNVR4");
		filterData.setShip_code("MA");
//		filterData.setSail_date("27-OCT-19");
		filterData.setSail_month("5");
		//filterData.setCat_class("I");
//		filterData.setOccupancy("quad");
//		filterData.setTable_name("rolling_window");

		return filterData;

	}

}
