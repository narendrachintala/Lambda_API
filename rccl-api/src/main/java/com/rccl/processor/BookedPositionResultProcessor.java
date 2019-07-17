package com.rccl.processor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.rccl.dto.BookedPositionDTO;
import com.rccl.utils.RCCLConstants;

/**
 * The Class BookedPositionResultProcessor.
 */
public class BookedPositionResultProcessor extends ResultProcessor<List<BookedPositionDTO>> {
	/**
	 * Instantiates a new BookedPosition result processor.
	 */
	public BookedPositionResultProcessor() {
		result = null;
		fetchSize = RCCLConstants.MID_FETCH_ROWS;
	}

	/**
	 * Process result.
	 * @param rs the rs
	 * @throws SQLException the SQL exception
	 */
	@Override
	public void processResult(ResultSet rs) throws SQLException {
		BeanListHandler<BookedPositionDTO> handle = new BeanListHandler<BookedPositionDTO>(BookedPositionDTO.class);
		result = handle.handle(rs);
	}

}
