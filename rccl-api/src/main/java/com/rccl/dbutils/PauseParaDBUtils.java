package com.rccl.dbutils;
import org.apache.logging.log4j.Logger;

import com.rccl.model.ParameterFiltersData;
import com.rccl.model.PausePara;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.helper.FilterDataHelper;
import com.rccl.utils.helper.PauseParaDataHelper;

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
	 * @return required Pausepara data
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
		logger.debug("Final query for GET API pause para:" + getPauseParaData);
		return getPauseParaData;
	}
	
	/**
	 * Update pause para data query.
	 * @param request the request
	 * @param logger the logger
	 * @return the string
	 */
	public String updatePauseParaDataQuery(PausePara request, Logger logger ) {
		StringBuffer queryBuffer = new StringBuffer();
		StringBuffer updateBuffer = new StringBuffer();
		String updatePauseParaQuery = new String(configInst.updatePauseParaData());
		System.out.println("reading query from config:" + updatePauseParaQuery);
		logger.debug("reading query from config:" + updatePauseParaQuery);
		FilterDataHelper filterDataHelper = new FilterDataHelper();
		String finalWhereCondition = filterDataHelper.generateFilterCondition(request.getFilterData(), queryBuffer);
		System.out.println("generated where clause:" +finalWhereCondition);
		PauseParaDataHelper PauseParaDataHelper = new PauseParaDataHelper();
		String finalUpdateCondition = PauseParaDataHelper.generateSetterCondition(request, updateBuffer);
		if (finalWhereCondition.equals("")) {
			updatePauseParaQuery = updatePauseParaQuery.replace(RCCLConstants.WHERE_CONDITION_Q, "1=1");
		} else {
			updatePauseParaQuery = updatePauseParaQuery.replace(RCCLConstants.WHERE_CONDITION_Q, finalWhereCondition);
		}
		updatePauseParaQuery = updatePauseParaQuery.replace(RCCLConstants.SETTER_COLUMNS_Q, finalUpdateCondition);
		System.out.println("modified query:" + updatePauseParaQuery);
		logger.debug("Final query for POST API rolling window:" + updatePauseParaQuery);
		return updatePauseParaQuery;
	}
}

