package com.rccl.dto;

import com.rccl.utils.CustomFunctions;

// TODO: Auto-generated Javadoc
/**
 * The Class InversionGapsParaDTO.
 */
public class InversionGapsParaDTO {

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

	/** The occupancy. */
	private String occupancy;

	/** The order 1. */
	private String order_1;

	/** The order 2. */
	private String order_2;

	/** The order 3. */
	private String order_3;

	/** The order 4. */
	private String order_4;

	/** The order 5. */
	private String order_5;

	/** The order 6. */
	private String order_6;

	/** The gap 1. */
	private Integer gap_1;

	/** The gap 2. */
	private Integer gap_2;

	/** The gap 3. */
	private Integer gap_3;

	/** The gap 4. */
	private Integer gap_4;

	/** The gap 5. */
	private Integer gap_5;

	/** The gap 6. */
	private Integer gap_6;

	/** The l 1 insert date. */
	private String l1_insert_date;

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
	 * Gets the order 1.
	 *
	 * @return the order 1
	 */
	public String getOrder_1() {
		return order_1;
	}

	/**
	 * Sets the order 1.
	 *
	 * @param order_1 the new order 1
	 */
	public void setOrder_1(String order_1) {
		this.order_1 = order_1;
	}

	/**
	 * Gets the order 2.
	 *
	 * @return the order 2
	 */
	public String getOrder_2() {
		return order_2;
	}

	/**
	 * Sets the order 2.
	 *
	 * @param order_2 the new order 2
	 */
	public void setOrder_2(String order_2) {
		this.order_2 = order_2;
	}

	/**
	 * Gets the order 3.
	 *
	 * @return the order 3
	 */
	public String getOrder_3() {
		return order_3;
	}

	/**
	 * Sets the order 3.
	 *
	 * @param order_3 the new order 3
	 */
	public void setOrder_3(String order_3) {
		this.order_3 = order_3;
	}

	/**
	 * Gets the order 4.
	 *
	 * @return the order 4
	 */
	public String getOrder_4() {
		return order_4;
	}

	/**
	 * Sets the order 4.
	 *
	 * @param order_4 the new order 4
	 */
	public void setOrder_4(String order_4) {
		this.order_4 = order_4;
	}

	/**
	 * Gets the order 5.
	 *
	 * @return the order 5
	 */
	public String getOrder_5() {
		return order_5;
	}

	/**
	 * Sets the order 5.
	 *
	 * @param order_5 the new order 5
	 */
	public void setOrder_5(String order_5) {
		this.order_5 = order_5;
	}

	/**
	 * Gets the order 6.
	 *
	 * @return the order 6
	 */
	public String getOrder_6() {
		return order_6;
	}

	/**
	 * Sets the order 6.
	 *
	 * @param order_6 the new order 6
	 */
	public void setOrder_6(String order_6) {
		this.order_6 = order_6;
	}

	/**
	 * Gets the gap 1.
	 *
	 * @return the gap 1
	 */
	public Integer getGap_1() {
		return gap_1;
	}

	/**
	 * Sets the gap 1.
	 *
	 * @param gap_1 the new gap 1
	 */
	public void setGap_1(Integer gap_1) {
		this.gap_1 = gap_1;
	}

	/**
	 * Gets the gap 2.
	 *
	 * @return the gap 2
	 */
	public Integer getGap_2() {
		return gap_2;
	}

	/**
	 * Sets the gap 2.
	 *
	 * @param gap_2 the new gap 2
	 */
	public void setGap_2(Integer gap_2) {
		this.gap_2 = gap_2;
	}

	/**
	 * Gets the gap 3.
	 *
	 * @return the gap 3
	 */
	public Integer getGap_3() {
		return gap_3;
	}

	/**
	 * Sets the gap 3.
	 *
	 * @param gap_3 the new gap 3
	 */
	public void setGap_3(Integer gap_3) {
		this.gap_3 = gap_3;
	}

	/**
	 * Gets the gap 4.
	 *
	 * @return the gap 4
	 */
	public Integer getGap_4() {
		return gap_4;
	}

	/**
	 * Sets the gap 4.
	 *
	 * @param gap_4 the new gap 4
	 */
	public void setGap_4(Integer gap_4) {
		this.gap_4 = gap_4;
	}

	/**
	 * Gets the gap 5.
	 *
	 * @return the gap 5
	 */
	public Integer getGap_5() {
		return gap_5;
	}

	/**
	 * Sets the gap 5.
	 *
	 * @param gap_5 the new gap 5
	 */
	public void setGap_5(Integer gap_5) {
		this.gap_5 = gap_5;
	}

	/**
	 * Gets the gap 6.
	 *
	 * @return the gap 6
	 */
	public Integer getGap_6() {
		return gap_6;
	}

	/**
	 * Sets the gap 6.
	 *
	 * @param gap_6 the new gap 6
	 */
	public void setGap_6(Integer gap_6) {
		this.gap_6 = gap_6;
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

}
