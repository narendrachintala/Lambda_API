package com.rccl.utils.helper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.utils.CustomFunctions;
import com.rccl.utils.RCCLConstants;

/**
 * @author chandrabhan.birla
 * Class : UpdateColumnHelper
 */
public class UpdateColumnHelper {
	/** The Constant logger. */
	static final Logger logger = LogManager.getLogger(CustomFunctions.class);

	/**
	 * Gets the list of Columns for which current date is to be set.
	 *
	 * @param StringBuffer having pre-made query and 
	 * @param List<String> having the list of columns to be set for 
	 * @return StringBuffer query with setter for clause for columns list
	 */
	public static StringBuffer setTimeAsColumnValue(StringBuffer queryBuffer,List<String> columnList) {
		try {
			columnList.forEach((column)-> {
				queryBuffer.append(column).append(RCCLConstants.EQUALS);
				new CustomFunctions();
				queryBuffer.append(RCCLConstants.SINGLE_QUOTE).append(CustomFunctions.getCurrentDate()).append(RCCLConstants.SINGLE_QUOTE);
			});
		}
		catch(Exception e){
			logger.error(e);
			throw e;
		}
		
		return queryBuffer;
				
	}
}
