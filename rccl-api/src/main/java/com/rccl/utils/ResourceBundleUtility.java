package com.rccl.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleUtility {
	public static ResourceBundleUtility getInstance() {
		if (_instance == null) {
			_instance = new ResourceBundleUtility();
		}
		return _instance;
	}

	private static ResourceBundleUtility _instance;

	public String getProperty(String key) {
		return ResourceBundle.getBundle("i18n.MessagesBundle", new Locale("en", "US")).getString(key);
	}
	
	public static void main(String[] args) {
		System.out.println(ResourceBundleUtility.getInstance().getProperty("error"));
	}
}
