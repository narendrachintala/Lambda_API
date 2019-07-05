package com.rccl.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * The Class RevoreoConnect.
 */
public class RevoreoConnect {

	/** The connection. */
	private Connection connection = null;
	
	/** The instance. */
	private static RevoreoConnect _instance;
	

	/**
	 * Gets the single instance of RevoreoConnect.
	 *
	 * @return single instance of RevoreoConnect
	 */
	public static RevoreoConnect getInstance() {
		if (_instance == null) {
			_instance = new RevoreoConnect();
		}
		System.out.println("initializing oracle connection");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle driver loaded");
			_instance.setConnection(DriverManager.getConnection(
					"jdbc:oracle:thin:@//edssp-exa.rccl.com:1689/srvc_dss_rptg_edss.rccl.com", "revoreo",
					"B222330EE3+00D65A"));
			System.out.println("oracle connection established");
		} catch (Exception ioe) {
			System.out.println("Error while establishing oracle connection: " + ioe.getMessage());
			try {
				_instance.getConnection().close();
			} catch (Exception e) {
				System.out.println("Error in closing oracle connection: " + e.getMessage());
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
			System.out.println("Closing oracle connection");
			getConnection().close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in closing oracle connection: " + e.getMessage());

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
		this.connection = connection;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		System.out.println(RevoreoConnect.getInstance());
	}

}
