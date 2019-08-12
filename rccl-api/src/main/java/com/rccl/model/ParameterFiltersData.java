package com.rccl.model;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * The Class ParameterFiltersData.
 */
@JsonPOJOBuilder
public class ParameterFiltersData {

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
	
	/** The category. */
	private String category;
	
	/** The occupancy. */
	private String occupancy;
	
	/** The currency. */
	private String currency;
	
	/**
	 * Gets the metaproduct.
	 * @return the metaproduct
	 */
	public String getMetaproduct() {
		return metaproduct;
	}

	/**
	 * Sets the metaproduct.
	 * @param metaproduct the new metaproduct
	 */
	public void setMetaproduct(String metaproduct) {
		this.metaproduct = metaproduct;
	}

	/**
	 * Gets the product code.
	 * @return the product code
	 */
	public String getProduct_code() {
		return product_code;
	}

	/**
	 * Sets the product code.
	 * @param product_code the new product code
	 */
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	/**
	 * Gets the ship code.
	 * @return the ship code
	 */
	public String getShip_code() {
		return ship_code;
	}

	/**
	 * Sets the ship code.
	 * @param ship_code the new ship code
	 */
	public void setShip_code(String ship_code) {
		this.ship_code = ship_code;
	}

	/**
	 * Gets the sail month.
	 * @return the sail month
	 */
	public Integer getSail_month() {
		return sail_month;
	}

	/**
	 * Sets the sail month.
	 * @param sail_month the new sail month
	 */
	public void setSail_month(Integer sail_month) {
		this.sail_month = sail_month;
	}

	/**
	 * Gets the sail date.
	 * @return the sail date
	 */
	public String getSail_date() {
		return sail_date;
	}

	/**
	 * Sets the sail date.
	 * @param sail_date the new sail date
	 */
	public void setSail_date(String sail_date) {
		this.sail_date = sail_date;
	}

	/**
	 * Gets the cat class.
	 * @return the cat class
	 */
	public String getCat_class() {
		return cat_class;
	}

	/**
	 * Sets the cat class.
	 * @param cat_class the new cat class
	 */
	public void setCat_class(String cat_class) {
		this.cat_class = cat_class;
	}

	/**
	 * Gets the category.
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 * @param category the new category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Gets the occupancy.
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
	 * To string.
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ParameterFiltersData [metaproduct=" + metaproduct + ", product_code=" + product_code + ", ship_code="
				+ ship_code + ", sail_month=" + sail_month + ", sail_date=" + sail_date + ", cat_class=" + cat_class
				+ ", category=" + category + ", occupancy=" + occupancy + ", currency=" + currency + "]";
	}
}
