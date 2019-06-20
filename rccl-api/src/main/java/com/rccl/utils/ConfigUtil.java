package com.rccl.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author narendra.chintala
 *
 */
public class ConfigUtil {
	private static final String RCCL_CONFIG_PROPERTY_FILE = "rccl_config.properties";
	private static Properties conf = new Properties();

	private static ConfigUtil _instance;

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

	public String getFilterDataQuery() {
		return conf.getProperty("get_filter_values");
	}

	public String getPriceRangeData() {
		return conf.getProperty("get_price_range_data");
	}

	public String updatePriceRangeData() {
		return conf.getProperty("update_price_range_para");
	}

	public String updatePauseParaData() {
		return conf.getProperty("update_pause_para");
	}

	public String getPauseParaData() {
		return conf.getProperty("get_pause_para_data");
	}
	
	public String getRollingWindowData() {
		return conf.getProperty("get_rolling_window_data");
	}

	public String getSecretManagemerName() {
		return conf.getProperty("secret-manager");
	}
	
	public String getEndPoint() {
		return conf.getProperty("endpoint");
	}
	
	public String getRegion() {
		return conf.getProperty("region");
	}
	
	public String updateRollingWindow() {
		return conf.getProperty("update_rolling_window_para");
	}

}
