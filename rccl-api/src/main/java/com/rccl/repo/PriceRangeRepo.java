package com.rccl.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.rccl.dbutils.RevorioConnect;
import com.rccl.dto.PriceRangeDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.PriceRange;
import com.rccl.utils.PriceRangeDBUtil;
import com.rccl.utils.RCCLConstants;

/**
 * 
 * @author narendra.chintala
 *
 */
public class PriceRangeRepo {

	/**
	 * Gets the price range data.
	 * @param filterData the filter data
	 * @return the price range data
	 */
	public List<PriceRangeDTO> getPriceRangeData(ParameterFiltersData filterData) {
		Connection conn = RevorioConnect.getInstance().getConnection();
		List<PriceRangeDTO> priceData = null;
		PriceRangeDBUtil priceRangeDBUtil = PriceRangeDBUtil.getInstance();
		try {
			String getPriceRangeQuery = priceRangeDBUtil.getPriceRangeDataQuery(filterData);
			System.out.println("getPriceRangeQuery: " + getPriceRangeQuery);
			PreparedStatement pstmt = conn.prepareStatement(getPriceRangeQuery);
			pstmt.setFetchSize(RCCLConstants.MID_FETCH_ROWS);
			ResultSet rs = pstmt.executeQuery();

			BeanListHandler<PriceRangeDTO> handle = new BeanListHandler<PriceRangeDTO>(PriceRangeDTO.class);
			priceData = handle.handle(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return priceData;

	}

	/**
	 * Update price range data.
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
