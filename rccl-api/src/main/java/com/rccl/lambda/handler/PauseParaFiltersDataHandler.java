package com.rccl.lambda.handler;

import java.util.List;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.rccl.dto.PauseParaDTO;
import com.rccl.service.PauseParaDataService;
import com.rccl.testdata.FiltersData;

/**
 * The Class PauseParaFiltersDataHandler.
 */
public class PauseParaFiltersDataHandler implements RequestHandler<Map<String, List<String>>, List<PauseParaDTO>> {

	/* (non-Javadoc)
	 * @see com.amazonaws.services.lambda.runtime.RequestHandler#handleRequest(java.lang.Object, com.amazonaws.services.lambda.runtime.Context)
	 * 
	 */
	public List<PauseParaDTO> handleRequest(Map<String, List<String>> request, Context context) {
		PauseParaDataService PauseParaService = new PauseParaDataService();
		List<PauseParaDTO> pauseParaList = PauseParaService.getPauseParaData(request);

		Gson gson = new Gson();
		System.out.println(gson.toJson(pauseParaList));

		return pauseParaList;

	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		new PauseParaFiltersDataHandler().handleRequest(FiltersData.getRequestData(), null);
	}

}
