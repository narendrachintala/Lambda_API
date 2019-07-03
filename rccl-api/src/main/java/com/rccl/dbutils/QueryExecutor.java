package com.rccl.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.util.CollectionUtils;
import com.rccl.processor.ResultProcessor;
import com.rccl.repo.FilterDataRepo;
import com.rccl.utils.helper.RCCLException;

/**
 * The Class QueryExecutor.
 */
public class QueryExecutor {

	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(FilterDataRepo.class);

	/**
	 * Execute.
	 * 
	 * @param                 'query' final input query
	 * @param                 'logger' is used to generate the output logs
	 * @param resultProcessor the result processor
	 */
	public void execute(String query, ResultProcessor<?> resultProcessor) {
		if (resultProcessor == null) {
			throw new RCCLException("Please add resultProcessor", null);
		}
		// connect to oracle revoreo schema
		Connection con = RevoreoConnect.getInstance().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// Executes the input query else will throw exception
		try {
			logger.info("executing query : " + query);
			stmt = con.prepareStatement(query);
		} catch (SQLException e) {
			throw new RCCLException("Error while initializing the database connection", e);
		}
		// Returns the result else will throw the exception
		try {
			stmt.setFetchSize(resultProcessor.getFetchSize());
			rs = stmt.executeQuery();
			if (rs != null) {
				resultProcessor.processResult(rs);
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
	}

	/**
	 * Execute update.
	 * 
	 * @param query  the query
	 * @param params the params
	 * @param logger the logger
	 * @return the int
	 */
	public int executeUpdate(String query, List<String> params) {

		Connection con = RevoreoConnect.getInstance().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int i = 0;
		int result = 0;
		try {
			logger.info("executing query : " + query);
			stmt = con.prepareStatement(query);
		} catch (SQLException e) {
			throw new RCCLException("Error while initializing the database connection", e);
		}
		try {
			i = 1;
			if (!CollectionUtils.isNullOrEmpty(params)) {
				for (String p : params) {
					logger.debug("param" + i + ":" + p);
					stmt.setString(i++, p);
				}
			}
			logger.debug("statement object :" + stmt);
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
