package com.rccl.lambda.handler;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.rccl.dto.PauseParaDTO;
import com.rccl.model.ParameterFiltersData;
import com.rccl.service.PauseParaDataService;

/**
 * 
 * The Class PauseParaFiltersDataHandler.
 * 
 * Here PauseParaFiltersDataHandler implements RequestHandler where we will raise request
 */
public class PauseParaFiltersDataHandler implements RequestHandler<ParameterFiltersData, List<PauseParaDTO>> {

	/*
	 *  (non-Javadoc)
	 * @see com.amazonaws.services.lambda.runtime.RequestHandler#handleRequest(java.lang.Object, com.amazonaws.services.lambda.runtime.Context)
	 * 
	 */
	public List<PauseParaDTO> handleRequest(ParameterFiltersData request, Context context) {
		PauseParaDataService pauseParaService = new PauseParaDataService();
		List<PauseParaDTO> pauseParaList = pauseParaService.getPauseParaData(request);

		Gson gson = new Gson();
		System.out.println(gson.toJson(pauseParaList));

		return pauseParaList;

	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * 
	 * generating sample data and sending it as request to PauseParaFiltersDataHandler.
	 * 
	 * 
	 */
	public static void main(String[] args) {
		ParameterFiltersData parameterFiltersData = new ParameterFiltersData();
		parameterFiltersData.setCat_class("N");
		parameterFiltersData.setCategory("double");
		parameterFiltersData.setMetaproduct("OASIS");
		parameterFiltersData.setOccupancy("quad");
		parameterFiltersData.setProduct_code("7N CARIBBEAN");
		parameterFiltersData.setSail_month(10);
		parameterFiltersData.setShip_code("HM");
		new PauseParaFiltersDataHandler().handleRequest(parameterFiltersData, null);
	}

}
