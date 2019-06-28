package com.rccl.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * The Class ConfigUtil.
 *
 * @author narendra.chintala
 * 
 * The Class 'ConfigUtil' consists of queries required to retrieve the filter data.
 */
public class ConfigUtil {
	
	/*
	 * static { System.setProperty("java.util.logging.manager",
	 * "org.apache.logging.log4j.jul.LogManager");
	 * System.setProperty("log4j.configurationFile", "resources/lambda-log4j2.xml");
	 * }
	 */

	/** The Constant RCCL_CONFIG_PROPERTY_FILE. */
	private static final String RCCL_CONFIG_PROPERTY_FILE = "rccl_config.properties";
	
	/** The conf. */
	private static Properties conf = new Properties();

	/** The instance. */
	private static ConfigUtil _instance;

	/**
	 * Gets the single instance of ConfigUtil.
	 *
	 * @return single instance of ConfigUtil
	 */
	public static ConfigUtil getInstance() {
		if (_instance == null) {
			_instance = new ConfigUtil();
			try {
				conf.load(
						Thread.currentThread().getContextClassLoader().getResourceAsStream(RCCL_CONFIG_PROPERTY_FILE));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return _instance;
	}

	/**
	 * Gets the filter data query.
	 *
	 * @return the filter data query
	 */
	public String getFilterDataQuery() {
		return conf.getProperty("get_filter_values");
	}

	/**
	 * Gets the price range data.
	 *
	 * @return the price range data
	 */
	public String getPriceRangeData() {
		return conf.getProperty("get_price_range_data");
	}

	/**
	 * Update price range data.
	 *
	 * @return the string
	 */
	public String updatePriceRangeData() {
		return conf.getProperty("update_price_range_para");
	}

	/**
	 * Update pause para data.
	 *
	 * @return the string
	 */
	public String updatePauseParaData() {
		return conf.getProperty("update_pause_para");
	}

	/**
	 * Gets the pause para data.
	 *
	 * @return the pause para data
	 */
	public String getPauseParaData() {
		return conf.getProperty("get_pause_para_data");
	}

	/**
	 * Gets the rolling window data.
	 *
	 * @return the rolling window data
	 */
	public String getRollingWindowData() {
		return conf.getProperty("get_rolling_window_data");
	}

	/**
	 * Gets the secret managemer name.
	 *
	 * @return the secret managemer name
	 */
	public String getSecretManagemerName() {
		return conf.getProperty("secret-manager");
	}

	/**
	 * Gets the end point.
	 *
	 * @return the end point
	 */
	public String getEndPoint() {
		return conf.getProperty("endpoint");
	}

	/**
	 * Gets the region.
	 *
	 * @return the region
	 */
	public String getRegion() {
		return conf.getProperty("region");
	}

	/**
	 * Update rolling window.
	 *
	 * @return the string
	 */
	public String updateRollingWindow() {
		return conf.getProperty("update_rolling_window_para");
	}

}
