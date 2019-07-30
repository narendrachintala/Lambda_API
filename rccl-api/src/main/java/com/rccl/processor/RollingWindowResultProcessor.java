package com.rccl.processor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.rccl.dto.RollingWindowDTO;
import com.rccl.utils.RCCLConstants;

/**
 * The Class RollingWindowResultProcessor.
 */
public class RollingWindowResultProcessor extends ResultProcessor<List<RollingWindowDTO>> {

	/**
	 * Instantiates a new rolling window result processor.
	 */
	public RollingWindowResultProcessor() {
		result = null;
		fetchSize = RCCLConstants.MAX_FETCH_ROWS;
	}

	/**
	 * Process result.
	 * 
	 * @param rs the rs
	 * @throws SQLException the SQL exception
	 */
	@Override
	public void processResult(ResultSet rs) throws SQLException {
		BeanListHandler<RollingWindowDTO> handle = new BeanListHandler<RollingWindowDTO>(RollingWindowDTO.class);
		result = handle.handle(rs);
	}
}
