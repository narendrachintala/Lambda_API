package com.rccl.dbutils;
import org.apache.logging.log4j.Logger;

import com.rccl.model.ParameterFiltersData;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.helper.FilterDataHelper;
/**
 * The Class PauseParaDBUtils.
 */
public class PauseParaDBUtils {
	//Creates instance
	public static PauseParaDBUtils _instance = null;
	ConfigUtil configInst = ConfigUtil.getInstance();
	public static PauseParaDBUtils getInstance() {
		if (_instance == null) {
			_instance = new PauseParaDBUtils();
		}
		return _instance;
	}
	/**
	 * Pause para data query maker.
	 * @param 'filterdata' is requested columns passed to get the pausepara data.
	 * @return  returns required Pausepara data
	 */
	public String getPauseParaDataQuery(ParameterFiltersData filterdata, Logger logger) {
		StringBuffer querybuffer = new StringBuffer();
		String getPauseParaData = new String(configInst.getPauseParaData());
		logger.debug("reading query from config file:" + getPauseParaData);
		FilterDataHelper filterDataHelper = new FilterDataHelper();
		String whereCondition = filterDataHelper.generateFilterCondition(filterdata, querybuffer);
		// Checks if string exists or not
		if (whereCondition.equals("")) {
			// If filterdata is null then where clause is not executed
			getPauseParaData = getPauseParaData.replace(RCCLConstants.WHERE_CONDITION_Q, "1=1");
		} else {
			// Replaces the constants with geneated where condition
			getPauseParaData = getPauseParaData.replace(RCCLConstants.WHERE_CONDITION_Q, whereCondition);
		}
		return getPauseParaData;
	}
}

