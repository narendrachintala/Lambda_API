package com.rccl.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.dto.SecretManagerDTO;

/**
 * The Class RevoreoConnect.
 */
public class RevoreoConnect {

	static final Logger logger = LogManager.getLogger(RevoreoConnect.class);

	/** The connection. */
	private static Connection connection = null;

	/** The instance. */
	private static RevoreoConnect _instance;

	/**
	 * Gets the single instance of RevoreoConnect.
	 *
	 * @return single instance of RevoreoConnect
	 * @throws SQLException
	 */
	public static RevoreoConnect getInstance() {
		try {
			if (_instance == null) {
				_instance = new RevoreoConnect();
			}
			synchronized (_instance) {
				if (_instance.getConnection() == null || _instance.getConnection().isClosed()) {
					if (_instance.getConnection() != null) {
						logger.info("is oracle connection closed: " + _instance.getConnection().isClosed());
					}
					initializeConn();
				}
			}
		} catch (Exception e) {
			logger.error(e);
		}

		return _instance;

	}

	public static RevoreoConnect initializeConn() {
		logger.info("initializing oracle connection");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			logger.info("Oracle driver loaded");
			SecretManagerDTO secretManager = GetSecretValue.getSecret();
			_instance
					.setConnection(DriverManager.getConnection(
							"jdbc:oracle:thin:@//" + secretManager.getHost() + ":" + secretManager.getPort() + "/"
									+ secretManager.getDbname(),
							secretManager.getUsername(), secretManager.getPassword()));
			logger.info("oracle connection established");
		} catch (Exception ioe) {
			logger.error("Error while establishing oracle connection: " + ioe.getMessage());
			try {
				_instance.getConnection().close();
			} catch (Exception e) {
				logger.error("Error in closing oracle connection: " + e.getMessage());
			}
			_instance = null;
		}
		return _instance;
	}

	/**
	 * Close connection.
	 *
	 * @return true, if successful
	 */
	public boolean closeConnection() {
		try {
			logger.info("Closing oracle connection");
			getConnection().close();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in closing oracle connection: " + e.getMessage());

		}
		return true;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * Sets the connection.
	 *
	 * @param connection the new connection
	 */
	public void setConnection(Connection connection) {
		RevoreoConnect.connection = connection;
	}

	public static void initializeDBConnection() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(new Runnable() {
			public void run() {
				logger.info("executing run method to establish connection.");
				RevoreoConnect.getInstance().getConnection();
			}
		});
		executorService.shutdown();
	}
}
