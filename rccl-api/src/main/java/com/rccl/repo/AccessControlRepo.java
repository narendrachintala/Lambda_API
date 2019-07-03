package com.rccl.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rccl.dbutils.RevoreoConnect;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.helper.RCCLException;

/**
 * The Class AccessControlRepo.
 */
public class AccessControlRepo {
	
	/**
	 * Gets the lock status.
	 * @param jobName the job name
	 * @return the lock status
	 */
	public String getLockStatus(String jobName)  {
		
		String SINGLE_QUOTE = RCCLConstants.SINGLE_QUOTE;
		
		ConfigUtil configInst = ConfigUtil.getInstance();
		String query = configInst.getLockStatus();
		
		String finalQuery = query.replace(":value", SINGLE_QUOTE + jobName + SINGLE_QUOTE);
		System.out.println("final query" + finalQuery);
		
		Connection con = RevoreoConnect.getInstance().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String lockStatus = "";
		try {
			stmt = con.prepareStatement(finalQuery);
		} catch (SQLException e) {
			throw new RCCLException("Error while initializing the database connection", e);
		}
		try {
			rs = stmt.executeQuery();
			while (rs.next()) {
				lockStatus = rs.getString("lock_status_code");
			}
		} catch (Exception e) {
			throw new RCCLException("error in querying table", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new RCCLException("error in querying table", e);
			}
		}
		return lockStatus;
	}
}
