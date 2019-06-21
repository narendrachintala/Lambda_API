package com.rccl.processor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.rccl.dbutils.RevorioConnect;
import com.rccl.utils.helper.RCCLException;

public class QueryExecutor {

	public void execute(String query, List<String> params, Context context) {
		LambdaLogger logger = context.getLogger();
		Connection con = RevorioConnect.getInstance().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int i = 0;

		try {
			logger.log("executing query : " + query);
			stmt = con.prepareStatement(query);
		} catch (SQLException e) {
			throw new RCCLException("Error while initializing the database connection", e);
		}

		try {
			i = 1;
			for (String p : params) {
				logger.log("param" + i + ":" + p);
				stmt.setString(i++, p);
			}
			logger.log("statement object :" + stmt);
			rs = stmt.executeQuery();

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
	}

	public int executeUpdate(String query, List<String> params, Context context) {
		LambdaLogger logger = context.getLogger();
		Connection con = RevorioConnect.getInstance().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int i = 0;
		int result = 0;

		try {
			logger.log("executing query : " + query);
			stmt = con.prepareStatement(query);
		} catch (SQLException e) {
			throw new RCCLException("Error while initializing the database connection", e);
		}

		try {
			i = 1;
			for (String p : params) {
				logger.log("param" + i + ":" + p);
				stmt.setString(i++, p);
			}
			logger.log("statement object :" + stmt);
			result = stmt.executeUpdate();
			return result;
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
	}

}
