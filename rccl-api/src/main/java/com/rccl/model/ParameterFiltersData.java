package com.rccl.model;

import java.util.Date;

public class ParameterFiltersData{

	private String metaproduct;
	private String product_code;
	private String ship_code;
	private Integer sail_month;
	private Date sail_date;
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

	public Integer getSail_month() {
		return sail_month;
	}

	public void setSail_month(Integer sail_month) {
		this.sail_month = sail_month;
	}

	public Date getSail_date() {
		return sail_date;
	}

	public void setSail_date(Date sail_date) {
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

}
