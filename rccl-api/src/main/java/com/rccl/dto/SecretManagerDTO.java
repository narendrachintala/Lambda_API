package com.rccl.dto;

/**
 * The Class SecretManagerDTO.
 */
public class SecretManagerDTO {
	
	/** The username. */
	private String username;
    
    /** The password. */
    private String password;
    
    /** The engine. */
    private String engine;
    
    /** The host. */
    private String host;
    
    /** The port. */
    private String port;
    
    /** The dbname. */
    private String dbname;
	
	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the engine.
	 *
	 * @return the engine
	 */
	public String getEngine() {
		return engine;
	}

	/**
	 * Sets the engine.
	 *
	 * @param engine the new engine
	 */
	public void setEngine(String engine) {
		this.engine = engine;
	}

	/**
	 * Gets the host.
	 *
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Sets the host.
	 *
	 * @param host the new host
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * Gets the port.
	 *
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * Sets the port.
	 *
	 * @param port the new port
	 */
	public void setPort(String port) {
		this.port = port;
	}

	/**
	 * Gets the dbname.
	 *
	 * @return the dbname
	 */
	public String getDbname() {
		return dbname;
	}

	/**
	 * Sets the dbname.
	 *
	 * @param dbname the new dbname
	 */
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
}
