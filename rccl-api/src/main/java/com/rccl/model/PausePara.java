package com.rccl.model;

public class PausePara extends FiltersData{

	private Double l1_pause;
	private Double l1_insert_date;
	

	public Double getl1_pause() {
		return l1_pause;
	}
	
	public void setl1_pause(Double l1_pause) {
		this.l1_pause = l1_pause;
	}


	public void setL1_range_max(Double l1_insert_date) {
		this.l1_insert_date = l1_insert_date;
	}

	public Double getL1_insert_date() {
		return l1_insert_date;
	}


}
