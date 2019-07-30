package com.rccl.processor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.rccl.dto.PriceRangeDTO;
import com.rccl.utils.RCCLConstants;

/**
 * The Class PriceRangeResultProcessor.
 *
 * @author narendra.chintala
 */
public class PriceRangeResultProcessor extends ResultProcessor<List<PriceRangeDTO>> {

	public PriceRangeResultProcessor() {
		result = null;
		fetchSize = RCCLConstants.MID_FETCH_ROWS;
	}

	/**
	 * process query result_set into list of price_range objects
	 */
	@Override
	public void processResult(ResultSet rs) throws SQLException {
		BeanListHandler<PriceRangeDTO> handle = new BeanListHandler<PriceRangeDTO>(PriceRangeDTO.class);
		result = handle.handle(rs);

	}

}
