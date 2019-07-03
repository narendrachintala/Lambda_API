package com.rccl.utils;

import com.rccl.model.ErrorMessage;
import com.rccl.model.GatewayResponse;

public class CustomErrors {

	// Read error messages from property file
	private static ResourceBundleUtility rBundleUtility = ResourceBundleUtility.getInstance();

	public static GatewayResponse<ErrorMessage> error_json() {
		return ResponseUtil.getCustErrorMessage(rBundleUtility.getValue(RCCLConstants.ERROR_JSON),
				RCCLConstants.SC_BAD_REQUEST);
	}

	public static GatewayResponse<ErrorMessage> error_filters_data() {
		return ResponseUtil.getCustErrorMessage(rBundleUtility.getValue(RCCLConstants.ERROR_FILTERS_DATA),
				RCCLConstants.SC_BAD_REQUEST);
	}

	public static GatewayResponse<ErrorMessage> error_metaproduct() {
		return ResponseUtil.getCustErrorMessage(rBundleUtility.getValue(RCCLConstants.ERROR_METAPRODUCT),
				RCCLConstants.SC_BAD_REQUEST);
	}

	public static GatewayResponse<ErrorMessage> error_update_fields() {
		return ResponseUtil.getCustErrorMessage(rBundleUtility.getValue(RCCLConstants.ERROR_UPDATE_FIELDS),
				RCCLConstants.SC_BAD_REQUEST);
	}

	public static GatewayResponse<ErrorMessage> error_table_name() {
		return ResponseUtil.getCustErrorMessage(rBundleUtility.getValue(RCCLConstants.ERROR_TABLE_NAME),
				RCCLConstants.SC_BAD_REQUEST);
	}

}
