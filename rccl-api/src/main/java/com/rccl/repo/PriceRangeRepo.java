package com.rccl.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.rccl.dbutils.PriceRangeDBUtil;
import com.rccl.dbutils.RevorioConnect;
import com.rccl.dto.PriceRangeDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.PriceRange;
import com.rccl.processor.PriceRangeResultProcessor;
import com.rccl.processor.QueryExecutor;
import com.rccl.utils.RCCLConstants;

/**
 * 
 * @author narendra.chintala
 *
 */
public class PriceRangeRepo {

	/**
	 * Gets the price range data.
	 * 
	 * @param filterData
	 * @param context
	 * @return the price range data
	 */
	public List<PriceRangeDTO> getPriceRangeData(ParameterFiltersData filterData, LambdaLogger logger) {

		PriceRangeDBUtil priceRangeDBUtil = PriceRangeDBUtil.getInstance();
		QueryExecutor queryExecutor = new QueryExecutor();
		List<PriceRangeDTO> priceData = new ArrayList<PriceRangeDTO>();

		try {
			String getPriceRangeQuery = priceRangeDBUtil.getPriceRangeDataQuery(filterData);
			PriceRangeResultProcessor processor = new PriceRangeResultProcessor();
			processor.setResult(priceData);
			queryExecutor.execute(getPriceRangeQuery, null, logger, processor);
			priceData = processor.getResult();
		} catch (Exception e) {
			logger.log(e.getMessage());
			throw e;
		}

		return priceData;

	}

	/**
	 * Update price range data.
	 * 
	 * @param priceRangeReq the price range req
	 * @return true, if successful
	 */
	public boolean updatePriceRangeData(PriceRange priceRangeReq) {
		Connection conn = RevorioConnect.getInstance().getConnection();
		PriceRangeDBUtil priceRangeDBUtil = PriceRangeDBUtil.getInstance();
		Integer status = 0;
		try {
			String updatePriceRangeQuery = priceRangeDBUtil.updatePriceRangeDataQuery(priceRangeReq);
			System.out.println("updatePriceRangeQuery: " + updatePriceRangeQuery);
			PreparedStatement pstmt = conn.prepareStatement(updatePriceRangeQuery);
			pstmt.setFetchSize(RCCLConstants.MIN_FETCH_ROWS);
			status = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (status == 0) {
			return false;
		} else {
			return true;
		}
	}

}
