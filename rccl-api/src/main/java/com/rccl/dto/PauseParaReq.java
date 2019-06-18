package com.rccl.dto;

import java.util.List;
import java.util.Map;

public class PauseParaReq {

	private Map<String, List<String>> filters;
	private Double l1_pause;
	private Double l1_insert_date;
	

	public Map<String, List<String>> getFilters() {
		return filters;
	}

	public void setFilters(Map<String, List<String>> filters) {
		this.filters = filters;
	}

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
