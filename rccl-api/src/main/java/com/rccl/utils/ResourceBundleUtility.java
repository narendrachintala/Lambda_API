package com.rccl.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * The Class ResourceBundleUtility.
 */
public class ResourceBundleUtility {
	private static final String RCCL_CONFIG_PROPERTY_FILE = "i18n.MessagesBundle_en_US.properties";
	private static Properties conf = new Properties();

	private static ResourceBundleUtility _instance;

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

	public String getValue(String key) {
		return conf.getProperty(key);
	}

	public static void main(String[] args) {
		System.out.println(ResourceBundleUtility.getInstance().getValue(RCCLConstants.ERROR_METAPRODUCT));
	}
}
