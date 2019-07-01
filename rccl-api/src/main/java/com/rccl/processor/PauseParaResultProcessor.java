package com.rccl.processor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.rccl.dto.PauseParaDTO;
import com.rccl.utils.RCCLConstants;

/**
 * The Class PauseParaResultProcessor.
 * 
 */
public class PauseParaResultProcessor extends ResultProcessor<List<PauseParaDTO>> {
	/**
	 * @param 'result' is used to stored the requested PausePara data
	 * @param 'fetchSize' indicates the size of data in each request
	 */
	public PauseParaResultProcessor() {
		result = null;
		fetchSize = RCCLConstants.MID_FETCH_ROWS;
	}

	/**
	 * processResult() is used to convert ResultSet rows to list
	 */
	@Override
	public void processResult(ResultSet rs) throws SQLException {
		BeanListHandler<PauseParaDTO> handle = new BeanListHandler<PauseParaDTO>(PauseParaDTO.class);
		result = handle.handle(rs);
	}
}
