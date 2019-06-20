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
import com.rccl.utils.DBUtils;
import com.rccl.utils.RCCLConstants;

/**
 * 
 * @author narendra.chintala
 *
 */
public class PriceRangeRepo {

	public List<PriceRangeDTO> getPriceRangeData(ParameterFiltersData filterData) {
		Connection conn = RevorioConnect.getInstance().getConnection();
		List<PriceRangeDTO> priceData = null;
		DBUtils dbUtils = DBUtils.getInstance();
		try {
			String getPriceRangeQuery = dbUtils.getPriceRangeDataQuery(filterData);
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

	public boolean updatePriceRangeData(PriceRange priceRangeReq) {
		Connection conn = RevorioConnect.getInstance().getConnection();
		DBUtils dbUtils = DBUtils.getInstance();
		Integer status = 0;
		try {
			String updatePriceRangeQuery = dbUtils.updatePriceRangeDataQuery(priceRangeReq);
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
