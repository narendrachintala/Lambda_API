package com.rccl.processor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.rccl.dto.CurrentPriceParaDTO;
import com.rccl.utils.RCCLConstants;

/**
 * The Class CurrentPriceResultProcessor.
 *
 * @author chandrabhan.birla
 */

public class CurrentPriceResultProcessor extends ResultProcessor<List<CurrentPriceParaDTO>> {
	/**
	 * Instantiates a new Current Price result processor.
	 */
	public CurrentPriceResultProcessor() {
		result = null;
		fetchSize = RCCLConstants.MAX_FETCH_ROWS;
	}

	/**
	 * process query result_set into list of current_price_para objects
	 */
	@Override
	public void processResult(ResultSet rs) throws SQLException {
		BeanListHandler<CurrentPriceParaDTO> handle = new BeanListHandler<CurrentPriceParaDTO>(
				CurrentPriceParaDTO.class);
		result = handle.handle(rs);

	}

}
