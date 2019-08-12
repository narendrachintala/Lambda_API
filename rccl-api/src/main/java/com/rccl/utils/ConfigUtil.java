/*
 * 
 */
package com.rccl.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * The Class ConfigUtil.
 *
 * @author narendra.chintala
 * 
 *         The Class 'ConfigUtil' consists of queries required to retrieve the
 *         filter data.
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

	public static List<String> configuredTableList = getConfigTables();

	public static List<String> oracleDateErrorCodes = null;// getOracleDateErrorCodes();

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

	public String getTableName(String tableKey) {
		return conf.getProperty(tableKey);
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
		return conf.getProperty("get_price_range_data").replace(
				CustomFunctions.getNamedQuery(RCCLConstants.PRICE_RANGE_PARA),
				conf.getProperty(RCCLConstants.PRICE_RANGE_PARA));
	}

	/**
	 * Update price range data.
	 *
	 * @return the string
	 */
	public String updatePriceRangeData() {
		return conf.getProperty("update_price_range_para").replace(
				CustomFunctions.getNamedQuery(RCCLConstants.PRICE_RANGE_PARA),
				conf.getProperty(RCCLConstants.PRICE_RANGE_PARA));
	}

	/**
	 * Update pause para data.
	 *
	 * @return the string
	 */
	public String updatePauseParaData() {
		return conf.getProperty("update_pause_para").replace(CustomFunctions.getNamedQuery(RCCLConstants.PAUSE_PARA),
				conf.getProperty(RCCLConstants.PAUSE_PARA));
	}

	/**
	 * Gets the pause para data.
	 *
	 * @return the pause para data
	 */
	public String getPauseParaData() {
		return conf.getProperty("get_pause_para_data").replace(CustomFunctions.getNamedQuery(RCCLConstants.PAUSE_PARA),
				conf.getProperty(RCCLConstants.PAUSE_PARA));
	}

	/**
	 * Gets the rolling window data.
	 *
	 * @return the rolling window data
	 */
	public String getRollingWindowData() {
		return conf.getProperty("get_rolling_window_data").replace(
				CustomFunctions.getNamedQuery(RCCLConstants.ROLLING_WINDOW),
				conf.getProperty(RCCLConstants.ROLLING_WINDOW));
	}

	/**
	 * Update rolling window.
	 *
	 * @return the string
	 */
	public String updateRollingWindow() {
		return conf.getProperty("update_rolling_window_para").replace(
				CustomFunctions.getNamedQuery(RCCLConstants.ROLLING_WINDOW),
				conf.getProperty(RCCLConstants.ROLLING_WINDOW));
	}

	/**
	 * Gets the current price data.
	 *
	 * @return the current price data
	 */
	public String getCurrentPriceData() {
		return conf.getProperty("get_current_price_para").replace(
				CustomFunctions.getNamedQuery(RCCLConstants.CURRENT_PRICE_PARA),
				conf.getProperty(RCCLConstants.CURRENT_PRICE_PARA));
	}

	/**
	 * Update rolling window.
	 *
	 * @return the string
	 */
	public String updateCurrentPriceData() {
		return conf.getProperty("update_current_price_para").replace(
				CustomFunctions.getNamedQuery(RCCLConstants.CURRENT_PRICE_PARA),
				conf.getProperty(RCCLConstants.CURRENT_PRICE_PARA));
	}

	/**
	 * Gets the refundable premium data.
	 * 
	 * @return the refundable premium data
	 */
	public String getRefundablePremiumData() {
		return conf.getProperty("get_refundable_premium_data").replace(
				CustomFunctions.getNamedQuery(RCCLConstants.REFUNDABLE_PREMIUM),
				conf.getProperty(RCCLConstants.REFUNDABLE_PREMIUM));
	}

	public String updateRefundablePremium() {
		return conf.getProperty("update_refundable_premium_para").replace(
				CustomFunctions.getNamedQuery(RCCLConstants.REFUNDABLE_PREMIUM),
				conf.getProperty(RCCLConstants.REFUNDABLE_PREMIUM));
	}

	/**
	 * Gets the inversionGapPara data.
	 *
	 * @return the inversionGapPara data
	 */
	public String getinversionGapPara() {
		return conf.getProperty("get_inversion_gap_para").replace(
				CustomFunctions.getNamedQuery(RCCLConstants.INVERSION_GAP_PARA),
				conf.getProperty(RCCLConstants.INVERSION_GAP_PARA));
	}

	/**
	 * Update inversionGapPara.
	 *
	 * @return the string
	 */
	public String updateInversionGapsPara() {
		return conf.getProperty("update_inversionGapsPara").replace(
				CustomFunctions.getNamedQuery(RCCLConstants.INVERSION_GAP_PARA),
				conf.getProperty(RCCLConstants.INVERSION_GAP_PARA));
	}

	/**
	 * Gets the booked position para.
	 *
	 * @return the booked position para
	 */
	public String getBookedPositionPara() {
		return conf.getProperty("get_booked_position_data").replace(
				CustomFunctions.getNamedQuery(RCCLConstants.BOOKED_POSITION_PARA),
				conf.getProperty(RCCLConstants.BOOKED_POSITION_PARA));
	}

	/**
	 * Update BookedPositionPara.
	 *
	 * @return the string
	 */
	public String updateBookedPositionPara() {
		return conf.getProperty("update_booked_position_data").replace(
				CustomFunctions.getNamedQuery(RCCLConstants.BOOKED_POSITION_PARA),
				conf.getProperty(RCCLConstants.BOOKED_POSITION_PARA));
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
	 * Gets the lock status.
	 *
	 * @return the lock status
	 */
	public String getLockStatus() {
		return conf.getProperty("lock_status").replace(
				CustomFunctions.getNamedQuery(RCCLConstants.ACCESS_CONTROL_TABLE),
				conf.getProperty(RCCLConstants.ACCESS_CONTROL_TABLE));
	}

	/**
	 * Gets the value.
	 *
	 * @param key the key
	 * @return the value
	 */
	public String getValue(String key) {
		return conf.getProperty(key);
	}

	/**
	 * Gets the currency gap data.
	 *
	 * @return the currency gap data
	 */
	public String getCurrencyGapData() {
		return conf.getProperty("get_currency_gap_para").replace(
				CustomFunctions.getNamedQuery(RCCLConstants.CURRENCY_GAP_PARA),
				conf.getProperty(RCCLConstants.CURRENCY_GAP_PARA));
	}

	/**
	 * Update currency gap data.
	 *
	 * @return the string
	 */
	public String updateCurrencyGapData() {
		return conf.getProperty("update_currency_gap_para").replace(
				CustomFunctions.getNamedQuery(RCCLConstants.CURRENCY_GAP_PARA),
				conf.getProperty(RCCLConstants.CURRENCY_GAP_PARA));
	}

	/**
	 * Gets the configured tables.
	 *
	 * @return the configured tables
	 */
	private static List<String> getConfigTables() {
		configuredTableList = new ArrayList<String>();

		ConfigUtil configInst = ConfigUtil.getInstance();
		configuredTableList.add(configInst.getTableName(RCCLConstants.PAUSE_PARA).toLowerCase());
		configuredTableList.add(configInst.getTableName(RCCLConstants.PRICE_RANGE_PARA).toLowerCase());
		configuredTableList.add(configInst.getTableName(RCCLConstants.ROLLING_WINDOW).toLowerCase());
		configuredTableList.add(configInst.getTableName(RCCLConstants.CURRENT_PRICE_PARA).toLowerCase());
		configuredTableList.add(configInst.getTableName(RCCLConstants.REFUNDABLE_PREMIUM).toLowerCase());
		configuredTableList.add(configInst.getTableName(RCCLConstants.INVERSION_GAP_PARA).toLowerCase());
		configuredTableList.add(configInst.getTableName(RCCLConstants.CURRENCY_GAP_PARA).toLowerCase());
		configuredTableList.add(configInst.getTableName(RCCLConstants.BOOKED_POSITION_PARA).toLowerCase());
		return configuredTableList;
	}

	public static List<String> getOracleDateErrorCodes() {
		if (oracleDateErrorCodes == null) {
			oracleDateErrorCodes = new ArrayList<String>();
			oracleDateErrorCodes.add("ORA-01847");
			oracleDateErrorCodes.add("ORA-01843");
			oracleDateErrorCodes.add("ORA-01858");
		}
		return oracleDateErrorCodes;
	}
}
