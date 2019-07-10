package com.rccl.dbutils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.InversionGapPara;
import com.rccl.model.ParameterFiltersData;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.helper.FilterDataHelper;
import com.rccl.utils.helper.InversionGapsDataHelper;

/**
 * The Class InversionGapParaUtils.
 */
public class InversionGapParaUtils {

	/** The Constant logger. */
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(InversionGapParaUtils.class);

	/** The instance. */
	public static InversionGapParaUtils _instance = null;

	/** The config inst. */
	ConfigUtil configInst = ConfigUtil.getInstance();

	/**
	 * Gets the single instance of InversionGapParaUtils.
	 * 
	 * @return single instance of InversionGapParaUtils
	 */
	public static InversionGapParaUtils getInstance() {
		if (_instance == null) {
			_instance = new InversionGapParaUtils();
		}
		return _instance;
	}

	/**
	 * Gets the InversionGapPara data query.
	 * 
	 * @param filterData the filter data
	 * @return the InversionGapPara data query
	 */

	public String getInversionGapParaDataQuery(ParameterFiltersData filterData) {
		StringBuffer queryBuffer = new StringBuffer();
		String getinversionGapParaQuery = new String(configInst.getinversionGapPara());
		try {
			FilterDataHelper filterDataHelper = new FilterDataHelper();
			String whereCondition = filterDataHelper.generateFilterCondition(filterData, queryBuffer);
			if (whereCondition.equals("")) {
				getinversionGapParaQuery = getinversionGapParaQuery.replace(RCCLConstants.WHERE_CONDITION_Q, "1=1");
			} else {
				getinversionGapParaQuery = getinversionGapParaQuery.replace(RCCLConstants.WHERE_CONDITION_Q,
						whereCondition);
			}
		} catch (Exception e) {
			logger.error("Error occured in getinversionGapParaQuery: " + e);
			throw e;
		}
		return getinversionGapParaQuery;
	}

	/**
	 * Update InversionGapsPara data query.
	 * 
	 * @param request the request
	 * @param logger  the logger
	 * @return the final query for update API
	 */
	// Generate final InversionGapsPara query for POST API
	public String updateInversionGapsPara(InversionGapPara request) {
		StringBuffer queryBuffer = new StringBuffer();
		StringBuffer updateBuffer = new StringBuffer();
		String updateInversionGapsParaQuery = null;
		try {
			updateInversionGapsParaQuery = new String(configInst.updateInversionGapsPara());
			System.out.println("reading query from config:" + updateInversionGapsParaQuery);
			 logger.debug("reading query from config:" + updateInversionGapsParaQuery);
			FilterDataHelper filterDataHelper = new FilterDataHelper();
			String finalWhereCondition = filterDataHelper.generateFilterCondition(request.getFiltersData(),
					queryBuffer);
			InversionGapsDataHelper inversionGapsDataHelper = new InversionGapsDataHelper();
			String finalUpdateCondition = inversionGapsDataHelper.generateSetterCondition(request, updateBuffer);
			if (finalWhereCondition.equals("")) {
				updateInversionGapsParaQuery = updateInversionGapsParaQuery.replace(RCCLConstants.WHERE_CONDITION_Q,
						"1=1");
			} else {
				updateInversionGapsParaQuery = updateInversionGapsParaQuery.replace(RCCLConstants.WHERE_CONDITION_Q,
						finalWhereCondition);
			}
			updateInversionGapsParaQuery = updateInversionGapsParaQuery.replace(RCCLConstants.SETTER_COLUMNS_Q,
					finalUpdateCondition);
			System.out.println("modified query:" + updateInversionGapsParaQuery);
			logger.debug("Final query for POST API InversionGapsPara:" +
			 updateInversionGapsParaQuery);

		} catch (Exception e) {
			 logger.error("Error occured in updateInversionGapsParaQuery: " + e);
			throw e;
		}
		return updateInversionGapsParaQuery;

	}
}
