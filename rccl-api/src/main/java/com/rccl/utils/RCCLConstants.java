package com.rccl.utils;

/**
 * 
 * @author narendra.chintala
 *
 */
public class RCCLConstants {
	
	/**
	 * DB Keys
	 */
	
	public final static Integer MIN_FETCH_ROWS = 100;
	public final static Integer MID_FETCH_ROWS = 250;
	public final static Integer MAX_FETCH_ROWS = 500;
	
	/**
	 * 
	 */
	public static final String FILTER_DATA_COLUMN = "filterData";

	/*
	 * Filter names
	 */
	/*
	 * public final static String META_PRODUCT = "Meta Product"; public final static
	 * String PRODUCT_CODE = "Product Code"; public final static String SHIP_CODE =
	 * "Ship Code"; public final static String SAIL_MONTH = "Sail Month"; public
	 * final static String SAIL_DATE = "Sail Date"; public final static String
	 * CAT_CLASS = "Cat Class"; public final static String OCCUPANCY = "Occupancy";
	 */

	/**
	 * Filters data fields
	 */
	public final static String METAPRODUCT_F = "metaproduct";
	public final static String PRODUCT_CODE_F = "product_code";
	public final static String SHIP_CODE_F = "ship_code";
	public final static String SAIL_MONTH_F = "sail_month";
	public final static String SAIL_DATE_F = "sail_date";
	public final static String CAT_CLASS_F = "cat_class";
	public final static String OCCUPANCY_F = "occupancy";
	
	/**
	 * UI keys
	 */
	public static final String PRICE_RANGE_MIN = "price_range_min";
	public static final String PRICE_RANGE_MAX = "price_range_max";
	public static final String FILTER_DATA = "filter_criteria";
	public static final String TABLE_NAME = "table_name";
	
	
	/**
	 * Named queries
	 */
	public static final String TABLE_NAME_Q = ":TABLE_NAME";
	public static final String FILTER_COLUMN_Q = ":FILTER_COLUMN";
	public static final String WHERE_CONDITION_Q = ":WHERE_CONDITION";

}
