package com.rccl.dbutils;

import org.apache.logging.log4j.LogManager;
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

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(PauseParaDBUtils.class);

	// Creates instance
	public static PauseParaDBUtils _instance = null;

	// Read properties from configuration file
	ConfigUtil configInst = ConfigUtil.getInstance();

	/**
	 * Gets the single instance of PauseParaDBUtils.
	 * 
	 * @return single instance of PauseParaDBUtils
	 */
	public static PauseParaDBUtils getInstance() {
		if (_instance == null) {
			_instance = new PauseParaDBUtils();
		}
		return _instance;
	}

	/**
	 * Gets the pause para data query.
	 * 
	 * @param filterdata the filterdata
	 * @param logger     the logger
	 * @return the final query for get API
	 */
	// Generate final Pause para query for GET API
	public String getPauseParaDataQuery(ParameterFiltersData filterdata, Logger logger) {
		StringBuffer querybuffer = null;
		String getPauseParaData = null;
		try {
			querybuffer = new StringBuffer();
			getPauseParaData = new String(configInst.getPauseParaData());
			logger.debug("reading query from config file:" + getPauseParaData);
			FilterDataHelper filterDataHelper = new FilterDataHelper();
			String whereCondition = filterDataHelper.generateFilterCondition(filterdata, querybuffer);
			if (whereCondition.equals("")) {
				// If filterdata is null then where clause is not executed
				getPauseParaData = getPauseParaData.replace(RCCLConstants.WHERE_CONDITION_Q, "1=1");
			} else {
				// Replaces the constants with geneated where condition
				getPauseParaData = getPauseParaData.replace(RCCLConstants.WHERE_CONDITION_Q, whereCondition);
			}
			logger.debug("Final query for GET API pause para:" + getPauseParaData);
		} catch (Exception e) {
			logger.error("Error occured in getPauseParaDataQuery: " + e);
			throw e;
		}
		return getPauseParaData;
	}

	/**
	 * Update pause para data query.
	 * 
	 * @param request the request
	 * @return the final query for update API
	 */
	public String updatePauseParaDataQuery(PausePara request) {
		String updatePauseParaQuery = null;
		StringBuffer queryBuffer = new StringBuffer();
		StringBuffer updateBuffer = new StringBuffer();
		try {
			updatePauseParaQuery = new String(configInst.updatePauseParaData());
			logger.debug("reading query from config:" + updatePauseParaQuery);
			FilterDataHelper filterDataHelper = new FilterDataHelper();
			String finalWhereCondition = filterDataHelper.generateFilterCondition(request.getFiltersData(),
					queryBuffer);
			PauseParaDataHelper PauseParaDataHelper = new PauseParaDataHelper();
			String finalUpdateCondition = PauseParaDataHelper.generateSetterCondition(request, updateBuffer);
			if (finalWhereCondition.equals("")) {
				updatePauseParaQuery = updatePauseParaQuery.replace(RCCLConstants.WHERE_CONDITION_Q, "1=1");
			} else {
				updatePauseParaQuery = updatePauseParaQuery.replace(RCCLConstants.WHERE_CONDITION_Q,
						finalWhereCondition);
			}
			updatePauseParaQuery = updatePauseParaQuery.replace(RCCLConstants.SETTER_COLUMNS_Q, finalUpdateCondition);
			logger.debug("Final query for POST API rolling window:" +
			 updatePauseParaQuery);
		} catch (Exception e) {
			 logger.error("Error occured in updatePauseParaDataQuery: " + e);
			throw e;
		}
		return updatePauseParaQuery;
	}
}
