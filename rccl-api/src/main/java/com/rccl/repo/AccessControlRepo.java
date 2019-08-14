package com.rccl.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.dbutils.RevoreoConnect;
import com.rccl.utils.ConfigUtil;
import com.rccl.utils.RCCLConstants;
import com.rccl.utils.helper.RCCLException;

/**
 * The Class AccessControlRepo.
 */
public class AccessControlRepo {

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(AccessControlRepo.class);

	/**
	 * Gets the lock status.
	 * 
	 * @param jobName the job name
	 * @return the lock status
	 */
	public String getLockStatus(String jobName) {

		String SINGLE_QUOTE = RCCLConstants.SINGLE_QUOTE;
		ConfigUtil configInst = ConfigUtil.getInstance();
		String query = configInst.getLockStatus();
		String control_table_prefix = configInst.getValue(RCCLConstants.CONTROL_TABLE_PREFIX);
		jobName = control_table_prefix != null ? control_table_prefix.concat(jobName) : jobName;

		String finalQuery = query.replace(":value", SINGLE_QUOTE + jobName + SINGLE_QUOTE);
		logger.info("query for access control:" + finalQuery);

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

	public static void main(String[] args) {
		new AccessControlRepo().getLockStatus("price_range_para");
	}
}
