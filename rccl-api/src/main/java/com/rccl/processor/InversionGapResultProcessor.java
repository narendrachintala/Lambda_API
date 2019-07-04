package com.rccl.processor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.rccl.dto.InversionGapsParaDTO;
import com.rccl.utils.RCCLConstants;

public class InversionGapResultProcessor extends ResultProcessor<List<InversionGapsParaDTO>> {
	
	public InversionGapResultProcessor() {
		result = null;
		fetchSize = RCCLConstants.MID_FETCH_ROWS;
	}

	/**
	 * process query result_set into list of inversion_gap_para objects
	 */
	@Override
	public void processResult(ResultSet rs) throws SQLException {
		BeanListHandler<InversionGapsParaDTO> handle = new BeanListHandler<InversionGapsParaDTO>(InversionGapsParaDTO.class);
		result = handle.handle(rs);

	}

}
