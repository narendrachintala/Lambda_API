package com.rccl.model;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;


/**
 * The Class ParameterFiltersData.
 */
@JsonPOJOBuilder
public class ParameterFiltersData {

	private String metaproduct;
	private String product_code;
	private String ship_code;
	private String sail_month;
	private String sail_date;
	private String cat_class;
	private String category;
	private String occupancy;

	/**
	 * @return the metaproduct
	 */
	public String getMetaproduct() {
		return metaproduct;
	}
	/**
	 * @param metaproduct the metaproduct to set
	 */
	public void setMetaproduct(String metaproduct) {
		this.metaproduct = metaproduct;
	}
	/**
	 * @return the product_code
	 */
	public String getProduct_code() {
		return product_code;
	}
	/**
	 * @param product_code the product_code to set
	 */
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	/**
	 * @return the ship_code
	 */
	public String getShip_code() {
		return ship_code;
	}
	/**
	 * @param ship_code the ship_code to set
	 */
	public void setShip_code(String ship_code) {
		this.ship_code = ship_code;
	}
	/**
	 * @return the sail_month
	 */
	public String getSail_month() {
		return sail_month;
	}
	/**
	 * @param sail_month the sail_month to set
	 */
	public void setSail_month(String sail_month) {
		this.sail_month = sail_month;
	}
	/**
	 * @return the sail_date
	 */
	public String getSail_date() {
		return sail_date;
	}
	/**
	 * @param sail_date the sail_date to set
	 */
	public void setSail_date(String sail_date) {
		this.sail_date = sail_date;
	}
	/**
	 * @return the cat_class
	 */
	public String getCat_class() {
		return cat_class;
	}
	/**
	 * @param cat_class the cat_class to set
	 */
	public void setCat_class(String cat_class) {
		this.cat_class = cat_class;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the occupancy
	 */
	public String getOccupancy() {
		return occupancy;
	}
	/**
	 * @param occupancy the occupancy to set
	 */
	public void setOccupancy(String occupancy) {
		this.occupancy = occupancy;
	}
	@Override
	public String toString() {
		return "ParameterFiltersData [metaproduct=" + metaproduct + ", product_code=" + product_code + ", ship_code="
				+ ship_code + ", sail_month=" + sail_month + ", sail_date=" + sail_date + ", cat_class=" + cat_class
				+ ", category=" + category + ", occupancy=" + occupancy + "]";
	}

}
