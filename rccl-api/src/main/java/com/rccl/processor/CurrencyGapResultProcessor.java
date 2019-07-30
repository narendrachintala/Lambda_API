package com.rccl.processor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.rccl.dto.CurrencyGapParaDTO;
import com.rccl.utils.RCCLConstants;

/**
 * The Class CurrencyGapResultProcessor.
 *
 * @author chandrabhan.birla
 */

public class CurrencyGapResultProcessor extends ResultProcessor<List<CurrencyGapParaDTO>> {
	/**
	 * Instantiates a new Current Price result processor.
	 */
	public CurrencyGapResultProcessor() {
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
		BeanListHandler<CurrencyGapParaDTO> handle = new BeanListHandler<CurrencyGapParaDTO>(CurrencyGapParaDTO.class);
		result = handle.handle(rs);

	}

}
