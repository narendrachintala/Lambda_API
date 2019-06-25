package com.rccl.processor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.rccl.dto.PauseParaDTO;
import com.rccl.dto.PriceRangeDTO;
import com.rccl.utils.RCCLConstants;

public class PauseParaResultProcessor extends ResultProcessor<List<PauseParaDTO>> {


	public PauseParaResultProcessor() {
		result = null;
		fetchSize = RCCLConstants.MID_FETCH_ROWS;
	}

	@Override
	public void processResult(ResultSet rs) throws SQLException {
		BeanListHandler<PauseParaDTO> handle = new BeanListHandler<PauseParaDTO>(PauseParaDTO.class);
		result = handle.handle(rs);

	}
	
}
