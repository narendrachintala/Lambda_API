package com.rccl.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;

public class RevorioConnect {

	private static Connection connection = null;
	private static RevorioConnect _instance;

	public static RevorioConnect getInstance() {
		if (_instance == null) {
			_instance = new RevorioConnect();
			System.out.println("initializing oracle connection");
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("Oracle driver loaded");
				_instance.setConnection(DriverManager.getConnection(
						  "jdbc:oracle:thin:@//<host>:<port>/<service_name>", "<schema>",
						  "<password>"));
				System.out.println("oracle connection established");
			} catch (Exception ioe) {
				System.out.println("Error while establishing oracle connection: "+ioe.getMessage());
				try {
					_instance.getConnection().close();
				} catch (Exception e) {
					System.out.println("Error in closing oracle connection: "+e.getMessage());
				}
				_instance = null;
			}
		}
		return _instance;
	}

	public boolean closeConnection() {
		try {
			System.out.println("Closing oracle connection");
			getConnection().close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in closing oracle connection: "+e.getMessage());

		}
		return true;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connections) {
		connection = connections;
	}

	public static void main(String[] args) {
		System.out.println(RevorioConnect.getInstance());
	}

}
