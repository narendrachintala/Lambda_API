package com.rccl.utils;

import java.text.MessageFormat;

import com.rccl.model.GatewayResponse;

/**
 *
 * @author narendra.chintala
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
	public static GatewayResponse error_json() {
		return ResponseUtil.getCustErrorMessage(rBundleUtility.getValue(RCCLConstants.ERROR_JSON),
				RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
	}

	/**
	 * Error filters data.
	 *
	 * @return the gateway response
	 */
	public static GatewayResponse error_filters_data() {
		return ResponseUtil.getCustErrorMessage(rBundleUtility.getValue(RCCLConstants.ERROR_FILTERS_DATA),
				RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
	}

	/**
	 * Error metaproduct.
	 *
	 * @return the gateway response
	 */
	public static GatewayResponse error_metaproduct() {
		return ResponseUtil.getCustErrorMessage(rBundleUtility.getValue(RCCLConstants.ERROR_METAPRODUCT),
				RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
	}

	/**
	 * Error update fields.
	 *
	 * @return the gateway response
	 */
	public static GatewayResponse error_update_fields() {
		return ResponseUtil.getCustErrorMessage(rBundleUtility.getValue(RCCLConstants.ERROR_UPDATE_FIELDS),
				RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
	}

	/**
	 * Error update column values l1pause.
	 *
	 * @return the gateway response
	 */
	public static GatewayResponse error_l1_pause() {
		return ResponseUtil.getCustErrorMessage(rBundleUtility.getValue(RCCLConstants.L1PAUSE_UPDATE_VALUES),
				RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
	}

	/**
	 * Error update column values Refundable_premium.
	 *
	 * @return the gateway response
	 */
	public static GatewayResponse error_gap_type() {
		return ResponseUtil.getCustErrorMessage(rBundleUtility.getValue(RCCLConstants.REFUNABLE_UPDATE_VALUES),
				RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
	}

	/**
	 * Error table name.
	 *
	 * @return the gateway response
	 */
	public static GatewayResponse error_table_name() {
		return ResponseUtil.getCustErrorMessage(rBundleUtility.getValue(RCCLConstants.ERROR_TABLE_NAME),
				RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
	}

	/**
	 * Error locked.
	 *
	 * @return the gateway response
	 */
	public static GatewayResponse error_locked() {
		return ResponseUtil.getCustErrorMessage(rBundleUtility.getValue(RCCLConstants.LOCK_SET),
				RCCLConstants.SC_LOCKED, RCCLConstants.REQUEST_ID);
	}

	/**
	 * Error in l 1 range.
	 *
	 * @param l1min the l 1 minval
	 * @param l1max the l 1 maxval
	 * @return the gateway response
	 */
	public static GatewayResponse error_in_l1_range(double l1min, double l1max) {

		String message = MessageFormat.format(rBundleUtility.getValue(RCCLConstants.ERROR_IN_L1_RANGE), l1min, l1max);
		return ResponseUtil.getCustErrorMessage(message, RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
	}

	/**
	 * Error in l 2 range.
	 *
	 * @param l2min the l 2 min
	 * @param l2max the l 2 max
	 * @return the gateway response
	 */
	public static GatewayResponse error_in_l2_range(double l2min, double l2max) {

		String message = MessageFormat.format(rBundleUtility.getValue(RCCLConstants.ERROR_IN_L2_RANGE), l2min, l2max);
		return ResponseUtil.getCustErrorMessage(message, RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
	}

	/**
	 * Error max vs min range.
	 *
	 * @return the gateway response
	 */
	public static GatewayResponse error_max_vs_min_range() {

		return ResponseUtil.getCustErrorMessage(rBundleUtility.getValue(RCCLConstants.ERROR_MAX_VS_MIN_RANGE),
				RCCLConstants.SC_BAD_REQUEST, RCCLConstants.REQUEST_ID);
	}

}
