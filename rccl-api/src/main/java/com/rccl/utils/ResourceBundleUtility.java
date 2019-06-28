package com.rccl.utils;

import java.io.IOException;
import java.util.Properties;

// TODO: Auto-generated Javadoc
/**
 * The Class ResourceBundleUtility.
 */
public class ResourceBundleUtility {
	
	/** The Constant RCCL_CONFIG_PROPERTY_FILE. */
	private static final String RCCL_CONFIG_PROPERTY_FILE = "i18n.MessagesBundle_en_US.properties";
	
	/** The conf. */
	private static Properties conf = new Properties();

	/** The instance. */
	private static ResourceBundleUtility _instance;

	/**
	 * Gets the single instance of ResourceBundleUtility.
	 *
	 * @return single instance of ResourceBundleUtility
	 */
	public static ResourceBundleUtility getInstance() {
		if (_instance == null) {
			_instance = new ResourceBundleUtility();
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
	 * Gets the value.
	 *
	 * @param key the key
	 * @return the value
	 */
	public String getValue(String key) {
		return conf.getProperty(key);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		System.out.println(ResourceBundleUtility.getInstance().getValue(RCCLConstants.ERROR_METAPRODUCT));
	}
}
