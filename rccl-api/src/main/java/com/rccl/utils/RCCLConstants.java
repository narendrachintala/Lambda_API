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
	
	/**
	 * DB configuration constants
	 */
	public static final String HOST = "revoreo_host";
	public static final String REVOREO_PORT="revoreo_port";
	public static final String REVOREO_SERVICE="revoreo_service";
	public static final String REVOREO_UNAME="revoreo_uname";
	public static final String REVOREO_PWD="revoreo_pwd";
	
	
	/**
	 * Named query filed prefix
	 */
	
	public static final String NAMED_QRY_PREFIX = ":";
	public static final String LOCKED_CTRL_TBL_STS_FLAG = "Y";

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
	 * Table names
	 */
	
	public final static String PRICE_RANGE_PARA="price_range_para";
	public final static String PAUSE_PARA="pause_para";
	public final static String ROLLING_WINDOW="rolling_window_para";
	public static final String CURRENT_PRICE_PARA = "current_price_para";
	public static final String REFUNDABLE_PREMIUM = "refundable_premium_para";

	/**
	 * Filters data fields
	 */
	public final static String METAPRODUCT_F = "metaproduct";
	public final static String PRODUCT_CODE_F = "product_code";
	public final static String SHIP_CODE_F = "ship_code";
	public final static String SAIL_MONTH_F = "sail_month";
	public final static String SAIL_DATE_F = "sail_date";
	public final static String CAT_CLASS_F = "cat_class";
	public final static String CATEGORY_F = "category";
	public final static String OCCUPANCY_F = "occupancy";

	/**
	 * PriceRangePara table updatable columns
	 */

	public final static String L1_RANGE_MIN = "l1_range_min";
	public final static String L1_RANGE_MAX = "l1_range_max";
	public final static String L1_INSERT_DATE = "l1_insert_date";
	public final static String L2_RANGE_MIN = "l2_range_min";
	public final static String L2_RANGE_MAX = "l2_range_max";

	/**
	 * CurrentPricePara table update columns
	 */
	public static final  String CURRENCY = "currency";
	public static final  String METAPRODUCT = "metaproduct";
	public static final  String PRODUCT_CODE = "product_code";
	public static final  String SHIP_CODE = "ship_code";
	public static final  String SAIL_DATE = "sail_date";
	public static final  String SAIL_MONTH = "sail_month";
	public static final  String CAT_CLASS = "cat_class";
	public static final  String OCCUPANCY = "occupancy";
	
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
	public static final String SETTER_COLUMNS_Q = ":SETTER_COLUMNS";

	/**
	 * Rolling window table update columns
	 */
	public final static String PREV_FORECAST = "prev_forecast";
	public final static String FUT_FORECAST = "fut_forecast";
	public final static String PRICE_WINDOW = "price_window";
	public final static String WTS = "wts";
	public final static String PREV_DEMAND_WINDOW = "prev_demand_window";
	public final static String FUT_DEMAND_WINDOW = "fut_demand_window";
	
	/**
	 * Refundable Premium table update columns
	 */
	public final static String GAP_TYPE = "gap_type";
	public final static String CURRENT_GAP_PCT = "current_gap_pct";
	public final static String STANDARD_GAP_PCT = "standard_gap_pct";

	/**
	 * Error messages
	 */
	public final static String ERROR_JSON = "error_json";
	public final static String ERROR_METAPRODUCT="error_metaproduct";
	public final static String ERROR_TABLE_NAME="error_table_name";
	public final static String EX_GET_REQUEST="ex_get_request";
	public final static String ERROR_FILTERS_DATA="filters_data";
	public final static String ERROR_UPDATE_FIELDS="update_fields";
	public final static String LOCK_SET="lock_status";
	
	/**
	 * Status codes
	 */

	public final static int SC_OK = 200;
	public final static int SC_CREATED = 201;
	public final static int SC_BAD_REQUEST = 400;
	public final static int SC_LOCKED = 423;
	public final static int UN_AUTHORIZED = 401;
	public final static int FORBIDDEN = 403;
	public final static int SC_NOT_FOUND = 404;
	public final static int SC_INTERNAL_SERVER_ERROR = 500;

	/**
	 * Status Messages
	 */
	public final static String SUCCESS_MSG = "SUCCESS";
	public final static String BAD_REQUEST_MSG = "BAD_REQUEST";
	public final static String UN_AUTHORIZED_MSG = "UN_AUTHORIZED";
	public final static String FORBIDDEN_MSG = "FORBIDDEN";
	public final static String NOT_FOUND_MSG = "NOT_FOUND";
	public final static String SERVER_ERROR_MSG = "SERVER_ERROR";
	
	
	/**
	 * Query builder constatnts
	 */
	
	public final static String EQUALS = "=";
	public final static String COMMA = ",";
	public final static String SINGLE_QUOTE = "'";
	public final static String IN = " in (";
	public final static String AND = ") and ";

	/**
	 * pause para table update columns
	 */
	public final static String L1_PAUSE = "l1_pause";
	
}
