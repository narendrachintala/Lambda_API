package com.rccl.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.dto.InversionGapsParaDTO;
import com.rccl.model.InversionGapPara;
import com.rccl.model.ParameterFiltersData;
import com.rccl.repo.InversionGapParaRepo;

public class InversionGapParaService {
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(PriceRangeService.class);

	/**
	 * @param request      contains end user chosen filter criteria
	 * @param lambdaLogger
	 * @return returns final price range parameter data with applied criteria
	 */
	public List<InversionGapsParaDTO> getinversionGapParaData(ParameterFiltersData request) {
		List<InversionGapsParaDTO> inversionGapParaData = null;
		try {
			InversionGapParaRepo repo = new InversionGapParaRepo();
			inversionGapParaData = repo.getInvesionGapPara(request);//getPriceRangeData(request);

		} catch (Exception e) {
			throw e;
		}
		return inversionGapParaData;
	}
	/**
	 * @param priceRangeReq
	 * @param logger
	 * @return
	 */
	public boolean updatePriceRangeData(InversionGapPara inversionGapParaReq) {
		//PriceRangeRepo priceRangeRepo = null;
		boolean status = false;
		try {
		//	priceRangeRepo = new PriceRangeRepo();
		//	status = priceRangeRepo.updatePriceRangeData(priceRangeReq);
		} catch (Exception e) {
			// logger.error("Error occured while executing updatePriceRangeData: " + e);
			throw e;
		}
		return status;
	}
}
