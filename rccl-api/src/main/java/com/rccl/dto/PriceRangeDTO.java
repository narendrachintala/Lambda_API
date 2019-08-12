package com.rccl.dto;

import com.rccl.utils.CustomFunctions;

/**
 * The Class PriceRangeDTO.
 *
 * @author narendra.chintala
 */
public class PriceRangeDTO {

	/** The currency. */
	private String currency;
	
	/** The metaproduct. */
	private String metaproduct;
	
	/** The product code. */
	private String product_code;
	
	/** The ship code. */
	private String ship_code;
	
	/** The sail month. */
	private Integer sail_month;
	
	/** The sail date. */
	private String sail_date;
	
	/** The cat class. */
	private String cat_class;
	
	/** The occupancy. */
	private String occupancy;
	
	/** The l 1 range min. */
	private Double l1_range_min;
	
	/** The l 1 range max. */
	private Double l1_range_max;
	
	/** The l 1 insert date. */
	private String l1_insert_date;
	
	/** The l 2 range min. */
	private Double l2_range_min;
	
	/** The l 2 range max. */
	private Double l2_range_max;
	
	/** The l 2 insert date. */
	private String l2_insert_date;
	
	/** The user id. */
	private String user_id;

	/**
	 * Gets the currency.
	 *
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Sets the currency.
	 *
	 * @param currency the new currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Gets the metaproduct.
	 *
	 * @return the metaproduct
	 */
	public String getMetaproduct() {
		return metaproduct;
	}

	/**
	 * Sets the metaproduct.
	 *
	 * @param metaproduct the new metaproduct
	 */
	public void setMetaproduct(String metaproduct) {
		this.metaproduct = metaproduct;
	}

	/**
	 * Gets the product code.
	 *
	 * @return the product code
	 */
	public String getProduct_code() {
		return product_code;
	}

	/**
	 * Sets the product code.
	 *
	 * @param product_code the new product code
	 */
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	/**
	 * Gets the ship code.
	 *
	 * @return the ship code
	 */
	public String getShip_code() {
		return ship_code;
	}

	/**
	 * Sets the ship code.
	 *
	 * @param ship_code the new ship code
	 */
	public void setShip_code(String ship_code) {
		this.ship_code = ship_code;
	}

	/**
	 * Gets the sail month.
	 *
	 * @return the sail month
	 */
	public Integer getSail_month() {
		return sail_month;
	}

	/**
	 * Sets the sail month.
	 *
	 * @param sail_month the new sail month
	 */
	public void setSail_month(Integer sail_month) {
		this.sail_month = sail_month;
	}

	/**
	 * Gets the sail date.
	 *
	 * @return the sail date
	 */
	public String getSail_date() {
		return sail_date;
	}

	/**
	 * Sets the sail date.
	 *
	 * @param sail_date the new sail date
	 * @throws Exception 
	 */
	public void setSail_date(String sail_date) throws Exception {
		this.sail_date = CustomFunctions.formatSailDate(sail_date);
	}

	/**
	 * Gets the cat class.
	 *
	 * @return the cat class
	 */
	public String getCat_class() {
		return cat_class;
	}

	/**
	 * Sets the cat class.
	 *
	 * @param cat_class the new cat class
	 */
	public void setCat_class(String cat_class) {
		this.cat_class = cat_class;
	}

	/**
	 * Gets the occupancy.
	 *
	 * @return the occupancy
	 */
	public String getOccupancy() {
		return occupancy;
	}

	/**
	 * Sets the occupancy.
	 *
	 * @param occupancy the new occupancy
	 */
	public void setOccupancy(String occupancy) {
		this.occupancy = occupancy;
	}

	/**
	 * Gets the l 1 range min.
	 *
	 * @return the l 1 range min
	 */
	public Double getL1_range_min() {
		return l1_range_min;
	}

	/**
	 * Sets the l 1 range min.
	 *
	 * @param l1_range_min the new l 1 range min
	 */
	public void setL1_range_min(Double l1_range_min) {
		this.l1_range_min = l1_range_min;
	}

	/**
	 * Gets the l 1 range max.
	 *
	 * @return the l 1 range max
	 */
	public Double getL1_range_max() {
		return l1_range_max;
	}

	/**
	 * Sets the l 1 range max.
	 *
	 * @param l1_range_max the new l 1 range max
	 */
	public void setL1_range_max(Double l1_range_max) {
		this.l1_range_max = l1_range_max;
	}

	/**
	 * Gets the l 1 insert date.
	 *
	 * @return the l 1 insert date
	 */
	public String getL1_insert_date() {
		return l1_insert_date;
	}

	/**
	 * Sets the l 1 insert date.
	 *
	 * @param l1_insert_date the new l 1 insert date
	 */
	public void setL1_insert_date(String l1_insert_date) throws Exception {
		this.l1_insert_date = CustomFunctions.formatInsertDate(l1_insert_date);
	}

	/**
	 * Gets the l 2 range min.
	 *
	 * @return the l 2 range min
	 */
	public Double getL2_range_min() {
		return l2_range_min;
	}

	/**
	 * Sets the l 2 range min.
	 *
	 * @param l2_range_min the new l 2 range min
	 */
	public void setL2_range_min(Double l2_range_min) {
		this.l2_range_min = l2_range_min;
	}

	/**
	 * Gets the l 2 range max.
	 *
	 * @return the l 2 range max
	 */
	public Double getL2_range_max() {
		return l2_range_max;
	}

	/**
	 * Sets the l 2 range max.
	 *
	 * @param l2_range_max the new l 2 range max
	 */
	public void setL2_range_max(Double l2_range_max) {
		this.l2_range_max = l2_range_max;
	}

	/**
	 * Gets the l 2 insert date.
	 *
	 * @return the l 2 insert date
	 */
	public String getL2_insert_date() {
		return l2_insert_date;
	}

	/**
	 * Sets the l 2 insert date.
	 *
	 * @param l2_insert_date the new l 2 insert date
	 * @throws Exception 
	 */
	public void setL2_insert_date(String l2_insert_date) throws Exception {
		this.l2_insert_date = CustomFunctions.formatInsertDate(l2_insert_date);
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * Sets the user id.
	 *
	 * @param user_id the new user id
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

}
