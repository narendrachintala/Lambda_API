package com.rccl.processor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.rccl.dto.PriceRangeDTO;
import com.rccl.utils.RCCLConstants;

public class PriceRangeResultProcessor extends ResultProcessor<List<PriceRangeDTO>> {

	public PriceRangeResultProcessor() {
		result = null;
		fetchSize = RCCLConstants.MID_FETCH_ROWS;
	}

	@Override
	public void processResult(ResultSet rs) throws SQLException {
		BeanListHandler<PriceRangeDTO> handle = new BeanListHandler<PriceRangeDTO>(PriceRangeDTO.class);
		result = handle.handle(rs);

	}

}
