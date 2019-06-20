package com.rccl.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.rccl.dbutils.RevorioConnect;
import com.rccl.dto.RollingWindowDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.model.RollingWindow;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.RollingWindowDBUtil;

/**
 * The Class RollingWindowRepo.
 */
public class RollingWindowRepo {

	/**
	 * Gets the rolling window data.
	 * @param request the request
	 * @return the rolling window data
	 */
	// This method is used to fetch results from DB
	public List<RollingWindowDTO> getRollingWindowData(ParameterFiltersData request) {
		Connection conn = RevorioConnect.getInstance().getConnection();
		List<RollingWindowDTO> rollingWindowData = null;
		RollingWindowDBUtil dbUtils = RollingWindowDBUtil.getInstance();
		try {
			String getRollingWindowQuery = dbUtils.getRollingWindowQuery(request);
			System.out.println("Modified query:" + getRollingWindowQuery);
			PreparedStatement pstmt = conn.prepareStatement(getRollingWindowQuery);
			pstmt.setFetchSize(RCCLConstants.MAX_FETCH_ROWS);
			ResultSet rs = pstmt.executeQuery();
			BeanListHandler<RollingWindowDTO> handle = new BeanListHandler<RollingWindowDTO>(RollingWindowDTO.class);
			rollingWindowData = handle.handle(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rollingWindowData;
	}
	
	/**
	 * Update rolling window data.
	 * @param request the request
	 * @return true, if successful
	 */
	public boolean updateRollingWindowData(RollingWindow request) {
		Connection conn = RevorioConnect.getInstance().getConnection();
		RollingWindowDBUtil dbUtils = RollingWindowDBUtil.getInstance();
		Integer status = 0;
		try {
			String updateRollingWindowQuery = dbUtils.updateRollingWindowDataQuery(request);
			PreparedStatement pstmt = conn.prepareStatement(updateRollingWindowQuery);
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
