package com.rccl.model;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;


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

	public String getMetaproduct() {
		return metaproduct;
	}

	public void setMetaproduct(String metaproduct) {
		this.metaproduct = metaproduct;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getShip_code() {
		return ship_code;
	}

	public void setShip_code(String ship_code) {
		this.ship_code = ship_code;
	}

	public String getSail_month() {
		return sail_month;
	}

	public void setSail_month(String sail_month) {
		this.sail_month = sail_month;
	}

	public String getSail_date() {
		return sail_date;
	}

	public void setSail_date(String sail_date) {
		this.sail_date = sail_date;
	}

	public String getCat_class() {
		return cat_class;
	}

	public void setCat_class(String cat_class) {
		this.cat_class = cat_class;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOccupancy() {
		return occupancy;
	}

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
