package com.rccl.processor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.rccl.dto.RollingWindowDTO;
import com.rccl.utils.RCCLConstants;

public class RollingWindowResultProcessor extends ResultProcessor<List<RollingWindowDTO>> {

	public RollingWindowResultProcessor() {
		result = null;
		fetchSize = RCCLConstants.MID_FETCH_ROWS;
	}

	@Override
	public void processResult(ResultSet rs) throws SQLException {
		BeanListHandler<RollingWindowDTO> handle = new BeanListHandler<RollingWindowDTO>(RollingWindowDTO.class);
		result = handle.handle(rs);
	}
}
