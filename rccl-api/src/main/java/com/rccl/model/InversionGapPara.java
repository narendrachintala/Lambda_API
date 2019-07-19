package com.rccl.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class InversionGapPara.
 */
@JsonPOJOBuilder
public class InversionGapPara {
	
	/** The filters data. */
	private ParameterFiltersData filtersData;
	
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
	private Integer gap1;
	
	/** The gap 2. */
	private Integer gap2;
	
	/** The gap 3. */
	private Integer gap3;
	
	/** The gap 4. */
	private Integer gap4;
	
	/** The gap 5. */
	private Integer gap5;
	
	/** The gap 6. */
	private Integer gap6;
	
	/** The gap 6. */
	private Timestamp insert_date;
	
	/**
	 * Gets the filters data.
	 *
	 * @return the filters data
	 */
	public ParameterFiltersData getFiltersData() {
		return filtersData;
	}
	
	/**
	 * Sets the filters data.
	 *
	 * @param filtersData the new filters data
	 */
	public void setFiltersData(ParameterFiltersData filtersData) {
		this.filtersData = filtersData;
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
	public Integer getGap1() {
		return gap1;
	}
	
	/**
	 * Sets the gap 1.
	 *
	 * @param gap1 the new gap 1
	 */
	public void setGap1(Integer gap1) {
		this.gap1 = gap1;
	}
	
	/**
	 * Gets the gap 2.
	 *
	 * @return the gap 2
	 */
	public Integer getGap2() {
		return gap2;
	}
	
	/**
	 * Sets the gap 2.
	 *
	 * @param gap2 the new gap 2
	 */
	public void setGap2(Integer gap2) {
		this.gap2 = gap2;
	}
	
	/**
	 * Gets the gap 3.
	 *
	 * @return the gap 3
	 */
	public Integer getGap3() {
		return gap3;
	}
	
	/**
	 * Sets the gap 3.
	 *
	 * @param gap3 the new gap 3
	 */
	public void setGap3(Integer gap3) {
		this.gap3 = gap3;
	}
	
	/**
	 * Gets the gap 4.
	 *
	 * @return the gap 4
	 */
	public Integer getGap4() {
		return gap4;
	}
	
	/**
	 * Sets the gap 4.
	 *
	 * @param gap4 the new gap 4
	 */
	public void setGap4(Integer gap4) {
		this.gap4 = gap4;
	}
	
	/**
	 * Gets the gap 5.
	 *
	 * @return the gap 5
	 */
	public Integer getGap5() {
		return gap5;
	}
	
	/**
	 * Sets the gap 5.
	 *
	 * @param gap5 the new gap 5
	 */
	public void setGap5(Integer gap5) {
		this.gap5 = gap5;
	}
	
	/**
	 * Gets the gap 6.
	 *
	 * @return the gap 6
	 */
	public Integer getGap6() {
		return gap6;
	}
	
	/**
	 * Sets the gap 6.
	 *
	 * @param gap6 the new gap 6
	 */
	public void setGap6(Integer gap6) {
		this.gap6 = gap6;
	}
	/**
	 * Gets the insert_date.
	 *
	 * @return the insert_date
	 */
	public Timestamp getinsert_date() {
		return insert_date;
	}

	/**
	 * Sets the insert_date.
	 *
	 * @param insert_date the new insert_date date
	 */
	public void setL1_insert_date(Timestamp insert_date) {
		this.insert_date = insert_date;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InversionGapPara [filterData=" + filtersData + ", order_1=" + order_1 +", order_2=" + order_2 +", order_3=" + order_3 +", order_4=" + order_4 +", order_5=" + order_5 +", order_6=" + order_6 +", gap1=" + gap1 +", gap2=" + gap2 +", gap3=" + gap3 +
		", gap4=" + gap4 +", gap5=" + gap5 +", gap6=" + gap6 +", insert_date=" + insert_date +"]";
		}
	
}
