package com.rccl.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.rccl.dto.CurrentPriceParaDTO;
import com.rccl.model.CurrentPricePara;
import com.rccl.model.ParameterFiltersData;
import com.rccl.repo.CurrentPriceParaRepo;

/**
 * 
 * @author chandrabhan.birla
 *
 */
public class CurrentPriceParaService {
	// Initialize the Log4j logger.
	static final Logger logger = LogManager.getLogger(PriceRangeService.class);

	/**
	 * @param request  contains end user chosen filter criteria
	 * @param lambdaLogger
	 * @return returns final current price parameter data with applied criteria
	 */
	public List<CurrentPriceParaDTO> getCurrentPriceParaData(ParameterFiltersData request, Logger logger) {
		List<CurrentPriceParaDTO> currentPriceParaData = null;
		try {
			CurrentPriceParaRepo repo = new CurrentPriceParaRepo();
			currentPriceParaData = repo.getCurrentPriceData(request, logger);

		} catch (Exception e) {
			logger.error("Error occurred while executing getCurrentPriceParaData: " + e);
			throw e;
		}
		return currentPriceParaData;
	}

	/**
	 * @param currentPriceParaReq
	 * @param logger
	 * @return
	 */
	public boolean updateCurrentPriceParaData(CurrentPricePara currentPriceParaReq, Logger logger) {
		CurrentPriceParaRepo currentPriceParaRepo = null;
		boolean status = false;
		try {
			currentPriceParaRepo = new CurrentPriceParaRepo();
			status = currentPriceParaRepo.updateCurrentPriceData(currentPriceParaReq, logger);
		} catch (Exception e) {
			logger.error("Error occurred while executing updateCurrentPriceParaData: " + e);
			throw e;
		}
		return status;
	}

}
