package com.rccl.model;

/**
 * 
 * @author narendra.chintala
 *
 */
public class PriceRangeDTO {

	private String currency;
	private String METAPRODUCT;
	private String PRODUCT_CODE;
	private String SHIP_CODE;
	private Integer SAIL_MONTH;
	private String SAIL_DATE;
	private String CAT_CLASS;
	private String OCCUPANCY;
	private Double L1_RANGE_MIN;
	private Double L1_RANGE_MAX;
	private String L1_INSERT_DATE;
	private Double L2_RANGE_MIN;
	private Double L2_RANGE_MAX;
	private String L2_INSERT_DATE;
	private String USER_ID;

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getMETAPRODUCT() {
		return METAPRODUCT;
	}

	public void setMETAPRODUCT(String mETAPRODUCT) {
		METAPRODUCT = mETAPRODUCT;
	}

	public String getPRODUCT_CODE() {
		return PRODUCT_CODE;
	}

	public void setPRODUCT_CODE(String pRODUCT_CODE) {
		PRODUCT_CODE = pRODUCT_CODE;
	}

	public String getSHIP_CODE() {
		return SHIP_CODE;
	}

	public void setSHIP_CODE(String sHIP_CODE) {
		SHIP_CODE = sHIP_CODE;
	}

	public Integer getSAIL_MONTH() {
		return SAIL_MONTH;
	}

	public void setSAIL_MONTH(Integer sAIL_MONTH) {
		SAIL_MONTH = sAIL_MONTH;
	}

	public String getSAIL_DATE() {
		return SAIL_DATE;
	}

	public void setSAIL_DATE(String sAIL_DATE) {
		SAIL_DATE = sAIL_DATE;
	}

	public String getCAT_CLASS() {
		return CAT_CLASS;
	}

	public void setCAT_CLASS(String cAT_CLASS) {
		CAT_CLASS = cAT_CLASS;
	}

	public String getOCCUPANCY() {
		return OCCUPANCY;
	}

	public void setOCCUPANCY(String oCCUPANCY) {
		OCCUPANCY = oCCUPANCY;
	}

	public Double getL1_RANGE_MIN() {
		return L1_RANGE_MIN;
	}

	public void setL1_RANGE_MIN(Double l1_RANGE_MIN) {
		L1_RANGE_MIN = l1_RANGE_MIN;
	}

	public Double getL1_RANGE_MAX() {
		return L1_RANGE_MAX;
	}

	public void setL1_RANGE_MAX(Double l1_RANGE_MAX) {
		L1_RANGE_MAX = l1_RANGE_MAX;
	}

	public String getL1_INSERT_DATE() {
		return L1_INSERT_DATE;
	}

	public void setL1_INSERT_DATE(String l1_INSERT_DATE) {
		L1_INSERT_DATE = l1_INSERT_DATE;
	}

	public Double getL2_RANGE_MIN() {
		return L2_RANGE_MIN;
	}

	public void setL2_RANGE_MIN(Double l2_RANGE_MIN) {
		L2_RANGE_MIN = l2_RANGE_MIN;
	}

	public Double getL2_RANGE_MAX() {
		return L2_RANGE_MAX;
	}

	public void setL2_RANGE_MAX(Double l2_RANGE_MAX) {
		L2_RANGE_MAX = l2_RANGE_MAX;
	}

	public String getL2_INSERT_DATE() {
		return L2_INSERT_DATE;
	}

	public void setL2_INSERT_DATE(String l2_INSERT_DATE) {
		L2_INSERT_DATE = l2_INSERT_DATE;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

}
