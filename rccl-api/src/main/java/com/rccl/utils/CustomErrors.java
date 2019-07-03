package com.rccl.utils;

import com.rccl.model.ErrorMessage;
import com.rccl.model.GatewayResponse;

/**
 * @author narendra.chintala
 *
 */

/**
 * The Class CustomErrors.
 */
public class CustomErrors {

	/** The r bundle utility. */
	// Read error messages from property file
	private static ResourceBundleUtility rBundleUtility = ResourceBundleUtility.getInstance();

	/**
	 * Error json.
	 *
	 * @return the gateway response
	 */
	public static GatewayResponse<ErrorMessage> error_json() {
		return ResponseUtil.getCustErrorMessage(rBundleUtility.getValue(RCCLConstants.ERROR_JSON),
				RCCLConstants.SC_BAD_REQUEST);
	}

	/**
	 * Error filters data.
	 *
	 * @return the gateway response
	 */
	public static GatewayResponse<ErrorMessage> error_filters_data() {
		return ResponseUtil.getCustErrorMessage(rBundleUtility.getValue(RCCLConstants.ERROR_FILTERS_DATA),
				RCCLConstants.SC_BAD_REQUEST);
	}

	/**
	 * Error metaproduct.
	 *
	 * @return the gateway response
	 */
	public static GatewayResponse<ErrorMessage> error_metaproduct() {
		return ResponseUtil.getCustErrorMessage(rBundleUtility.getValue(RCCLConstants.ERROR_METAPRODUCT),
				RCCLConstants.SC_BAD_REQUEST);
	}

	/**
	 * Error update fields.
	 *
	 * @return the gateway response
	 */
	public static GatewayResponse<ErrorMessage> error_update_fields() {
		return ResponseUtil.getCustErrorMessage(rBundleUtility.getValue(RCCLConstants.ERROR_UPDATE_FIELDS),
				RCCLConstants.SC_BAD_REQUEST);
	}

	/**
	 * Error table name.
	 *
	 * @return the gateway response
	 */
	public static GatewayResponse<ErrorMessage> error_table_name() {
		return ResponseUtil.getCustErrorMessage(rBundleUtility.getValue(RCCLConstants.ERROR_TABLE_NAME),
				RCCLConstants.SC_BAD_REQUEST);
	}

	/**
	 * Error locked.
	 *
	 * @return the gateway response
	 */
	public static GatewayResponse<ErrorMessage> error_locked() {
		return ResponseUtil.getCustErrorMessage(rBundleUtility.getValue(RCCLConstants.LOCK_SET),
				RCCLConstants.SC_LOCKED);
	}

}
