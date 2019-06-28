package com.rccl.processor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rccl.dto.FilterDataDTO;
import com.rccl.utils.RCCLConstants;

/**
 * The Class FilterDataProcessor.
 *
 * @author narendra.chintala
 */
public class FilterDataProcessor extends ResultProcessor<List<String>> {
	
	/** The dto. */
	FilterDataDTO dto = null;

	/**
	 * Instantiates a new filter data processor.
	 */
	public FilterDataProcessor() {
		result = new ArrayList<String>();
		dto = new FilterDataDTO();
	}

	/* (non-Javadoc)
	 * @see com.rccl.processor.ResultProcessor#processResult(java.sql.ResultSet)
	 */
	@Override
	public void processResult(ResultSet rs) throws SQLException {
		while (rs.next()) {
			result.add(rs.getString(RCCLConstants.FILTER_DATA_COLUMN));
		}
		dto.setFilterData(result);
	}

}
