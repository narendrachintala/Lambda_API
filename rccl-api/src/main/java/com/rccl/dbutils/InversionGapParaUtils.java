package com.rccl.dbutils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.model.ParameterFiltersData;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.helper.FilterDataHelper;

public class InversionGapParaUtils {
	// Initialize the Log4j logger.
		static final Logger logger = LogManager.getLogger(InversionGapParaUtils.class);

		public static InversionGapParaUtils _instance = null;
		ConfigUtil configInst = ConfigUtil.getInstance();

		/**
		 * 
		 * @return PriceRangeDBUtil instance for utilizing class methods
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
					getinversionGapParaQuery = getinversionGapParaQuery.replace(RCCLConstants.WHERE_CONDITION_Q, whereCondition);
				}
			} catch (Exception e) {
				//logger.error("Error occured in getinversionGapParaQuery: " + e);
				throw e;
			}
			return getinversionGapParaQuery;
		}

}
