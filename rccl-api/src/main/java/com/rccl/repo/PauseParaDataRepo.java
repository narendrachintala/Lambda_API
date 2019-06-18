package com.rccl.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.rccl.dbutils.RevorioConnect;
import com.rccl.dto.PauseParaReq;
//import com.rccl.dto.PriceRangeReq;
import com.rccl.model.PausePara;
import com.rccl.utils.PauseParaDBUtils;
import com.rccl.utils.RCCLConstants;

public class PauseParaDataRepo {
	public List<PausePara> getPausePara(Map<String, List<String>> filterData) {
		Connection conn = RevorioConnect.getInstance().getConnection();
		List<PausePara> PauseParaData = null;
		PauseParaDBUtils dbUtils = PauseParaDBUtils.getInstance();
		try {
			String getPauseParaQuery = dbUtils.getPauseParaDataQuery(filterData);
			System.out.println("getPauseParaQuery: " + getPauseParaQuery);
			PreparedStatement pstmt = conn.prepareStatement(getPauseParaQuery);
			pstmt.setFetchSize(RCCLConstants.MID_FETCH_ROWS);
			ResultSet rs = pstmt.executeQuery();

			BeanListHandler<PausePara> handle = new BeanListHandler<PausePara>(PausePara.class);
			PauseParaData = handle.handle(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return PauseParaData;

	}

	//public boolean updatePauseParaData(PauseParaReq PauseParaReq) {
		/*
		 * Connection conn = RevorioConnect.getInstance().getConnection();
		 * PauseParaDBUtils dbUtils = PauseParaDBUtils.getInstance(); Integer status =
		 * 0; try { String updatePauseParaQuery =
		 * dbUtils.updatePauseParaQuery(PauseParaReq);
		 * System.out.println("updatePriceRangeQuery: " + updatePauseParaQuery);
		 * PreparedStatement pstmt = conn.prepareStatement(updatePauseParaQuery);
		 * pstmt.setFetchSize(RCCLConstants.MIN_FETCH_ROWS); status =
		 * pstmt.executeUpdate();
		 * 
		 * } catch (SQLException e) { e.printStackTrace(); } finally { try {
		 * conn.close(); } catch (SQLException e) { e.printStackTrace(); } } if (status
		 * == 0) { return false; } else { return true; }
		 */}




	