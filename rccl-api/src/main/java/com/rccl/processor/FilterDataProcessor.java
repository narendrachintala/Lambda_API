package com.rccl.processor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rccl.infra.ResultProcessor;
import com.rccl.model.FilterDataDTO;
import com.rccl.utils.RCCLConstants;

/**
 * 
 * @author narendra.chintala
 *
 */
public class FilterDataProcessor extends ResultProcessor<List<String>> {
	FilterDataDTO dto = null;

	public FilterDataProcessor() {
		result = new ArrayList<String>();
		dto = new FilterDataDTO();
	}

	@Override
	public void processResult(ResultSet rs) throws SQLException {
		result.add(rs.getString(RCCLConstants.FILTER_DATA_COLUMN));
		dto.setFilterData(result);
	}

}
