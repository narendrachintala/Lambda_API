package com.rccl.model;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * The Class CurrencyGapPara.
 * 
 * @author : chandrabhan.birla
 */
@JsonPOJOBuilder
public class CurrencyGapPara {

	/** The filter data. */
	private ParameterFiltersData filtersData;

	/** The currency 1. */
	private String currency1;
	
	/** The gap 1. */
	private Double gap1;
	
	/** The currency 2. */
	private String currency2;
	
	/** The gap 2. */
	private Double gap2;
	
	/** The currency 3. */
	private String currency3;
	
	/** The gap 3. */
	private Double gap3;
	
	/** The insert date. */
	private String insert_date;
	
	/** The user id. */
	private String user_id;
	
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
	 * Gets the currency 1.
	 *
	 * @return the currency 1
	 */
	public String getCurrency1() {
		return currency1;
	}
	
	/**
	 * Sets the currency 1.
	 *
	 * @param currency1 the new currency 1
	 */
	public void setCurrency1(String currency1) {
		this.currency1 = currency1;
	}
	
	/**
	 * Gets the gap 1.
	 *
	 * @return the gap 1
	 */
	public Double getGap1() {
		return gap1;
	}
	
	/**
	 * Sets the gap 1.
	 *
	 * @param gap1 the new gap 1
	 */
	public void setGap1(Double gap1) {
		this.gap1 = gap1;
	}
	
	/**
	 * Gets the currency 2.
	 *
	 * @return the currency 2
	 */
	public String getCurrency2() {
		return currency2;
	}
	
	/**
	 * Sets the currency 2.
	 *
	 * @param currency2 the new currency 2
	 */
	public void setCurrency2(String currency2) {
		this.currency2 = currency2;
	}
	
	/**
	 * Gets the gap 2.
	 *
	 * @return the gap 2
	 */
	public Double getGap2() {
		return gap2;
	}
	
	/**
	 * Sets the gap 2.
	 *
	 * @param gap2 the new gap 2
	 */
	public void setGap2(Double gap2) {
		this.gap2 = gap2;
	}
	
	/**
	 * Gets the currency 3.
	 *
	 * @return the currency 3
	 */
	public String getCurrency3() {
		return currency3;
	}
	
	/**
	 * Sets the currency 3.
	 *
	 * @param currency3 the new currency 3
	 */
	public void setCurrency3(String currency3) {
		this.currency3 = currency3;
	}
	
	/**
	 * Gets the gap 3.
	 *
	 * @return the gap 3
	 */
	public Double getGap3() {
		return gap3;
	}
	
	/**
	 * Sets the gap 3.
	 *
	 * @param gap3 the new gap 3
	 */
	public void setGap3(Double gap3) {
		this.gap3 = gap3;
	}
	
	/**
	 * Gets the insert date.
	 *
	 * @return the insert date
	 */
	public String getInsert_date() {
		return insert_date;
	}
	
	/**
	 * Sets the insert date.
	 *
	 * @param insert_date the new insert date
	 */
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	
	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * To string.
	 * @return the string
	 */
	@Override
	public String toString() {
		return "CurrencyGapPara [filtersData=" + filtersData + ", currency1=" + currency1 + ", gap1=" + gap1
				+ ", currency2=" + currency2 + ", gap2=" + gap2 + ", currency3=" + currency3 + ", gap3=" + gap3
				+ ", insert_date=" + insert_date + ", user_id=" + user_id + "]";
	}
}
