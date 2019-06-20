package com.rccl.dbutils;

import java.util.List;
import java.util.Map;

import com.rccl.model.FiltersData;
import com.rccl.model.ParameterFiltersData;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;

/*
 * Establishes connection and generates where condition
 */

import com.rccl.utils.helper.FilterDataHelper;

public class PauseParaDBUtils {
	
	public static PauseParaDBUtils _instance = null;

	ConfigUtil configInst = ConfigUtil.getInstance();

	public static PauseParaDBUtils getInstance() {
		if (_instance == null) {
			_instance = new PauseParaDBUtils();
		}
		return _instance;
	}
	
	public String getPauseParaDataQuery(ParameterFiltersData filterdata) {
		StringBuffer querybuffer= new StringBuffer();
		String getPauseParaData = new String(configInst.getPauseParaData());
		FilterDataHelper filterDataHelper = new FilterDataHelper();
		String whereCondition = filterDataHelper.generateFilterCondition(filterdata, querybuffer);
		if (whereCondition.equals("")) {
			getPauseParaData = getPauseParaData.replace(RCCLConstants.WHERE_CONDITION_Q, "1=1");
		} else {
			getPauseParaData = getPauseParaData.replace(RCCLConstants.WHERE_CONDITION_Q, whereCondition);
		}
		return getPauseParaData;
	}
		
	}

