package com.rccl.processor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.rccl.dto.RefundablePremiumDTO;
import com.rccl.utils.RCCLConstants;

/**
 * The Class RefundablePremiumResultProcessor.
 */
public class RefundablePremiumResultProcessor extends ResultProcessor<List<RefundablePremiumDTO>> {

	/**
	 * Instantiates a new rolling window result processor.
	 */
	public RefundablePremiumResultProcessor() {
		result = null;
		fetchSize = RCCLConstants.MID_FETCH_ROWS;
	}

	/**
	 * Process result.
	 * 
	 * @param rs the rs
	 * @throws SQLException the SQL exception
	 */
	@Override
	public void processResult(ResultSet rs) throws SQLException {
		BeanListHandler<RefundablePremiumDTO> handle = new BeanListHandler<RefundablePremiumDTO>(
				RefundablePremiumDTO.class);
		result = handle.handle(rs);
	}

}
